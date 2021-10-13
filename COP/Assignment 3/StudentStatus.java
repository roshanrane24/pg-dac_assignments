/* Q 11. Write a java program to read roll no, name and marks of three subjects and calculate the total, percentage and division. 

Test Data :
Input the Roll Number of the student :784
Input the Name of the Student :James
Input the marks of Physics, Chemistry and Computer Application : 70 80 90

Expected Output :
Roll No : 784
Name of Student : James
Marks in Physics : 70
Marks in Chemistry : 80
Marks in Computer Application : 90
Total Marks = 240
Percentage = 80.00
Division = First
*/

import java.util.Scanner;

public class StudentStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the Roll Number of the student : ");
        int roll_no = scanner.nextInt();

        System.out.print("Input the Name of the Student : ");
        String name = scanner.next();

        System.out.print("Input the marks of Physics, Chemistry & Maths : ");

        int phy = scanner.nextInt();
        int chem = scanner.nextInt();
        int mat = scanner.nextInt();

        scanner.close();

        System.out.println();
        System.out.println("Roll No. : " + roll_no);
        System.out.println("Name of Student : " + name);
        System.out.println("Marks in Physics : " + phy);
        System.out.println("Marks in Chemistry : " + chem);
        System.out.println("Marks in Maths : " + mat);
        System.out.println("Total Marks : " + (phy + chem + mat));

        double average = ((phy + chem + mat)/300.0) * 100;
        System.out.printf("Percentage : %.2f%%\n", average);

        String division;
        if (average < 30) {
            division = "Failed";
        } else if (average < 60){
            division = "Second";
        } else if (average < 80) {
            division = "First";
        } else {
            division = "Distinction";
        }

        System.out.println("Division : " + division);
    }
}
