// Q1. Write a program to take "name" from user using Scanner and greet as shown below-

import java.util.Scanner;

class Greet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Your Name : ");
        String name = scan.next();
        scan.close();

        System.out.print("Hello " + name + ", Welcome to Java World.");
    }
}
