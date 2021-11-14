-- Q1. WRITE A QUERY TO DISPLAY FULL NAME ( FIRST_NAME , LAST_NAME) , EMAIL ,MANAGER_ID FROM EMPLOYEES TABLE.
SELECT CONCAT(first_name, ' ', last_name) full_name,
       email,
       manager_id
  FROM employees;

-- Q2. WRITE A QUERY TO DISPLAY FULL NAME ( FIRST_NAME , LAST_NAME ) , EMAIL , JOB_ID , SALARY FROM EMPLOYEES TABLE WHERE EMPLOYEES ARE JOINS IN THE YEAR OF 	     1990.
SELECT CONCAT(first_name, ' ', last_name) full_name,
       email,
       job_id,
       salary
  FROM employees
 WHERE YEAR(hire_date) = '1990';

-- Q3. WRITE A QUERY TO DISPALY THE NUMBER OF EMPLOYEES IN EACH DEPARTMENTS.
  SELECT d.department_id,
         d.department_name,
         COUNT(employee_id) number_of_employees
    FROM employees e JOIN departments d
      ON e.department_id = d.department_id
GROUP BY department_id;

-- Q4. WRITE A QUERY TO DISPLAY FIRST_NAME , LAST_NAME , EMAIL , PHONE_NUMBER , DEPARTMENT_ID , DEPARTMENT_NAME FROM EMPLOYEES .
SELECT first_name,
       last_name,
       email,
       phone_number,
       department_id,
       department_name
  FROM employees NATURAL JOIN departments;

-- Q5. WRITE A QUERY TO DISPALY THE EMPLOYEES FIRST_NAME , LAST_NAME WHOSE FIRST_NAME START WITH 'S'
SELECT first_name,
       last_name
  FROM employees
 WHERE first_name LIKE 's%';

-- Q6. WRITE A QUERY TO DISPLAY THE EMPLOYEES FIRST_NAME , CITY IN CAPITAL LATTERS.
      SELECT UPPER(first_name),
             UPPER(city)
        FROM employees
NATURAL JOIN departments
NATURAL JOIN locations;

-- Q7.  CREATE A STORED PROCEDURE TO CHECK WHETHER GIVEN NUMBER IS ODD OR EVEN.
DELIMITER #
DROP PROCEDURE IF EXISTS is_even#
CREATE PROCEDURE is_even (IN p_no INT)
BEGIN
    IF(p_no % 2 = 0)
    THEN
        SELECT "NUMBER IS EVEN";
    ELSE
        SELECT "NUMBER IS ODD";
    END IF;
END#

CALL is_even(100);

-- Q8.  CREATE A FUNCTION WHICH WILL CHECK THE GIVEN NUMBER IS POSITIVE OR NEGATIVE OR ZERO.
DELIMITER #
DROP FUNCTION IF EXISTS f_sign#
CREATE FUNCTION f_sign(p_no INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    IF p_no > 0 THEN
        RETURN "POSITIVE";
    ELSEIF p_no < 0 THEN
        RETURN "NEGATIVE";
    ELSE
        RETURN "ZERO";
    END IF;
END#

SELECT f_sign(-1);

-- Q9. CREATE A STORED PROCEDURE WHICH WILL RETURNS COMMA SEPERATED LIST OF EMPLOYEES FIRST_NAME .
DELIMITER #
DROP PROCEDURE IF EXISTS list_emp#
CREATE PROCEDURE list_emp()
BEGIN
    SELECT GROUP_CONCAT(first_name) emp_list
      FROM employees;
END#

CALL list_emp();
