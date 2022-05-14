package dao;

import pojos.User;

public interface IUserDao {
	// ------------------------------ Read ------------------------------
	// Get a user with valid email password combination
	User getValidUser(String email, String password);

	// ----------------------------- Update -----------------------------
	// update user's password
	String updateUserPassword(int id, String newPassword);
}
