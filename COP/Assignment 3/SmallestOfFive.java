// Q10. Write a program to find the smallest of five numbers?

import java.util.Scanner;

class SmallestOfFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter 5 numbers : ");

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();

        scan.close();

        int small = a;

        if (b < small) small = b;
        if (c < small) small = c;
        if (d < small) small = d;
        if (e < small) small = e;

        System.out.println("Smallet Number is " + small);
    }
}
