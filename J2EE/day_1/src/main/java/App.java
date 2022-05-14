package main.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import main.java.dao.TopicDao;
import main.java.dao.UserDao;
import main.java.pojos.Topic;
import main.java.pojos.User;
import main.java.utils.DBUtils;

public class App {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); UserDao userDao = new UserDao(); TopicDao topicDao = new TopicDao()) {
			boolean exit = false;

			while (!exit) {
				// Display menu
				menu();

				try {
					int choice = sc.nextInt();

					String email;
					String password;
					User user;

					switch (choice) {
					// Login User
					case 1:
						// Get user's email & password
						System.out.print("Enter user's email : ");
						email = sc.next();

						System.out.print("Enter user's password : ");
						password = sc.next();

						// Get user if user exit in DB
						user = userDao.getValidUser(email, password);

						// Exception if user does not exist
						if (user == null)
							throw new Exception("Invalid username or password combination");

						// Display user's details
						System.out.println(user);

						break;

					// Change User Password
					case 2:
						// Get user's email & password
						System.out.print("Enter user's email : ");
						email = sc.next();

						System.out.print("Enter old password : ");
						password = sc.next();

						System.out.print("Enter new password : ");
						String newPassword = sc.next();

						// Get user if user exit in DB
						user = userDao.getValidUser(email, password);

						// Exception if user does not exist
						if (user == null)
							throw new Exception(
									"Invalid username or password combination. Please enter correct old password.");

						// Update user's password
						int result = userDao.updateUserPassword(user.getId(), newPassword);
						
						// Check update status
						if (result == 1) {
							System.out.println("Successfully updated password.");
						} else if (result > 1) {
							throw new Exception("Multiple records updated while updating password");
						} else {
							System.out.println("Password Update Failed");
						}

						break;

					// Display all Topics
					case 3:
						// Get all topics from DB
						List<Topic> list = topicDao.getTopics();
						
						// Display all topics
						list.forEach(System.out::println);

						break;

					// Exit
					case 0:
						exit = true;
						break;

					// Invalid option
					default:
						System.err.println("Invalid Option!");
						break;
					}
				} catch (Exception e) {
					System.err.println(e.getMessage() != null ? e.getMessage() : "");
					sc.nextLine();
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			// Close DB Connection
			try {
				DBUtils.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void menu() {
		System.out.println("<=><=><=><=><=><=><=>");
		System.out.println("1 => Login");
		System.out.println("2 => Change Password");
		System.out.println("3 => Show All Topics");
		System.out.println("0 => Exit");
		System.out.print("  => ");
	}

}
