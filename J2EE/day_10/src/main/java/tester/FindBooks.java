package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDao;
import dao.IBookDao;;

public class FindBooks {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// Create a DAO Instance
			IBookDao dao = new BookDao();
			
			// Get Details from user
			System.out.print("Enter Author Name : ");
			String author = sc.nextLine();
			
			System.out.print("Enter Date (YYYY-MM-DD) : ");
			LocalDate date = LocalDate.parse(sc.next());
			
			// Add Book to DB
			dao.getBooks(author, date).forEach(System.out::println);
		}
	}

}
