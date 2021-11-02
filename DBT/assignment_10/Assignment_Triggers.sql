/*
1. Create a trigger to raise error if employee salary is less then avg salary of corresponding department.
*/
DELIMITER #
DROP TRIGGER IF EXISTS chk_emp_sal#
CREATE TRIGGER chk_emp_sal
BEFORE INSERT
ON EMP
FOR EACH ROW
BEGIN
    DECLARE v_dept_avgsal DECIMAL(8,2);

    SELECT AVG(SAL) INTO v_dept_avgsal
      FROM EMP
     WHERE DEPTNO = NEW.DEPTNO;

    IF NEW.SAL < v_dept_avgsal THEN
        SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Salary of user is less than average salary of the department';
    END IF;
END#
/*
2. Add an additional column called to emp table called as last_updated_by and last_updated_date.
   Upon each update issued on emp table, these columns must be updated by database user and current date (use function current_user() and SYSDATE())
*/
ALTER TABLE EMP
  ADD last_updated_by VARCHAR(30),
  ADD last_updated_date DATETIME(1);

DELIMITER #
DROP TRIGGER IF EXISTS updated_by_when#
CREATE TRIGGER updated_by_when
AFTER UPDATE
ON EMP
FOR EACH ROW
BEGIN
       SET NEW.last_updated_by = CURRENT_USER()
       SET NEW.last_updated_date = SYSDATE()
END#

/*
3.  Upon delete of department records from dept table. The corresponding employees records must be deleted as well. Implement this requirement with trigger
*/
DELIMITER #
DROP TRIGGER IF EXISTS delete_emp_of_dept#
CREATE TRIGGER delete_emp_of_dept
AFTER DELETE
ON DEPT
FOR EACH ROW
BEGIN
    DELETE FROM EMP
    WHERE DEPTNO = OLD.DEPTNO;
END#

/*
4. Create a table with following design

      Table NAme : scott_schema_audit
         Columns : table_name, operation_name, db_user, change_date

   Populate this table each time the user perform any DML command on emp,dept or salgrade table. Sample data will look like
                 table_name, operation_name, db_user, change_date
				 emp          update         root@localhost   2020-09-14
				 dept         delete         root@localhost   2020-09-15
				 ....
*/
CREATE TABLE dac_dbt.scott_schema_audit
(
    table_name VARCHAR(64),
    operation_name VARCHAR(20),
    db_user VARCHAR(64),
    change_date DATE
)

-- EMP
DELIMITER #
DROP TRIGGER IF EXISTS emp_audit_insert#
CREATE TRIGGER emp_audit_insert
AFTER INSERT
ON EMP
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('emp', 'insert', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS emp_audit_update#
CREATE TRIGGER emp_audit_update
AFTER UPDATE
ON EMP
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('emp', 'update', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS emp_audit_delete#
CREATE TRIGGER emp_audit_delete
AFTER DELETE
ON EMP
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('emp', 'delete', CURRENT_USER(), DATE(SYSDATE()));
END#

-- DEPT
DELIMITER #
DROP TRIGGER IF EXISTS dept_audit_insert#
CREATE TRIGGER dept_audit_insert
AFTER INSERT
ON DEPT
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('dept', 'insert', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS dept_audit_update#
CREATE TRIGGER dept_audit_update
AFTER UPDATE
ON DEPT
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('dept', 'update', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS dept_audit_delete#
CREATE TRIGGER dept_audit_delete
AFTER DELETE
ON DEPT
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('dept', 'delete', CURRENT_USER(), DATE(SYSDATE()));
END#

-- SALGRADE
DELIMITER #
DROP TRIGGER IF EXISTS salgrade_audit_insert#
CREATE TRIGGER salgrade_audit_insert
AFTER INSERT
ON SALGRADE
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('salgrade', 'insert', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS salgrade_audit_update#
CREATE TRIGGER salgrade_audit_update
AFTER UPDATE
ON SALGRADE
FOR EACH ROW
BEGIN
    INSERT INTO scott_schema_audit
         VALUES ('salgrade', 'update', CURRENT_USER(), DATE(SYSDATE()));
END#

DELIMITER #
DROP TRIGGER IF EXISTS salgrade_audit_delete#
CREATE TRIGGER salgrade_audit_delete
AFTER DELETE
ON SALGRADE
FOR EACH ROW
BEGIN
    INSERT INTO dept_schema_audit
         VALUES ('salgrade', 'delete', CURRENT_USER(), DATE(SYSDATE()));
END#
