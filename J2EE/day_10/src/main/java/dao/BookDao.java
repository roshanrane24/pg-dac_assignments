package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojos.Book;

public class BookDao implements IBookDao {

	@Override
	public String addABook(Book book) {
		// Get session from session factory
		Session session = getFactory().getCurrentSession();

		// Start Transaction
		Transaction tx = session.beginTransaction();

		String message = "Failed to add the book.";

		try {
			// Save Book to DB Session
			session.save(book);

			tx.commit();

			message = "Successfully added the book with id " + book.getId();
		} catch (RuntimeException e) {
			// Rollback changes
			if (tx != null)
				tx.rollback();

			// re-throw Exception
			throw e;
		}

		return message;
	}

	@Override
	public Book getBook(int id) {
		// Get session from session factory
		Session session = getFactory().openSession();

		// Start Transaction
		Transaction tx = session.beginTransaction();

		Book book = null;
		try {
			// Get book by id
			book = session.get(Book.class, id);

			// End transaction
			tx.commit();
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

		return book;
	}

	@Override
	public List<Book> getBooks(String author, LocalDate date) {
		// JPQL Query
		String jpql = "select b from Book b where b.author = :author and b.publishedDate > :date";

		// Get session from session factory
		Session session = getFactory().openSession();

		// Start Transaction
		Transaction tx = session.beginTransaction();

		List<Book> books = new ArrayList<>();
		try {
			// Run query & get list list
			books = session.createQuery(jpql, Book.class).setParameter("author", author).setParameter("date", date)
					.getResultList();

			// End transaction
			tx.commit();
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

		return books;
	}

	@Override
	public String discountBooks(LocalDate date, double discount) {
		// JPQL Query
		String jpql = "select b from Book b where b.publishedDate < :date";

		// Get session from session factory
		Session session = getFactory().openSession();

		// Start Transaction
		Transaction tx = session.beginTransaction();

		String message = "Failed to update price with discount";

		List<Book> books = new ArrayList<>();
		try {
			// Run query & get list list
			books = session.createQuery(jpql, Book.class).setParameter("date", date).getResultList();

			books.forEach(book -> {
				System.out.println("Discount appied on book " + book.getTitle());
				System.out.println("Old Price : " + book.getPrice());
				book.setPrice(book.getPrice() * (1 - (discount / 100)));
				System.out.println("New Price : " + book.getPrice());
			});
			message = "Successfully discounted " + books.size() + " books";
			// End transaction
			tx.commit();
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
