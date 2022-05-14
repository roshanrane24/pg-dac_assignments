package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter course name n student id");
			String courseTitle = sc.next();			
			System.out.println(dao.cancelAdmission(courseTitle, sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
