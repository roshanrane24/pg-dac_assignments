-- DBT Assignment Day 1

-- 1. login to MySQL

    -- mysql -u root -p

-- 2. list different database in MySQL

SHOW DATABASES;

-- 3. How to connect to specific database

    -- mysql --user='root' --password='root' --database='dac_dbt'

-- 4. List all the tables available in given database

SHOW TABLES;

-- 5. Switch from one database to other

USE dac_dbt;

-- 6. Run the script "SampleScott_Schema.sql" in your database

-- SOURCE 'SampleScott_Schema.sql';

-- 7. List the tables that you have in the database now

SHOW TABLES;

-- 8. Describe the structure of each table in MySQL

DESCRIBE  BONUS;
DESCRIBE DEPT;
DESCRIBE DUMMY;
DESCRIBE EMP;
DESCRIBE SALGRADE;

-- 9. Export the table data in external file in MySQL

SELECT * FROM EMP INTO OUTFILE "/var/lib/mysql/employee_table";

-- 10. Show the data from each table in MySQL

SELECT * FROM BONUS;
SELECT * FROM DEPT;
SELECT * FROM EMP;
SELECT * FROM DUMMY;
SELECT * FROM SALGRADE;

-- 11. Interact with MySQL WorkBench Software
-- 12. Clear the MySQL command prompt

SYSTEM clear;

-- 13. Fire command to check current user in database

SELECT CURRENT_USER();
SELECT USER();

-- 14. Fire command to see current date and time of server

SELECT NOW();

-- 15. Fire command to assign the output to select command to variable in MySQL

SELECT EMPNO INTO @empid FROM EMP WHERE ENAME = 'KING';

-- 16. Print the value stored in variable on the screen

SELECT @empid;

-- 17. Observe the output of command `select DATE(current_date() +2),current_date()`;
SELECT DATE(CURRENT_DATE() +2),CURRENT_DATE();
    -- Added 2 days in current_date;

-- 18. Observe the command `select null;` Identify what is `null`
SELECT NULL;

    -- `SELECT NULL` diplays table with column name `NULL` & single row with value `<null>`.
    -- `<null>` points to an empty data.
