package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter course name");
			String courseTitle = sc.next();
			System.out.println("Enter student details : name email");
			System.out.println(dao.admitNewStudent(courseTitle, new Student(sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
