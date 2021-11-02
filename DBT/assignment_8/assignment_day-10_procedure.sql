-- 1. Prepare a program which can perform following operation
-- 	- Lookout for tables which has missing constraints
-- 	- Display list of those tables
DELIMITER #
DROP PROCEDURE IF EXISTS table_without_constraint #
CREATE PROCEDURE table_without_constraint ()
BEGIN
	SELECT `TABLE_NAME`
 	  FROM information_schema.`TABLES`
	 WHERE `TABLE_NAME` NOT IN (SELECT DISTINCT tc.`TABLE_NAME`
                                  FROM information_schema.`TABLE_CONSTRAINTS` tc JOIN information_schema.`KEY_COLUMN_USAGE` kcu
                                    ON tc.`TABLE_SCHEMA` = kcu.`TABLE_SCHEMA`
                                 WHERE tc.`TABLE_SCHEMA` = (SELECT DATABASE()))
                                   AND `TABLE_SCHEMA` = (SELECT DATABASE());
END#

CALL dac_dbt.table_without_constraint(); 
--
-- 2. Prepare a program to delete the data from emp. It will receive two inputs employee number and employee name. If employee number is passed as null then delete the data based on employee name.
-- Backup the deleted data to employee_backup table.
DELIMITER //
DROP PROCEDURE IF EXISTS backup_and_delete_emp;
CREATE PROCEDURE backup_and_delete_emp
(
	IN p_empno INT,
    IN p_ename VARCHAR(10)
)
BEGIN
    CREATE TABLE IF NOT EXISTS `employee_backup` LIKE `EMP`;
    
    IF p_empno IS NOT NULL
    THEN
    -- Inserting into backup table
        INSERT INTO `employee_backup`
        SELECT *
        FROM `EMP` e
        WHERE e.`EMPNO` = p_empno;

        -- Deleting record from table
        DELETE FROM `EMP`e
        WHERE e.`EMPNO` = p_empno;
    ELSE
        -- Inserting into backup table
        INSERT INTO `employee_backup`
        SELECT *
        FROM `EMP` e
        WHERE e.`ENAME` = p_ename;

        -- Deleting record from table
        DELETE FROM `EMP`e
        WHERE e.`ENAME` = p_ename;
    END IF;
END//

-- 3. Prepare a program to insert new record in employee table. it will take the input of employee data.
-- If salary is provided as null then consider the salary as highest salary earned by any employee in same department. If comm is not provided then assume it as 200$
DELIMITER //
DROP PROCEDURE IF EXISTS insert_emp//
CREATE PROCEDURE insert_emp
(
    IN p_empno INT UNSIGNED,
    IN p_ename VARCHAR(10),
    IN p_job VARCHAR(9),
    IN p_mgr INT UNSIGNED,
    IN p_hiredate DATE,
    IN p_sal DECIMAL(8,2),
    IN p_comm DECIMAL(8,2),
    IN p_dept INT UNSIGNED
)
BEGIN
    IF p_sal IS NULL
    THEN
        SET p_sal = (SELECT MAX(`SAL`)
                     FROM `EMP` e
                    WHERE e.`DEPTNO` = p_dept
                 GROUP BY e.`DEPTNO`);
    END IF;

    IF p_comm IS NULL
    THEN
        SET p_comm = 200;
    END IF;

    INSERT INTO `EMP`
    VALUES(p_empno, UPPER(p_ename), UPPER(p_job), p_mgr, p_hiredate, p_sal, p_comm, p_dept);
END//

-- 4. Prepare a program to receive the input as table name and column name. Add primary key constraint on provided table's column.
DELIMITER //
DROP PROCEDURE IF EXISTS create_primary//
CREATE PROCEDURE create_primary
(
    IN p_table VARCHAR(64),
    IN p_column VARCHAR(64)
)
BEGIN
    SET @query = CONCAT("ALTER TABLE ", p_table, " ADD PRIMARY KEY (", p_column, ")");
    PREPARE pk_alter_statement FROM @query;
    EXECUTE pk_alter_statement;
    DEALLOCATE PREPARE pk_alter_statement;
END//

-- 5. Prepare a program to list those employee who are earning less then avg of there deparment. This program may take input as (p_salary_fix BOOLEAN). If the input is given as true then these employees salary must be set to AVG Salary + 100$.
DELIMITER //
DROP PROCEDURE IF EXISTS update_salary//
CREATE PROCEDURE update_salary
(
    IN p_salary_fix BOOLEAN
)
BEGIN
    -- Listing employees earning less than department's average
    SELECT ENAME
    FROM EMP e
    WHERE SAL < (SELECT AVG(SAL)
                 FROM EMP
                 WHERE DEPTNO = e.DEPTNO
                 GROUP BY DEPTNO);

    -- Updating salary to average saly of department + 100 if asked
    IF p_salary_fix THEN
        UPDATE EMP JOIN (SELECT DEPTNO, ROUND(AVG(SAL)) AVGSAL
                           FROM EMP
                       GROUP BY DEPTNO) s
                   USING (DEPTNO)
           SET SAL = (AVGSAL + 100)
         WHERE EMPNO IN (SELECT e.EMPNO
                           FROM (SELECT * FROM EMP) AS e
                          WHERE e.SAL < (SELECT AVG(a.SAL)
                                           FROM (SELECT * FROM EMP) AS a
                                       GROUP BY a.DEPTNO
                                         HAVING a.DEPTNO = e.DEPTNO));
    END IF;
END//



