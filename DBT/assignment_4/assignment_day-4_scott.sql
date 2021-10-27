-- 1) Display all records in EMP table those were joined before SCOTT joined?
SELECT *
FROM `EMP` e
WHERE e.`HIREDATE` < (
    SELECT
        `HIREDATE`
    FROM `EMP`
    WHERE `ENAME` = 'SCOTT');

-- 2) Display details of department where department has 3 employees?
SELECT
    *
FROM `DEPT`
WHERE `DEPTNO` =
    (SELECT
        d.`DEPTNO`
    FROM `EMP` e JOIN `DEPT` d
        ON e.`DEPTNO` = d.`DEPTNO`
    GROUP BY d.`DEPTNO`
    HAVING COUNT(e.`EMPNO`) = 3);

-- 3) Display details of department with Minimum salary and maximum salary?
SELECT
    d.`DEPTNO`,  d.`DNAME`,  d.`LOC`,
    MAX(e.`SAL`) 'MAXSAL',
    MIN(e.`SAL`) 'MINSAL'
FROM `DEPT` d JOIN `EMP` e
    ON e.`DEPTNO` = d.`DEPTNO`
GROUP BY d.`DEPTNO`, d.`DNAME`, d.`LOC`;

-- 4) Display all ename, sal, deptno,dname from emp, dept table where all department which has employees as well as department does not have any employees. This query should include non matching rows.
SELECT
    e.`ENAME`,
    e.`SAL`,
    e.`DEPTNO`,
    d.`DNAME`
FROM `EMP` e RIGHT JOIN `DEPT` d
ON e.`DEPTNO`  = d.`DEPTNO`;

-- 5) Display all ename, sal, deptno from emp, dept table where all employees which has matching department as well as employee does not have any departments. This query should include non matching rows.
SELECT
    e.`ENAME`,
    e.`SAL`,
    d.`DEPTNO`
FROM `EMP` e RIGHT JOIN `DEPT` d
ON e.`DEPTNO`  = d.`DEPTNO`;

-- 6) Display all ename, sal, dname. Result must include all employees as well as all departments. This query should include non matching rows on both the tables.
(SELECT
    e.`ENAME`,
    e.`SAL`,
    d.`DEPTNO`
FROM `EMP` e  LEFT JOIN `DEPT` d
ON e.`DEPTNO` = d.`DEPTNO`)
UNION
(SELECT
    e.`ENAME`,
    e.`SAL`,
    d.`DEPTNO`
FROM `EMP` e  RIGHT JOIN `DEPT` d
ON e.`DEPTNO` = d.`DEPTNO`);

-- 7) Display all ename, empno, dname from emp, dept table without joining two tables
SELECT
    e.`EMPNO`,
    e.`ENAME`,
    d.`DNAME`
FROM `EMP` e, `DEPT` d
WHERE e.`DEPTNO` = d.`DEPTNO`;

-- 8) Display all the departments where department does not have any employees
SELECT  d.`DNAME`
FROM `DEPT` d
WHERE d.`DEPTNO` NOT IN
(SELECT DISTINCT `DEPTNO`
FROM `EMP`);

-- 9) Display all the departments where department does have atleast one employee
SELECT  d.`DNAME`
FROM `DEPT` d
WHERE d.`DEPTNO` IN
(SELECT DISTINCT `DEPTNO`
FROM `EMP`);

-- 10) Display all employees those who are not managers?
SELECT `ENAME`
FROM `EMP` e
WHERE e.`EMPNO` NOT IN
    (SELECT IFNULL(`MGR`, 0)
    FROM `EMP`);

-- 11) Display all the records for deptno which belongs to employee name JAMES?
SELECT *
FROM `EMP` e
WHERE e.`DEPTNO` =
    (SELECT `DEPTNO`
    FROM `EMP`
    WHERE `ENAME` = 'JAMES');

-- 12) Display all the records in emp table where salary should be less then or equal to ADAMS salary?
SELECT *
FROM `EMP` e
WHERE e.`SAL` <=
    (SELECT `SAL`
    FROM `EMP`
    WHERE `ENAME` = 'ADAMS');

-- 13) Display ename, sal, grade, dname, loc for each employee.
SELECT
    e.`ENAME`,
    e.`SAL`,
    (SELECT GRADE
    FROM `SALGRADE`
    WHERE e.`SAL`
    BETWEEN `LOSAL` AND `HISAL`) GRADE,
    d.`DNAME`,
    d.`LOC`
FROM `EMP` e JOIN `DEPT` d
    ON e.`DEPTNO` = d.`DEPTNO`;

-- 14) Display all employee whose location is DALLAS?
SELECT `ENAME`
FROM `EMP` e JOIN `DEPT` d
    ON e.`DEPTNO` = d.`DEPTNO`
WHERE d.`LOC` = 'DALLAS';
