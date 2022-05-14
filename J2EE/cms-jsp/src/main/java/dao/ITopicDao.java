package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Topic;

public interface ITopicDao {
	// Read
	List<Topic> getTopics() throws SQLException;
}
