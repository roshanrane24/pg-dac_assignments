// Q9. Write a program to find the largest of three numbers?

import java.util.Scanner;

class LargestOfThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Three Numbers : ");

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        scan.close();

        int max = a;

        // If greater than max set it to max 
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("Largest Number is " + max);
    }
}
