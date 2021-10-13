// Q18. Write a program to find the length of a string without using the library function?

import java.util.Scanner;

class SLength {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String str = scan.next();
        scan.close();

        int count = 0;

        char ch[] = str.toCharArray();

        for (char c : ch) {
            count++;
        }

        System.out.println("Length = " + count);
    }
}
