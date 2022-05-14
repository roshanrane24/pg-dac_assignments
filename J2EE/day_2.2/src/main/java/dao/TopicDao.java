package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.pojos.Topic;
import static main.java.utils.DBUtils.*;

public class TopicDao implements ITopicDao, AutoCloseable {
	
	private Connection connection;
	PreparedStatement psGetTopics;
	
	public TopicDao() throws SQLException {
		// get Connection
		this.connection = getConnection();

		// Prepare Statement
		psGetTopics = connection.prepareStatement("select * from topics");

	}
	
	@Override
	public List<Topic> getTopics() throws SQLException {
		// Create output list
		List<Topic> list = new ArrayList<>();
		
		// Execute Query
		try (ResultSet rs = this.psGetTopics.executeQuery()) {
			while (rs.next()) {
				// Create & add Topic to list
				list.add(new Topic(rs.getInt(1), rs.getString(2)));
			}
		}
		
		return list;
	}
	
	@Override
	public void close() throws SQLException {
		if (psGetTopics != null)
			psGetTopics.close();
	}

}
