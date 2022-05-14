package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		return connection;
	}

	public static void openConnection(String url, String user, String pass) throws SQLException {
//		String url = "jdbc:mysql://localhost:3306/j2ee?useSSL=false&allowPublicKeyRetrieval=true";
//		connection = DriverManager.getConnection(url, "root", "j2ee_root");
		connection = DriverManager.getConnection(url, user, pass);
	}

	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}
}
