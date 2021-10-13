// Q15. Write a java program to check if a given number is divisible by 3 and 5 ? 

import java.util.Scanner;

class DivisibleByThreeFive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = scan.nextInt();

        scan.close();

        if (num%3 == 0) System.out.println("Number is divisible by 3");
        if (num%5 == 0) System.out.println("Number is divisible by 5");

    }
}
