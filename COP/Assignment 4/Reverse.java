//Q15. Write a program to display the number in reverse order.

import java.util.Scanner;

class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int num = scan.nextInt();

        scan.close();

        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        System.out.println(rev);
    }
}
