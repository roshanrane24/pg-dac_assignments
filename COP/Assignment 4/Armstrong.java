/*
12. Write a program to check whether a given number is an armstrong number or not?
Note : When the sum of the cube of the individual digits of a number is equal to that number, the number is called Armstrong number. For Example 153 is an Armstrong number because 153 = 1^3 +5^3 + 3^3.
*/

import java.util.Scanner;

class Armstrong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number : ");

        int num = scan.nextInt();
        scan.close();

        int sum = 0;

        int tmp = num;
        while (tmp != 0) {
            sum += Math.pow(tmp%10, 3);
            tmp /= 10;
        }

        if (sum == num) {
            System.out.println(num + " is a armstrong number.");
        } else {
            System.out.println(num + " is NOT a armstrong number.");
        }
    }
}
