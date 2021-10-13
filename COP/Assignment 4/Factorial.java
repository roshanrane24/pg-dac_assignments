// Q4. Write a program to calculate the factorial of the given number?

import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int num = scan.nextInt();

        scan.close();

        long fact = 1;

        for (int i = 2; i <= num; i++) {
            fact *= i;
        }

        System.out.println("Factorial of " + num + " is " + fact);
    }
}
