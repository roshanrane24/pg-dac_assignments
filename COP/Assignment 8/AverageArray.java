//1. Write a program to calculate average of numbers stored in an array?

import java.util.Scanner;

public class AverageArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of the array : ");
        int n = scan.nextInt();

        int[] array = new int[n];

        System.out.print("Enter Numbers in array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        
        scan.close();
        
        double sum = 0;

        for (int elem: array) {
            sum += elem;
        }

        System.out.printf("Average value of array = %.2f\n", (sum/n));
    }
}
