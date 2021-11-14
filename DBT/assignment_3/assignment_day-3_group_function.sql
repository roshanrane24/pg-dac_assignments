-- 1. Display the minimum Status in the Supplier table.
SELECT MIN(`status`) 'MIN_STATUS'
  FROM `suppliers`;

-- 2. Display the maximum Weight in the Parts table.
SELECT MAX(`WEIGHT`) 'MAX_WEIGHT'
  FROM `parts`;

-- 3. Display the average Weight of the Parts.
SELECT AVG(`WEIGHT`) 'AVG_WEIGHT'
  FROM `parts`;

-- 4. Display the total Quantity sold for part ‘P1’.
  SELECT `PNUM`,
         SUM(`QTY`) 'TOTAL_QTY'
    FROM `orders`
GROUP BY `PNUM`
  HAVING `PNUM` = 1;

-- 5. Display the total Quantity sold for each part.
  SELECT `PNUM`,
         SUM(`QTY`) 'TOTAL_QTY'
    FROM `orders`
GROUP BY `PNUM`;

-- 6. Display the average Quantity sold for each part.
  SELECT `PNUM`, AVG(`QTY`) 'AVG_QTY'
    FROM `orders`
GROUP BY `PNUM`;

-- 7. Display the maximum Quantity sold for each part, provided the maximum Quantity is greater than 800.
  SELECT `PNUM`, MAX(`QTY`) 'MAX_QTY'
    FROM `orders`
GROUP BY `PNUM`
  HAVING `MAX_QTY` > 800;

-- 8. Display the Status and the count of Suppliers with that Status.
  SELECT `STATUS`, COUNT(`STATUS`)
    FROM `suppliers`
GROUP BY `STATUS`;

-- 9. Display the count of Projects going on in different cities.
  SELECT `CITY`, COUNT(*)
    FROM `parts`
GROUP BY `CITY`;

/*
10. What is the difference between COUNT(Status) and COUNT(*) ?
 -- COUNT(*) -> Will give count of records in whole table;
 -- COUNT(Status) will give count of records (NOT NULL) from Status Column

11. Display the Status and the Count of Suppliers with that Status in the following format as shown below:-
Status	Count
Ten	1
Twenty	2
Thirty	3
*/
  SELECT
         CASE `STATUS`
         WHEN 10 THEN 'Ten'
         WHEN 20 THEN 'Twenty'
         WHEN 30 THEN 'Thirty'
         END AS Status,
         COUNT(`STATUS`) 'Count'
    FROM `suppliers`
GROUP BY `STATUS`
ORDER BY `STATUS`;
