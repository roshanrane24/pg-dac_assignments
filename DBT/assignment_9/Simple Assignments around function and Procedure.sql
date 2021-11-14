/*
1. Write a PL/SQL program to arrange the number of two variable in such a way that the small number will store in num_small variable and large number will store in num_large variable.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS num_small_large#
CREATE PROCEDURE num_small_large (
  IN num1 INT,
  IN num2 INT
)
BEGIN
  DECLARE num_small INT;
  DECLARE num_large INT;

  IF num1 > num2 THEN
    SET num_small = num2;
    SET num_large = num1;
  ELSE
    SET num_small = num1;
    SET num_large = num2;
  END IF;

  SELECT num_small, num_large;
END #

/*
2. Write a PL/SQL program to check whether a number is even or odd.
*/

DELIMITER #
DROP PROCEDURE IF EXISTS even_odd#
CREATE PROCEDURE even_odd (
  IN num INT
)
BEGIN
  IF num % 2 = 0 THEN
    SELECT 'Number is even';
  ELSE
    SELECT 'Number is odd';
  END IF;
END#

/*
4. Write a PL/SQL procedure to calculate the total salary for specific employee.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS total_salary#
CREATE PROCEDURE total_salary(
  IN v_empno INT UNSIGNED
)
BEGIN
  SELECT ROUND(SAL + IFNULL(COMM, 0)) AS Total_Salary
    FROM EMP
   WHERE EMPNO = v_empno;
END#

/*
5. Write a PL/SQL program to check whether a date falls on weekend i.e. SATURDAY or SUNDAY.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS is_weekend#
CREATE PROCEDURE is_weekend (
  IN given_date DATE
)
BEGIN
  DECLARE day_of_week INT UNSIGNED;
  SET day_of_week = DAYOFWEEK(given_date);

  CASE day_of_week
    WHEN 1 THEN SELECT 'WEEKEND';
    WHEN 7 THEN SELECT 'WEEKEND';
    ELSE SELECT 'WEEKDAY';
  END CASE;
END#

/*
6. Write a PL/SQL program to count number of employees in provided department.
*/
DELIMITER #
DROP FUNCTION IF EXISTS no_of_emps#
CREATE FUNCTION no_of_emps (
  dept INT UNSIGNED
)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE emp_count INT UNSIGNED;
  SELECT COUNT(*) INTO emp_count
    FROM EMP
   WHERE DEPTNO = dept;
  RETURN emp_count;
END#

/*
7. Write a PL/SQL program to display the description against a grade.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS describe_grade #
CREATE PROCEDURE describe_grade ()
BEGIN
  DESCRIBE SALGRADE;
END#

/*
8. Write a PL/SQL program to count number of employees in a specific department and check whether this department have any vacancies or not (considering that each department has 45 head count requirement). If any vacancies, how many vacancies are in that department.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS head_count#
CREATE PROCEDURE head_count(
  IN dept INT UNSIGNED
)
BEGIN
  DECLARE emps INT UNSIGNED;

  SELECT COUNT(*) INTO emps
    FROM EMP
   WHERE DEPTNO = dept;

  IF emps >= 45 THEN
    SELECT 'No Vacancy' AS Vacancies;
  ELSE
    SELECT 45 - emps AS Vacancies;
  END IF;
END#

/*
9. Write a PL/SQL program to display the description against a grade using CASE statement.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS describe_grade_2#
CREATE PROCEDURE describe_grade_2(
)
BEGIN
END#

/*
10. Write a PL/SQL program to check whether a given number is positive, negative or zero.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS positive_negative_zero#
CREATE PROCEDURE positive_negative_zero (
  IN num INT
)
BEGIN
  IF num > 0 THEN
    SELECT 'Positive';
  ELSEIF num < 0 THEN
    SELECT 'Negative';
  ELSE
    SELECT 'Zero';
  END IF;
END#

/*
11. Write a PL/SQL program to check whether a given character is letter or digit.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS number_or_letter#
CREATE PROCEDURE number_or_letter (
  IN v_char CHAR(1)
)
BEGIN
  CASE
  WHEN v_char REGEXP '[A-z]' THEN SELECT 'Character';
  WHEN v_char REGEXP '[1-9]' THEN SELECT 'Number`';
  ELSE
    BEGIN
    END;
  END CASE;
END#

/*
12. Write a PL/SQL program to display which day is a specific date.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS show_day#
CREATE PROCEDURE show_day(
  IN given_date DATE
)
BEGIN
  DECLARE v_day INT;

  SET v_day = WEEKDAY(given_date);

  CASE v_day
  WHEN 6 THEN SELECT 'SUNDAY';
  WHEN 0 THEN SELECT 'MONDAY';
  WHEN 1 THEN SELECT 'TUESDAY';
  WHEN 2 THEN SELECT 'WEDNESDAY';
  WHEN 3 THEN SELECT 'THURSDAY';
  WHEN 4 THEN SELECT 'FRIDAY';
  WHEN 5 THEN SELECT 'SATURDAY';
  ELSE
    BEGIN
    END;
  END CASE;
END#

/*
13. Write a program in PL/SQL to update the salary of a specifc employee by 8% if the salary exceeds the avg salary of their job.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS update_salary_8 #
CREATE PROCEDURE  update_salary_8 (
  IN v_empno INT
)
BEGIN
  DECLARE v_emp_sal DECIMAL(8,2);
  DECLARE v_emp_job_sal DECIMAL(8,2);

  SELECT SAL INTO v_emp_sal
    FROM EMP
   WHERE EMPNO = v_empno;

  SELECT AVG(SAL) INTO v_emp_job_sal
    FROM EMP
   WHERE JOB = (SELECT JOB
                  FROM EMP
                WHERE EMPNO = v_empno);

  CASE
  WHEN v_emp_sal > v_emp_job_sal THEN
    UPDATE EMP
       SET SAL = ROUND(SAL + 0.08 * SAL)
     WHERE EMPNO = v_empno;
  ELSE
    BEGIN
    END;
  END CASE;

END#
/*
14. Write a program in PL/SQL to print 1st n numbers from provided input.
  input : start with, end with, top n
*/
DELIMITER #
DROP PROCEDURE IF EXISTS print_series#
CREATE PROCEDURE print_series(
  IN v_start INT,
  IN v_end INT,
  IN v_top INT
)
BEGIN
  DECLARE v_count INT;

 SET v_count = 0;

  WHILE v_count < v_top AND v_start <= v_end DO
    SELECT v_start Number;

    SET v_start = v_start + 1;
    SET v_count = v_count + 1;
  END WHILE;

END#

/*
15. Write a program in PL/SQL to print the prime numbers between 1 to 50.
*/
DELIMITER #
DROP PROCEDURE IF EXISTS print_prime#
CREATE PROCEDURE print_prime ()
BEGIN
  DECLARE v_num INT DEFAULT 2;
  DECLARE v_sqrt INT DEFAULT 2;

  WHILE v_num <= 50 DO
    CASE
    WHEN v_num IN (2, 3) THEN
      SELECT v_num AS Prime;
    ELSE
      BEGIN

        sqrt_loop : WHILE TRUE DO
          SET v_sqrt = 2;
          WHILE v_sqrt <= SQRT(v_num) DO
            IF v_num % v_sqrt = 0 THEN
              LEAVE sqrt_loop;
            ELSE
              BEGIN
              END;
            END IF;
            SET v_sqrt = v_sqrt + 1;
          END WHILE;

          SELECT v_num AS Prime;
          LEAVE sqrt_loop;

        END WHILE sqrt_loop;

      END;
    END CASE;

    SET v_num = v_num + 1;
  END WHILE;
END#
