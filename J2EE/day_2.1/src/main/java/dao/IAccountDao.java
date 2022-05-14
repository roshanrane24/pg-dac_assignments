package main.java.dao;

import java.sql.SQLException;

public interface IAccountDao {
	// Transfer Funds
	String transferFunds(int srcId, int dstId, double ammount) throws SQLException;
}
