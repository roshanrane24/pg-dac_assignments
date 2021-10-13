/*
Q4. Write a program to calculate the monthly in hand salary of an employee : 
	take input for basic salary,
	HRA is 40% of basic salary,
	PF amount to be deducted is 12% of basic,
	Medical allowance is Rs 1200 per month, 
	Traveling allowance is Rs 800 per month,
	Professional tax to be deducted is Rs 300.
*/

import java.util.Scanner;

class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your basic salary : ");
        int basic = scan.nextInt();
        scan.close();

        float hra = 0.4f * basic;
        float pf = 0.12f * basic;

        System.out.println("In-hand salary = " + (basic - hra - pf - 1200 - 800 - 300));
    }
}
