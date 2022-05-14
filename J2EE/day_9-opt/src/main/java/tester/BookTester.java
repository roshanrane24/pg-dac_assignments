package tester;

import java.util.Scanner;

import dao.BookDao;
import pojos.Book;
import pojos.Category;

public class BookTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// Create a Book Dao Instance
			BookDao bookDao = new BookDao();
			
			// Create a book instance
			Book book = new Book();
			
			// Get book details from user
			System.out.println("Enter Book Details");
			
			System.out.print("Title : ");
			book.setTitle(sc.nextLine());
			
			System.out.print("Author : ");
			book.setAuthor(sc.nextLine());

			System.out.print("Category : ");
			book.setCategory(Category.valueOf(sc.next().toUpperCase()));

			System.out.print("Price : ");
			book.setPrice(sc.nextDouble());
			
	// --------------------------------------------------
//			System.out.print("test : ");
//			book.setTestProperty(sc.next());
	// --------------------------------------------------
			
			// Save book to DB
			bookDao.addABook(book);
			
			System.out.println("Successfully added the book");
			
		}
	}

}
