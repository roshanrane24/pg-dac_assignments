package beans;

import java.sql.SQLException;

import dao.UserDao;
import pojos.User;

public class UserBean {
	// Properties
	private String email;
	private String password;

	// Dependency
	private UserDao userDao;

	// Error message
	String message;
	
	// result BL
	private User validatedUserDetails;

	// Default Constructor
	public UserBean() throws SQLException {
		// log
		System.out.println("In UserBean Constructor");

		// Create Dependancy
		userDao = new UserDao();
	}

	// Setters & Getters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getValidatedUserDetails() {
		return validatedUserDetails;
	}

	public void setValidatedUserDetails(User validatedUserDetails) {
		this.validatedUserDetails = validatedUserDetails;
	}

	public String getMessage() {
		return message;
	}

	// BL
	public String validateUser() throws SQLException {
		// Reset message
		this.message = "";

		// Invoke DAO Method
		validatedUserDetails = userDao.getValidUser(email, password);

		// check validated User

		if (validatedUserDetails != null) {
			// Successful Admin Login
			if (validatedUserDetails.getRole().equals("ADMIN"))
				return "add_new_tutorial";
			// Successful Customer Login
			else 
				return "topics";
		}
		message = "Login Failed";
		return "login";
	}
	
	// BL :: Get Admin Role
	public boolean isAdmin() {
		// Reset Message
		this.message = "";
		
		if(this.validatedUserDetails != null) {
			return validatedUserDetails.getRole().equals("ADMIN");
		}

		// Not logged in
		this.message = "Please Login first";
		return false;
	}
}
