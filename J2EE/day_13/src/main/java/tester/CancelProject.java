package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;

public class CancelProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl dao = new ProjectDaoImpl();

			System.out.println("Enter project id : ");
			int id = sc.nextInt();

			dao.removeProject(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
