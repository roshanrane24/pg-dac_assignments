package main.java.dao;

import java.sql.SQLException;

import main.java.pojos.User;

public interface IUserDao {
	// Read
	User getValidUser(String email, String password) throws SQLException;

	// Update
	int updateUserPassword(int id, String newPassword) throws SQLException;
}
