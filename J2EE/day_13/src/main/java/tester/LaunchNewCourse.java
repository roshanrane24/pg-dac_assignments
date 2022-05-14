package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;

public class LaunchNewCourse {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter new course details :  title,  startDate,  endDate,  fees,  capacity");
			System.out.println(courseDao.launchNewCourse(
					new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
