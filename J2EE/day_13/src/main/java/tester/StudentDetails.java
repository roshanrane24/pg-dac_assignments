package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.AdharCard;
import pojos.EduType;
import pojos.EducationQulification;

public class StudentDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			StudentDaoImpl dao = new StudentDaoImpl();
			
			System.out.println("user email ");
			String email = sc.next();

			System.out.println("Adhar Details : ");
			System.out.print("Number CreationDate Location");
			AdharCard adhar = new AdharCard(sc.next(), LocalDate.parse(sc.next()), 	sc.next());
			
			System.out.println("Hobbies : ");
			List<String> hobbies = Arrays.asList(sc.nextLine().split(" "));
			
			System.out.println("Educational Qualification");
			System.out.println("1. CBSE");
			System.out.println("2. HSC");
			System.out.println("3. DEGREE");
			System.out.println("4. DIPLOMA");
			int c = sc.nextInt();
			EduType type = null;
			
			switch (c) {
			case 1:
				type = EduType.CBSE;
				break;
			case 2:
				type = EduType.HSC;
				break;
			case 3:
				type = EduType.DEGREE;
				break;
			case 4:
				type = EduType.DIPLOMA;
				break;
			default :
				System.exit(5);
				break;
			}
			System.out.print("Year marks : ");
			EducationQulification q = new EducationQulification(type, sc.nextInt(), sc.nextInt());
			
			System.out.println("Address Details : ");
			System.out.print("City State Country ZipCode : ");
			Address address = new Address(sc.next(), sc.next(), sc.next(), sc.next());
			
			
			dao.addUserDetails(email, adhar, hobbies, q, address);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
