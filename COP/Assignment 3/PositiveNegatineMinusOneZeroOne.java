// Q7. Write a java program to read a number entered by user. Print -1 if  this number is negative, 1 if it is positive, 0 if it is neither positive nor negative?


import java.util.Scanner;

class PositiveNegatineMinusOneZeroOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int number = scan.nextInt();

        scan.close();

        if (number == 0) {
            System.out.println("0");
        } else if (number > 0) {
            System.out.println("1");
        } else {
            System.out.println("-1");
        }
    }
}
