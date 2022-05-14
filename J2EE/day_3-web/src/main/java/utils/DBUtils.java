package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/j2ee?useSSL=false&allowPublicKeyRetrieval=true";
	
	public static Connection getConnection() throws SQLException {
		
		// Create Connection if not exist
		if (connection == null)
			connection = DriverManager.getConnection(url, "root", "j2ee_root");
		
		return connection;
	}
	
	public static void close() throws SQLException {
		if (connection != null)
			connection.close();
	}
}
