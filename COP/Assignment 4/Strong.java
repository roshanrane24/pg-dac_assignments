/*
 Q17.  Write a program to check whether a given number is a Strong Number or not?
Note : If sum of factorial of each digit of a number is equal to that number, then that number is called strong number.
 */
import java.util.Scanner;

class Strong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int num = scan.nextInt();

        scan.close();

        int temp = num;
        int sum = 0;

        // sum of factorial of digits
        while (temp != 0) {
            sum += factorial(temp%10);
            temp /= 10;
        }

        if (sum == num) {
            System.out.println(num + " is a strong number");
        } else {
            System.out.println(num + " is NOT a strong number");
        }
    }

    static int factorial (int a) {
        int fact = 1;

        for (int i = 1; i <= a; i++) {
            fact *= i;
        }

        return fact;
    }
}
