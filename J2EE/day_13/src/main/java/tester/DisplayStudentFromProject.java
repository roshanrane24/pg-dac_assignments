package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;

public class DisplayStudentFromProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl dao = new ProjectDaoImpl();

			System.out.println("Enter project name : ");
			String name = sc.nextLine();
			
			dao.getStudentFromProject(name).forEach(s -> System.out.println(s));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
