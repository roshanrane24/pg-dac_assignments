// Q20. Write a program to read 5 numbers from user, print the second highest number?

import java.util.Scanner;

class SecondHighest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Five Numbers : ");

        // Get 5 numbers from user
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();

        scan.close();

        // Find max
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        if (e > max) max = e;

        // Find secondMax (max which is less than max)
        int secondMax = 0;

        if (a > secondMax && a < max) secondMax = a;
        if (b > secondMax && b < max) secondMax = b;
        if (c > secondMax && c < max) secondMax = c;
        if (d > secondMax && d < max) secondMax = d;
        if (e > secondMax && e < max) secondMax = e;

        System.out.println("Second Highest Number is " + secondMax);
    }
}
