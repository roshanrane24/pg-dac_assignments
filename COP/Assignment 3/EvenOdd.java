// Q5. Write a java program to check whether a given number is even or odd?

import java.util.Scanner;

class  EvenOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int number = scan.nextInt();

        scan.close();

        if (number%2 == 0) {
            System.out.println("Number is Even.");
        } else {
            System.out.println("Number is Odd.");
        }
    }
}
