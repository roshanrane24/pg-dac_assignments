package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;

public class TopicDao implements ITopicDao {
	
	public TopicDao() {
	}
	
	@Override
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		
		// JPQL
		String jpql = "select t from Topic t";
	
		// Get seesion
		Session session = getFactory().getCurrentSession();
		
		// Start the tranasction
		Transaction tx = session.beginTransaction();
		
		try {
			// get list of topics
			topics = session.createQuery(jpql, Topic.class).getResultList();
			
			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();
			
			// Rethrows Exception
			throw e;
		}
		return topics;		
	}

}
