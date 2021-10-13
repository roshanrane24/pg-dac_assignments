// Q3. Write a java program to accept two integers and check whether they are equal or not?

import java.util.Scanner;

class Equal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter First Number : ");
        int a = scan.nextInt();

        System.out.print("Enter Second Number : ");
        int b = scan.nextInt();

        scan.close();

        if (a == b) {
            System.out.println("first and second numbers are equal.");
        } else {
            System.out.println("first and second numbers are not equal.");
        }
    }
}
