-- 1. List department details in which no employee is working.
SELECT (SELECT d.`DEPTNO`
        FROM `DEPT` d
        WHERE `DEPTNO` = e.`DEPTNO`) DEPTNO,
       (SELECT d.`DNAME`
        FROM `DEPT` d
        WHERE `DEPTNO` = e.`DEPTNO`) DNAME,
       (SELECT d.`LOC`
        FROM `DEPT` d
        WHERE `DEPTNO` = e.`DEPTNO`) LOC
  FROM `EMP` e
GROUP BY e.`DEPTNO`;

-- 2. Find list of employees which are earning less then avg salary of there department
SELECT `ENAME`
  FROM `EMP` e
 WHERE e.`SAL` < (
SELECT AVG(SAL)
  FROM EMP
 WHERE `DEPTNO` = e.DEPTNO);

-- 3. Display list of employees which are earning more then the corresponding manager.
SELECT `ENAME`
FROM `EMP` e
WHERE e.`SAL` > (
SELECT `SAL`
FROM EMP
WHERE `EMPNO` = e.`MGR`);

-- 4. Display list of employees which are not managed by anyone
SELECT `ENAME`
FROM `EMP` e
WHERE e.`MGR` IS NULL;

-- 5. Display department details where avg salary is more then 1000
SELECT d.`DNAME`
FROM `DEPT` d
WHERE `DEPTNO` = (
SELECT e.`DEPTNO`
FROM `EMP` e
GROUP BY e.`DEPTNO`
HAVING AVG(e.`SAL`) > 1000
AND `DEPTNO` = d.`DEPTNO`);
