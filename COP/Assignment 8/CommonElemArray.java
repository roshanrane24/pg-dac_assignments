//9. Write a Java program to find the common elements between two arrays of integers?

import java.util.Arrays;
import java.util.Scanner;

public class CommonElemArray {

    public static void main(String[] args) {
        System.out.println("Create Array 1 : ");
        int[] arr1 = getIntArray();

        System.out.println("Create Array 2 : ");
        int[] arr2 = getIntArray();

        System.out.println("Array 1 = " + Arrays.toString(arr1));
        System.out.println("Array 2 = " + Arrays.toString(arr2));

        for (int i: arr1) {
            for (int j : arr2) {
                if (i == j) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static int[] getIntArray() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of the array : ");
        int n = scan.nextInt();

        int[] array = new int[n];

        System.out.print("Enter Numbers in array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        return array;
    }
}
