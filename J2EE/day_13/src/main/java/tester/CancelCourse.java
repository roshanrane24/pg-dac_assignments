package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

public class CancelCourse {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter course id to cancel");
			System.out.println(courseDao.cancelCourse(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
