//11. Write a program to Sort an array in ascending order? [Notes : Arrays.sort()]

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = createArray();

        System.out.println("Array = " + Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println("Sorted Array = " + Arrays.toString(arr));
    }

    private static int[] createArray() {
        System.out.print("Enter size of the array : ");
        int[] arr = new int[scan.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
}
