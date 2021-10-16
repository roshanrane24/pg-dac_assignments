//4. Write a Java program to copy an array to another by iterating the array?

import java.util.Arrays;
import java.util.Scanner;

public class CopyArray {

    public static void main(String[] args) {

        int[] arr = getIntArray();
        int[] newArr = copyArray(arr);

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr = " + Arrays.toString(newArr));
    }

    private static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
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
        
        scan.close();
        
        return array;
    }

}
