// Q8. Write a program to find the largest of two numbers?

import java.util.Scanner;

class LargestOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Two Numbers : ");

        int a = scan.nextInt();
        int b = scan.nextInt();

        scan.close();

        if (a == b) {
            System.out.println("a is equal to b");
        } else if (a > b){
            System.out.println("a is larger than b");
        } else {
            System.out.println("b is larger than a");
        }
    }
}
