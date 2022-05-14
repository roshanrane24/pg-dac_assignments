package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDao;
import dao.IBookDao;;

public class FindBook {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// Create a DAO Instance
			IBookDao dao = new BookDao();
			
			// Get Details from user
			System.out.print("Enter Books Id : ");
			int id = sc.nextInt();
			
			// Add Book to DB
			System.out.println(dao.getBook(id));
		}
	}

}
