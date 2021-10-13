// Q13. Write a program to determine whether a given number is prime or not?

import java.util.Scanner;

class Prime{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = scan.nextInt();

        scan.close();

        // If num is 2,3 it is prime if it is below 1 it is not prime
        if (num <= 1) {
            System.out.println(num + " is NOT a Prime Number");
        } else if (num == 2 || num == 3) {
            System.out.println(num + " is a Prime Number");
        } else {
        	// check if num is divisible by numbers from 2 to sqrt of num
        	// If it is then it is not prime 
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num%i == 0) {
                    System.out.println(num + " is NOT a Prime Number");
                    System.exit(0);
                }
            }
            System.out.println(num + " is a Prime Number");
        }
    }
}
