package main.java.tester;

import java.util.Scanner;

import main.java.dao.AccountDao;

public class TestFunctionCall {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); AccountDao dao = new AccountDao()) {
			// Get inputs from user
			// Get Source Account
			System.out.println("Enter Source Account : ");
			int src = sc.nextInt();
			
			// Get Destination Account
			System.out.println("Enter Destination Account : ");
			int dst = sc.nextInt();
			
			// Get Transfer Ammount
			System.out.println("Enter Ammount : ");
			double amt = sc.nextDouble();

			// Execute & print result
			System.out.println(dao.transferFunds(src, dst, amt));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
	}

}
