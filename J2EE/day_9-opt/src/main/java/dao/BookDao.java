package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Book;

public class BookDao implements IBookDao {

	@Override
	public String addABook(Book book) {
		// Get session from session factory
		Session session = getFactory().openSession();

		// Start Transaction
		Transaction tx = session.beginTransaction();

		String message;

		try {
			// Save Book to DB Session
			session.save(book);

//			 Test changes in persistance state before commit
//			book.setAuthor("Before Commit"); // changes
//			book.setId(20);  
// Exception in thread "main" javax.persistence.PersistenceException: org.hibernate.HibernateException: identifier of an instance of pojos.Book was altered from 4 to 20

			// Commit Transaction & Save success message
			tx.commit();
			book.setId(20);  

//			 Test changes in persistance state after commit
//			book.setAuthor("After Commit"); no changes

			message = "Successfully added the book with id " + book.getId();
		} catch (RuntimeException e) {
			// Rollback changes
			if (tx != null)
				tx.rollback();

			// re-throw Exception
			throw e;
		} finally {
			// Close the session
			if (session != null)
				session.close();
		}

		return message;
	}

}
