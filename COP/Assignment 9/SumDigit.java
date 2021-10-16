//6. Write a program to find the sum of digits of a number using recursion?

import java.util.Scanner;

public class SumDigit {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        long num = scan.nextInt();

        System.out.println("Sum of digits in number " + num + " is " + sumD(num));
    }

    private static long sumD(long num) {
        if (num == 0) return 0;
        return sumD(num/10) + num%10;
    }
}
