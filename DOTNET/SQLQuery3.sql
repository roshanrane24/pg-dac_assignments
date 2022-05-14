CREATE PROCEDURE INSERT_USER
@UserName VARCHAR(20)
,@PassWord VARCHAR(20)
,@Email VARCHAR(20)
,@Name VARCHAR(60)
,@City VARCHAR(20)
,@Phone VARCHAR(10)
AS
BEGIN
	INSERT INTO [User] VALUES 
	(@UserName, @PassWord, @Email, @Name, @City, @Phone);
END
	