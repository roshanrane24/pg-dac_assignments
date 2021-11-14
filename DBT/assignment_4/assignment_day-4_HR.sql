-- 1.) Write a query in SQL to display the first name, last name, department number, and department name for each employee.
SELECT e.`first_name`,
       e.`last_name`,
       d.`department_id`,
       d.`department_name`
  FROM `employees` e JOIN  `departments` d
    ON e.`department_id` = d.`department_id`;

-- 2.) Write a query in SQL to display the first and last name, department, city, and state province for each employee
SELECT `first_name`,
       `last_name`,
       d.`department_name`,
       l.`city`,
       l.`state_province`
  FROM `employees` e JOIN  `departments` d
    ON e.`department_id` = d.`department_id`
  JOIN `locations` l
    ON d.`location_id` = l.`location_id`;

-- 3.) Write a query in SQL to display the first name, last name, salary, and job grade for all employees.
-- job grade not in table using job name
SELECT `first_name`,
       `last_name`,
       `salary`,
       (SELECT `job_title`
          FROM `jobs` j
         WHERE e.`job_id` = j.`job_id`) 'job'
  FROM `employees` e ;

-- 4.) Write a query in SQL to display the first name, last name, department number and department name, for all employees for departments 8 or 4.
SELECT `first_name`,
       `last_name`,
       d.`department_id`,
       d.`department_name`
  FROM `employees` e JOIN `departments` d
    ON e.`department_id` = d.`department_id`
 WHERE e.`department_id` IN (8, 4);

-- 5.) Write a query in SQL to display those employees who contain a letter z to their first name and also display their last name, department, city, and state province.
SELECT `first_name`,
       `last_name`,
       d.`department_name`,
       l.`city`,
       l.`state_province`
  FROM `employees` e JOIN  `departments` d
    ON e.`department_id` = d.`department_id`
  JOIN `locations` l ON d.`location_id` = l.`location_id`
 WHERE `first_name` LIKE '%z%';

-- 6.) Write a query in SQL to display all departments including those where does not have any employee. 
  SELECT department_name
    FROM employees e RIGHT JOIN  departments d
      ON e.department_id = d.department_id
GROUP BY d.department_name;

-- 7.) Write a query in SQL to display the first and last name and salary for those employees who earn less than the employee earn whose number is 182.
SELECT first_name,
       last_name,
       salary
  FROM employees
 WHERE salary < (SELECT salary
                   FROM employees
                  WHERE employee_id = 182);

-- 8.) Write a query in SQL to display the first name of all employees including the first name of their manager. 
SELECT e.first_name 'employee_first_name',
       m.first_name 'manager_first_name'
  FROM employees e JOIN employees m
    ON e.manager_id = m.employee_id;

-- 9.) Write a query in SQL to display the department name, city, and state province for each department. 
SELECT d.department_name,
       l.city,
       l.state_province
  FROM departments d JOIN locations l
    ON d.location_id = l.location_id;

-- 10.) Write a query in SQL to display the first name, last name, department number and name, for all employees who have or have not any department. 
SELECT first_name,
       last_name,
       d.department_id,
       d.department_name
  FROM employees e LEFT JOIN  departments d
    ON e.department_id = d.department_id;

-- 11.) Write a query in SQL to display the first name of all employees and the first name of their manager including those who does not working under any manager.
SELECT e.first_name 'employee_first_name',
       m.first_name 'manager_first_name'
  FROM employees e LEFT JOIN employees m
    ON e.manager_id = m.employee_id;

-- 12.) Write a query in SQL to display the first name, last name, and department number for those employees who works in the same department as the employee who holds the last name as Taylor.
SELECT first_name,
       last_name,
       department_id
  FROM employees e
 WHERE e.department_id = (SELECT department_id
                            FROM employees
                           WHERE last_name = 'Taylor');

-- 13.) Write a query in SQL to display the job title, department name, full name (first and last name ) of employee, and starting date for all the jobs which started on or after 1st January, 1993 and ending with on or before 31 August, 1997.
SELECT j.job_title,
       d.department_name,
       CONCAT(e.first_name, " ", e.last_name) 'full_name',
       e.hire_date
  FROM employees e JOIN departments d
    ON e.department_id = d.department_id
  JOIN jobs j ON e.job_id = j.job_id
 WHERE e.hire_date BETWEEN '1993-01-01' AND '1997-08-31';

-- 14.) Write a query in SQL to display job title, full name (first and last name ) of employee, and the difference between maximum salary for the job and salary of the employee.
SELECT j.job_title,
       CONCAT(e.first_name, " ", e.last_name) 'full_name',
       max_salary - salary 'diff_from_max_salary'
  FROM employees e JOIN jobs j
    ON e.job_id = j.job_id;

-- 15.) Write a query in SQL to display the name of the department, average salary and number of employees working in that department who got commission.
-- Table not complete

-- 16.) Write a query in SQL to display the full name (first and last name ) of employees, job title and the salary differences to their own job for those employees who is working in the department ID 80. 
SELECT CONCAT(e.first_name, " ", e.last_name) 'full_name',
       j.job_title,
       max_salary - salary 'diff_from_max_salary'
  FROM employees e JOIN jobs j
    ON e.job_id = j.job_id
 WHERE e.department_id = 8;

-- 17.) 17. Write a query in SQL to display the name of the country, city, and the departments which are running there.
SELECT country_name,
       city,
       department_name
  FROM countries c JOIN locations l
    ON c.country_id = l.country_id
  JOIN departments d
    ON l.location_id = d.location_id;

-- 18.) Write a query in SQL to display department name and the full name (first and last name) of the manager
SELECT CONCAT(first_name, " ", last_name) 'full_name',
       d.department_name
  FROM employees e RIGHT JOIN departments d
    ON e.department_id = d.department_id
 WHERE employee_id IN (SELECT DISTINCT manager_id
                         FROM employees);

-- 19.) Write a query in SQL to display job title and average salary of employees.
  SELECT j.job_title,
         ROUND(AVG(e.salary)) 'average_salary'
    FROM jobs j JOIN employees e
      ON e.job_id = j.job_id
GROUP BY j.job_title;

-- 20.) Write a query in SQL to display the details of jobs which was done by any of the employees who is presently earning a salary on and above 12000.
SELECT DISTINCT j.*
  FROM jobs j JOIN employees e
    ON e.job_id = j.job_id
 WHERE e.salary > 12000;

-- 21.) Write a query in SQL to display the country name, city, and number of those departments where at leaste 2 employees are working.
  SELECT c.country_name,
         l.city,
         COUNT(d.department_name) 'more_2_employee_dept'
    FROM locations l JOIN countries c
      ON l.country_id = c.country_id
    JOIN departments d
      ON l.location_id = d.location_id
   WHERE d.department_name IN (SELECT department_name
                               FROM employees e1 JOIN departments d1
                                 ON e1.department_id = d1.department_id
                           GROUP BY department_name
                             HAVING COUNT(employee_id) > 1)
GROUP BY country_name, city;

-- 22.) Write a query in SQL to display the department name, full name (first and last name) of manager, and their city.
SELECT d.department_name,
       CONCAT(e.first_name, " ", e.last_name),
       l.city
  FROM employees e JOIN departments d
    ON e.department_id = d.department_id
  JOIN locations l
    ON d.location_id = l.location_id
 WHERE e.employee_id IN (SELECT DISTINCT manager_id
                           FROM employees);

-- 23.) Write a query in SQL to display the employee ID, job name, number of days worked in for all those jobs in department 80.
SELECT e.employee_id,
       j.job_title,
       CURRENT_DATE - e.hire_date 'days_worked'
  FROM employees e JOIN jobs j
    ON e.job_id = j.job_id;

-- 24.) Write a query in SQL to display the full name (first and last name), and salary of those employees who working in any department located in London.
SELECT CONCAT(e.first_name, " ", e.last_name) 'full_name',
       e.salary
  FROM employees e JOIN departments d
    ON e.department_id = d.department_id
  JOIN locations l
    ON d.location_id = l.location_id
 WHERE l.city = 'London';

-- 25.)  Write a query in SQL to display full name(first and last name), job title, starting and ending date of last jobs for those employees with worked without a commission percentage.
-- Comission data unavailable
SELECT CONCAT(e.first_name, " ", e.last_name) 'full_name',
       j.job_title,
       e.hire_date
  FROM employees e JOIN jobs j
    ON e.job_id = j.job_id;

-- 26.) Write a query in SQL to display the department name and number of employees in each of the department.
  SELECT d.department_name,
         COUNT(e.employee_id) 'no_of_employees'
    FROM employees e JOIN departments d
      ON d.department_id = e.department_id
GROUP BY department_name;

-- 27.) Write a query in SQL to display the full name (firt and last name ) of employee with ID and name of the country presently where (s)he is working.
SELECT CONCAT(e.first_name, " ", e.last_name) 'full_name',
       e.employee_id,
       c.country_name
  FROM employees e JOIN departments d
    ON d.department_id = e.department_id
  JOIN locations l
    ON d.location_id = l.location_id
  JOIN countries c
    ON l.country_id = c.country_id;

