/* Q3 Write a program in java to display the multiplication table of a given integer?
>> Enter the number : 5
5 X 1 = 5
5 X 2 = 10
.
.
5 X 10 = 
*/

import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");

        int num = scan.nextInt();

        scan.close();

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " X " + i + " = " + (num * i));
        }
    }
}
