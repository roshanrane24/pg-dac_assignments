// Q4. Write a java program to check whether a given number is positive or negative?

import java.util.Scanner;

class PositiveNegative {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int number = scan.nextInt();

        scan.close();

        if (number >= 0) {
            System.out.println("Number is positive.");
        } else {
            System.out.println("Number is Negative.");
        }
    }
}
