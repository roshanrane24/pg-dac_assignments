package main.java.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.pojos.Topic;

public interface ITopicDao {
	// Read
	List<Topic> getTopics() throws SQLException;
}
