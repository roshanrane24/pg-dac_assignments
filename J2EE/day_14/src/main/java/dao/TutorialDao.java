package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;

public class TutorialDao implements ITutorialDao {

	public TutorialDao() {
	}

	@Override
	public List<Tutorial> getTutorialsByTopicId(int id) {
		// Create a list to store all tutorial
		List<Tutorial> list = new ArrayList<Tutorial>();

		// JPQL
		String jpql = "select t from Tutorial t where t.topic = :t";

		// Get session
		Session session = getFactory().getCurrentSession();

		// Start the tranasction
		Transaction tx = session.beginTransaction();

		try {
			// Get topic
			Topic t = session.get(Topic.class, id);
			if (t != null) {
				// get list of topics
				list = session.createQuery(jpql, Tutorial.class).setParameter("t", t).getResultList();
			}
			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();

			// Rethrows Exception
			throw e;
		}

		return list;
	}

	@Override
	public Tutorial getTutorialByTutorialName(String name) {
		// Create a tutorial object to store a tutorial
		Tutorial tutorial = null;

		// JPQL
		String jpql = "select t from Tutorial t where t.name = :name";

		// Get session
		Session session = getFactory().getCurrentSession();

		// Start the tranasction
		Transaction tx = session.beginTransaction();

		try {
			// get list of topics
			tutorial = session.createQuery(jpql, Tutorial.class).setParameter("name", name).getSingleResult();

			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();

			// Rethrows Exception
			throw e;
		}

		return tutorial;
	}

	@Override
	public int visitATutorial(int tutorialId) {
		// Create a tutorial object to store a tutorial
		int result = 0;

		// Get session
		Session session = getFactory().getCurrentSession();

		// Start the tranasction
		Transaction tx = session.beginTransaction();

		try {
			// get list of topics
			Tutorial tutorial = session.get(Tutorial.class, tutorialId);

			if (tutorial != null) {
				tutorial.setVisits(tutorial.getVisits() + 1);
			}

			result = tutorial.getVisits();

			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();

			// Rethrows Exception
			throw e;
		}

		return result;
	}

	@Override
	public void addTutorial(Tutorial tutorial, int topicId) {
		// Get session
		Session session = getFactory().getCurrentSession();

		// Start the tranasction
		Transaction tx = session.beginTransaction();

		try {
			// Get Topic
			Topic t = session.get(Topic.class, topicId);

			if (t != null) {
				// Established unidirectional link
				tutorial.setTopic(t);

				// get list of topics
				session.persist(tutorial);
			}

			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();

			// Rethrows Exception
			throw e;
		}
	}

}
