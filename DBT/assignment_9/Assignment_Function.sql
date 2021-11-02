-- Functions

-- 1. Write a program to take the input as empno and return the experience of employee in terms of number of years.
DELIMITER //
DROP FUNCTION IF EXISTS experience_of_employee;
CREATE FUNCTION experience_of_employee
(
    p_empno INT UNSIGNED
)
RETURNS INT UNSIGNED
DETERMINISTIC
BEGIN
    DECLARE v_hiredate DATE;

    -- Getting hiredate of employee
    SELECT HIREDATE
      INTO v_hiredate
      FROM EMP
     WHERE EMPNO = p_empno;

    RETURN ABS(TIMESTAMPDIFF(YEAR, v_hiredate, SYSDATE()));
END//

-- 2. Write a program to take the input as deptno and return the comma separated list of employee names
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

    IF v_emplist IS NULL THEN
        SET v_emplist = 'Employees Not Found';
    END IF;

    RETURN v_emplist;
END//

-- 3. Add a new column incentive to emp table. Write a program to calculate and update the incentive using following logic.
--      If employees salary is more then avg salary of dept then incentive is 0
-- 	 If employees salary is less then avg salary of dept then incentive is 10% of salary

DELIMITER //
DROP FUNCTION IF EXISTS calc_incentive//
CREATE FUNCTION calc_incentive
(
    p_empno INT UNSIGNED
)
RETURNS INT UNSIGNED
DETERMINISTIC
BEGIN
    DECLARE v_emp_sal INT UNSIGNED DEFAULT (SELECT SAL
                                    FROM EMP
                                   WHERE EMPNO = p_empno);
    DECLARE v_emp_dpt INT UNSIGNED DEFAULT (SELECT DEPTNO
                                              FROM EMP
                                             WHERE EMPNO = p_empno);
    DECLARE v_emp_dpt_avgsal DECIMAL(6,2) UNSIGNED DEFAULT (SELECT AVG(SAL)
                                                     FROM EMP
                                                    WHERE DEPTNO = v_emp_dpt
                                                 GROUP BY DEPTNO);
    DECLARE v_incentive INT UNSIGNED;

    -- Calculating incentive
    IF v_emp_sal < v_emp_dpt_avgsal THEN
        SET v_incentive = v_emp_sal * 0.1;
    ELSE
        SET v_incentive = 0;
    END IF;

    RETURN v_incentive;
END//

DELIMITER //
DROP PROCEDURE IF EXISTS set_incentive//
CREATE PROCEDURE set_incentive()
BEGIN
    -- Adding insentive column
    ALTER TABLE `EMP`
    ADD INCENTIVE INT UNSIGNED;

    -- updating incentive column using calc_incentive function
    UPDATE TABLE EMP
    SET INCENTIVE = calc_incentive(EMPNO);
END
-- 4. Write a program to get the count of employees working in provided deptno
DELIMITER //
DROP FUNCTION IF EXISTS count_of_emp//
CREATE FUNCTION count_of_emp
(
    p_deptno INT UNSIGNED
)
RETURNS INT UNSIGNED
DETERMINISTIC
BEGIN
    DECLARE v_count INT UNSIGNED;

    SET v_count = (SELECT COUNT(*)
                     FROM EMP
                    WHERE DEPTNO = p_deptno);
    RETURN v_count;
END//
