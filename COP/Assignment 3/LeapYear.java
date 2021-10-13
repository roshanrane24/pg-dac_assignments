// Q14. Write a Java program that takes a year from user and print whether that year is a leap year or not.

import java.util.Scanner;

class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scan.nextInt();

        scan.close();

        boolean leap = false;

        if (year%4 == 0) leap = true;
        if (year%100 == 0) leap = false;
        if (year%400 == 0) leap = true;

        if (leap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }

    }
}
