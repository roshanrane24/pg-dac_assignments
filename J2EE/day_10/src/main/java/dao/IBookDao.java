package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Book;

public interface IBookDao {
	// Add a new Book
	String addABook(Book book);
	
	// Find book by book id
	Book getBook(int id);
	
	// Get books written by specific author published after sp. date in descending order
	List<Book> getBooks(String author, LocalDate date);
	
	// Discount books published before x date
	String discountBooks(LocalDate date, double discount);
}
