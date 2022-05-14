package dao;

import static utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;

public class TopicDao implements ITopicDao {
	
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
	
	// Cleanup
	public void cleanUp() throws SQLException {
		// Close Statement
		if (psGetTopics != null)
			psGetTopics.close();
		
		// Close Connection
		if (connection != null)
			connection.close();
	}

}
