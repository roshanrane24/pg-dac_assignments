// Q14. Write a program to display the first n terms of Fibonacci series. 

import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        long prev = 0;
        long curr = 1;

        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number : ");
        int num = scan.nextInt();
        scan.close();

        System.out.print(prev + " ");
        for (int i = 0; i < num-1; i++) {
        	// print current number. set prev to curr & curr to curr + pre
            System.out.print(curr + " ");
            curr += prev;
            prev = (curr - prev);
        }
    }
}
