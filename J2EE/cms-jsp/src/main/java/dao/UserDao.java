package dao;

import static utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDao implements IUserDao {

	private Connection connection;
	private PreparedStatement psGetValidUser;
	private PreparedStatement psUpdateUserPassword;

	public UserDao() throws SQLException {
		// get Connection
		this.connection = getConnection();

		// Prepare Statement
		psGetValidUser = connection.prepareStatement("select * from users where email = ? and password = ?");
		psUpdateUserPassword = connection.prepareStatement("update users set password = ? where id = ?");
	}

	@Override
	public User getValidUser(String email, String password) throws SQLException {
		// Create empty user
		User user = null;

		// Add parameters to statement
		psGetValidUser.setString(1, email);
		psGetValidUser.setString(2, password);

		// Execute Query
		System.out.println("Executing authentication query");
		try (ResultSet rs = psGetValidUser.executeQuery()) {
			if (rs.next()) {
				// Create User
				// int id, String name, String email, String password, double
				// registrationAmmount, Date registrationDate, String role
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDate(6), rs.getString(7));
			}
		}

		return user;
	}

	@Override
	public int updateUserPassword(int id, String newPassword) throws SQLException {
		// Add parameters to statement
		psUpdateUserPassword.setString(1, newPassword);
		psUpdateUserPassword.setInt(2, id);

		// Execute Update query
		return psUpdateUserPassword.executeUpdate();
	}

	// Cleanup
	public void cleanUp() throws SQLException {
		// Close Statement
		if (psGetValidUser != null)
			psGetValidUser.close();

		if (psUpdateUserPassword != null)
			psUpdateUserPassword.close();
	}
}
