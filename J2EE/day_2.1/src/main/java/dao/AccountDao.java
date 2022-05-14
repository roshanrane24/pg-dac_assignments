package main.java.dao;

import static main.java.utils.DBUtils.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import main.java.utils.DBUtils;

public class AccountDao implements IAccountDao, AutoCloseable {

	private Connection connection;
	private CallableStatement csTransferFunds;
	
	public AccountDao() throws SQLException {
		// Create Connection
		connection = getConnection();
		System.out.println("Connection established with DB.");
		
		// Prepare call statement query
		csTransferFunds = connection.prepareCall("{? = call update_account_fn(?, ?, ?)}");
		
		// Register Out Parameters
		csTransferFunds.registerOutParameter(1, Types.DOUBLE);
		
		System.out.println("Callable Statement Created.");
	}
	
	@Override
	public String transferFunds(int srcId, int dstId, double ammount) throws SQLException {
		// Add parameters to call
		csTransferFunds.setInt(2, srcId);
		csTransferFunds.setInt(3, dstId);
		csTransferFunds.setDouble(4, ammount);
		
		// Execute function call
		csTransferFunds.execute();
		
		return "Updated source account balance : " + csTransferFunds.getInt(1);
	}

	@Override
	public void close() throws Exception {
		// Close prepare statement
		if (csTransferFunds != null)
			csTransferFunds.close();

		// Close Connection
		DBUtils.close();

		System.out.println("Employee DAO Cleaned Up.");
		
	}

}
