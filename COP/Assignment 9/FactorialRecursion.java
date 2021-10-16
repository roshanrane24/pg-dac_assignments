//7. Write a program to find the Factorial of a number using recursion?

import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number to find factorial upto : ");
        int num = scan.nextInt();

        System.out.println("Factorial (" + num + "!) = " + factorial(num));
    }

    private static long factorial(int num) {
        if (num == 1) return 1;
        return num * factorial(--num);
    }
}
