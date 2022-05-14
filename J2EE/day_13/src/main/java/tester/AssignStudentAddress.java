package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import pojos.Address;

public class AssignStudentAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDaoImpl dao = new AddressDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter student id , to link adr details");
			int studentId = sc.nextInt();
			System.out.println("Enter Adr details : city, state,  country,  zipCode");
			System.out.println(
					dao.assignAddressDetails(studentId, new Address(sc.next(), sc.next(), sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
