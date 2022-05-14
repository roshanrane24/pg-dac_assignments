package dao;

import java.util.List;

import pojos.Topic;

public interface ITopicDao {
	// Read
	List<Topic> getTopics();
}
