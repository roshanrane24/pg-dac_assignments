package beans;

import java.sql.SQLException;
import java.util.List;

import dao.TopicDao;
import pojos.Topic;

public class TopicBean {
	// Properties
	
	
	// Dependencies
	private TopicDao topicDao;
	
	// Constructor
	public TopicBean() throws SQLException {
		topicDao = new TopicDao();
	}

	// getters & Setters
	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	
	// BL
	public List<Topic> getAllTopics() throws SQLException {
		return topicDao.getTopics();
	}
	
	
	
	
	
}
