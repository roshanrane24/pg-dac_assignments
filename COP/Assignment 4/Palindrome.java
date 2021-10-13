/*
 Q16. Write a program to check whether a number is a palindrome or not.
Note: If reverse of a number is same as that of number , then it is called palindrome. eg. 11, 151, 121, 
 */
import java.util.Scanner;

class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int num = scan.nextInt();
        int org = num;

        scan.close();

        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        if (org == rev) {
            System.out.println(org + " is a palindrome.");
        } else {
            System.out.println(org + " is NOT a palindrome.");
        }
    }
}
