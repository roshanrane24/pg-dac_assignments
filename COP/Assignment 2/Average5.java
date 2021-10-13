// Q2. Write a java program to take 5 numbers using Scanner and print the average ?

import java.util.Scanner;

class Average5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter 5 Numbers: ");

        double average = 0;

        average += scan.nextInt();
        average += scan.nextInt();
        average += scan.nextInt();
        average += scan.nextInt();
        average += scan.nextInt();

        scan.close();
        
        average /= 5;

        System.out.println("Average of 5 numbers is " + average + "." );
    }
}
