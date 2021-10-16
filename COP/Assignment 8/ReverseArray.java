//2. Write a program to reverse an array of elements?

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = scan.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter numbers in array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        
        scan.close();

        System.out.println("Original Array = " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reverse Array = " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
