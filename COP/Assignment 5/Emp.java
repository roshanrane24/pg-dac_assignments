import java.util.Scanner;

public class Emp {
	int empId;
	String name;
	String dept;
	int salary;
	
	public Emp() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Employee Id : ");
		empId = scan.nextInt();

		System.out.print("Employee Name : ");
		scan.nextLine();
		name = scan.nextLine();
		
		System.out.print("Employee Department : ");
		dept = scan.nextLine();
		
		System.out.print("Employee Salary : ");
		salary = scan.nextInt();
		
		scan.close();
	}
	
	public void displayEmpDetails() {
		System.out.println("==========");
		System.out.println("Employee ID = " + empId);
		System.out.println("Employee Name = " + name);
		System.out.println("Employee Department = " + dept);
		System.out.println("Employee Salary = " + salary);
	}
}
