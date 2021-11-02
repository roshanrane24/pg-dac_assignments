-- Cursors
-- ---------
/*
1. Prepare a program to display the comma separated list of employee names in following format

   Deptno    Employees
   -------   ------------
   10        Scott, Smith, Jones
   20        Allen, Ford
   30 
*/
DELIMITER //

DROP FUNCTION IF EXISTS employees_in_department;
CREATE FUNCTION employees_in_department
(
    p_deptno INT UNSIGNED
)
RETURNS VARCHAR(2048)
DETERMINISTIC
BEGIN
    DECLARE v_emplist VARCHAR(2048);
    DECLARE v_empname VARCHAR(40);
    DECLARE v_found BOOLEAN DEFAULT FALSE;

    DECLARE c_emp CURSOR FOR SELECT ENAME
                              FROM EMP
                             WHERE DEPTNO = p_deptno;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_found = TRUE;

    OPEN c_emp;

    cur_loop : LOOP
        FETCH c_emp INTO v_empname;

        IF v_found THEN
            LEAVE cur_loop;
        END IF;

        IF v_emplist IS NULL THEN
            SET v_emplist = v_empname;
        ELSE
            SET v_emplist = CONCAT(v_emplist, ",", v_empname);
        END IF;

    END LOOP;

    CLOSE c_emp;
    
    IF v_emplist IS NULL THEN
        SET v_emplist = 'Employees Not Found';
    END IF;

    RETURN v_emplist;
END//

DELIMITER //
DROP PROCEDURE IF EXISTS list_of_emp//
CREATE PROCEDURE list_of_emp()
BEGIN
    DECLARE v_done BOOLEAN DEFAULT FALSE;
    DECLARE v_dept INT UNSIGNED;

    DECLARE cur_dept CURSOR FOR SELECT DEPTNO
                           FROM DEPT;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = TRUE;

    CREATE TEMPORARY TABLE t_dept SELECT DEPTNO AS Deptno
                                    FROM DEPT;

    ALTER TABLE t_dept
    ADD COLUMN employees VARCHAR(2048);

    OPEN cur_dept;

    dept_loop : LOOP
        FETCH cur_dept INTO v_dept;

        IF v_done THEN
            LEAVE dept_loop;
        END IF;

        UPDATE t_dept
        SET employees = employees_in_department(v_dept)
        WHERE DEPTNO = v_dept;

    END LOOP;

    CLOSE cur_dept;

    SELECT * FROM t_dept;

    DROP TABLE t_dept;
END//

/*
2. Prepare a program to show the details in following format

    Deptno   Dname      Employees
	-------  -------    -------------
	10        SALES     Scott, Smith, Jones
*/
DELIMITER //
DROP PROCEDURE IF EXISTS list_of_dept//
CREATE PROCEDURE list_of_dept()
BEGIN
    DECLARE v_done BOOLEAN DEFAULT FALSE;
    DECLARE v_dept INT UNSIGNED;

    DECLARE cur_dept CURSOR FOR SELECT DEPTNO
                           FROM DEPT;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = TRUE;

    CREATE TEMPORARY TABLE t_dept SELECT DEPTNO AS Deptno
                                         DNAME AS Dname
                                    FROM DEPT;

    ALTER TABLE t_dept
    ADD COLUMN employees VARCHAR(2048);

    OPEN cur_dept;

    dept_loop : LOOP
        FETCH cur_dept INTO v_dept;

        IF v_done THEN
            LEAVE dept_loop;
        END IF;

        UPDATE t_dept
        SET employees = employees_in_department(v_dept)
        WHERE DEPTNO = v_dept;

    END LOOP;

    CLOSE cur_dept;

    SELECT * FROM t_dept;

    DROP TABLE t_dept;
END//

/*
3. For performance testing we are trying to increase number of records by 10 times for each department. For eg: If there are 3 employees in dept 10 then we should be able to increase the employee count to 30 using same / random values 

eg:

+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |


should become


+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7783 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7784 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7785 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7786 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7787 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
...........
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7840 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7841 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7842 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7843 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7844 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
...........
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
*/

DELIMITER //
DROP PROCEDURE IF EXISTS multiply_records//
CREATE PROCEDURE multiply_records()
BEGIN
    DECLARE v_ename VARCHAR(10);
    DECLARE v_job VARCHAR(9);
    DECLARE v_mgr INT UNSIGNED;
    DECLARE v_hiredate DATE;
    DECLARE v_sal DECIMAL(6, 2);
    DECLARE v_comm DECIMAL(6, 2);
    DECLARE v_dept INT UNSIGNED;
    DECLARE v_done BOOLEAN DEFAULT FALSE;
    DECLARE v_ins_count INT UNSIGNED;

    DECLARE cur_emp CURSOR FOR SELECT ENAME, JOB, MGR,
                                      HIREDATE, SAL, COMM, DEPTNO
                                 FROM EMP;
    DECLARE EXIT HANDLER FOR NOT FOUND SET v_done = TRUE;

    ALTER TABLE EMP
    MODIFY EMPNO INT UNSIGNED AUTO_INCREMENT;

    OPEN cur_emp;

    emp_loop : LOOP
        FETCH cur_emp INTO v_ename, v_job, v_mgr, v_hiredate, v_sal, v_comm, v_dept;

        IF v_done THEN
            LEAVE emp_loop;
        END IF;

        SET v_ins_count = 9;

        ins_loop : WHILE v_ins_count > 0 DO
            INSERT INTO EMP (ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
            VALUES (v_ename, v_job, v_mgr, v_hiredate, v_sal, v_comm, v_dept);

            SET v_ins_count = v_ins_count - 1;
        END WHILE ins_loop;

    END LOOP emp_loop;
END//

/*
-- 4. Prepare a program to create clone of all tables in given schema
*/

DELIMITER //
DROP PROCEDURE IF EXISTS clone_tables//
CREATE PROCEDURE clone_tables(
    IN v_schema VARCHAR(64)
)
BEGIN
    DECLARE v_table VARCHAR(64);
    DECLARE cur_tables CURSOR FOR SELECT TABLE_NAME
                                    FROM information_schema.TABLES
                                   WHERE TABLE_SCHEMA = v_schema;

    OPEN cur_tables;

    -- Creating clone of tables with '_clone' as suffix
    clone_loop : LOOP
        FETCH cur_tables INTO v_table;

        SET @table_query = CONCAT ("CREATE TABLE ", v_schema, ".", v_table, "_clone ",
                                   "SELECT * FROM ", v_schema, ".", v_table);
        PREPARE ct_stmt FROM @table_query;
        EXECUTE ct_stmt;
        DEALLOCATE PREPARE ct_stmt;
    END LOOP;
END//
