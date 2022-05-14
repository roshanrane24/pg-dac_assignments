package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.User;

public class UserDao implements IUserDao {

	public UserDao()  {
	}

	@Override
	public User getValidUser(String email, String password) {
		User user = null;
		
		// JPQL
		String jpql = "select u from User u where u.email = :email and u.password = :password";
	
		
		// Get session
		Session session = getFactory().getCurrentSession();
		
		// Start the tranasction
		Transaction tx = session.beginTransaction();
		
		try {
			// get list of topics
			user = session.createQuery(jpql, User.class).setParameter("email", email).setParameter("password", password).getSingleResult();
			
			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();
			
			// Rethrows Exception
			throw e;
		}
		
		return user;		
	}

	@Override
	public String updateUserPassword(int id, String newPassword) {
		String message = "Failed to update user password";
		
		// Get session
		Session session = getFactory().getCurrentSession();
		
		// Start the tranasction
		Transaction tx = session.beginTransaction();
		
		try {
			// get list of topics
			User user = session.get(User.class, id);

			if (user != null) {
				user.setPassword(newPassword);
				message = "Successfully updated user password";
			} 
			
			// End transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback the transaction
			tx.rollback();
			
			// Rethrows Exception
			throw e;
		}
		
		return message;		
	}
}
