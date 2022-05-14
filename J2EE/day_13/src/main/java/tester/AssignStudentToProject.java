package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;

public class AssignStudentToProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl dao = new ProjectDaoImpl();

			System.out.println("Enter project id, student id : ");
			int pid = sc.nextInt();
			int sid = sc.nextInt();
			
			dao.addStudentToProject(pid, sid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
