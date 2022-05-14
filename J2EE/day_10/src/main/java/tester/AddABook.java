package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDao;
import dao.IBookDao;
import pojos.Book;
import pojos.Category;;

public class AddABook {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// Create a DAO Instance
			IBookDao dao = new BookDao();
			
			// Create a Book Instance
			Book book = new Book();
			
			// Get Details from user
			System.out.println("Enter Books Details : ");
			
			System.out.print("Title : ");
			book.setTitle(sc.nextLine());
			
			System.out.print("Author : ");
			book.setAuthor(sc.nextLine());

			System.out.print("Category : ");
			book.setCategory(Category.valueOf(sc.next().toUpperCase()));

			System.out.print("Price : ");
			book.setPrice(sc.nextDouble());
			
			System.out.println("Available Stock : ");
			book.setAvailableStock(sc.nextInt());

			System.out.println("published Date : ");
			book.setPublishedDate(LocalDate.parse(sc.next()));
			
			// Add Book to DB
			dao.addABook(book);
		}
	}

}
