package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;
import pojos.Project;

public class LaunchNewProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl dao = new ProjectDaoImpl();

			System.out.println("Enter project details : ");
			System.out.print("Title : ");
			String title = sc.nextLine();

			System.out.print("Technology : ");
			String tech = sc.nextLine();

			System.out.print("Completion Date (YYYY-MM-DD) : ");
			LocalDate date = parse(sc.nextLine());

			dao.launchNewProject(new Project(title, tech, date));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
