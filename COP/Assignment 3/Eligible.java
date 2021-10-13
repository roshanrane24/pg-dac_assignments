// Q6. Write a java program to read age of a person, check if he/she is eligible to cast vote or not?

import java.util.Scanner;

class Eligible {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your age : ");
        int age = scan.nextInt();

        scan.close();

        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are NOT eligible to vote.");
        }
    }
}
