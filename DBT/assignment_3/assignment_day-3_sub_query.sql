-- 1. Display all the Suppliers with the same Status as the supplier, ‘CLARK’.
SELECT SNUM, SNAME
FROM suppliers
WHERE STATUS = (
SELECT STATUS
FROM suppliers
WHERE SNAME = 'CLARK'
);

-- 2. Display all the Employees in the same department as the employee ‘MILLER’.
SELECT `ENAME`
FROM `EMP`
WHERE `DEPTNO` =
(SELECT `DEPTNO`
FROM `EMP`
WHERE `ENAME` = 'MILLER');

-- 3. Display all the Parts which have more Weight than all the Red parts.
SELECT *
FROM parts
WHERE WEIGHT > ALL
(SELECT `WEIGHT`
FROM parts
WHERE COLOR = 'Red');

-- 4. Display all the Projects going on in the same city as the project ‘TAPE’.

-- Data not available

-- 5. Display all the Parts with Weight less than all the Green parts.
SELECT *
FROM parts
WHERE WEIGHT < ALL
(SELECT `WEIGHT`
FROM parts
WHERE COLOR = 'Green');

-- 6. Display the name of the Supplier who has sold the maximum Quantity (in one sale).
SELECT SNAME
FROM suppliers
WHERE SNUM IN
(SELECT SNUM
FROM orders
WHERE QTY =
(SELECT MAX(QTY)
FROM orders));

-- 7. Display the name of the Employee with the minimum Salary.
SELECT `ENAME`
FROM `EMP`
WHERE SAL = (SELECT MIN(SAL)
FROM EMP);

-- 8. Display the name of the Supplier who has sold the maximum overall Quantity (sum of Sales).
SELECT SNAME
FROM suppliers
WHERE `SNUM` = (SELECT SNUM
FROM (SELECT SNUM, SUM(QTY) 'OVR_QTY'
FROM orders
GROUP BY SNUM
ORDER BY SUM(QTY) DESC
LIMIT 1) T);

-- 9. Display the name of the Department with the maximum number of Employees.
SELECT `DNAME`
FROM `DEPT`
WHERE `DEPTNO` =
(SELECT `DEPTNO`
FROM `EMP`
GROUP BY DEPTNO
ORDER BY COUNT(`DEPTNO`) DESC
LIMIT 1);

