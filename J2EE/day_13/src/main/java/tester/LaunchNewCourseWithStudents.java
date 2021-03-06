package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

public class LaunchNewCourseWithStudents {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter new course details :  title,  startDate,  endDate,  fees,  capacity");
			Course c1 = new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt());
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter student details : name email");
				c1.addStudent(new Student(sc.next(), sc.next()));

			}
			//obj heap : c1 , s1, s2, s3 with bi dir link established. 
			System.out.println(courseDao.launchNewCourse(c1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
