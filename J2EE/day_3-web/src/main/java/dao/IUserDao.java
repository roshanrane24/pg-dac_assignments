package dao;

import java.sql.SQLException;

import pojos.User;

public interface IUserDao {
	// ------------------------------ Read ------------------------------
	// Get a user with valid email password combination
	User getValidUser(String email, String password) throws SQLException;

	// ----------------------------- Update -----------------------------
	// update user's password
	int updateUserPassword(int id, String newPassword) throws SQLException;
}
