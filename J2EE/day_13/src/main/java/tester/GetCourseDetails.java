package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;

public class GetCourseDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter course name , to display details");
			Course course = courseDao.getCourseDetails(sc.next());
			System.out.println("Course details ");
			System.out.println(course);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
