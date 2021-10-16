//5. Write a program to concatenate two arrays (merge two array to new one)?
//    a[] = {1,2,3}
//	b[] = {4,5}
//	c[] = {1,2,3,4,5}

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {

    public static void main(String[] args) {
        System.out.println("Create Array 1 : ");
        int[] arr1 = getIntArray();

        System.out.println("Create Array 2 : ");
        int[] arr2 = getIntArray();

        System.out.println("Create Array 3 : ");
        int[] arr3 = getIntArray();

        System.out.println("Array 1 = " + Arrays.toString(arr1));
        System.out.println("Array 2 = " + Arrays.toString(arr2));
        System.out.println("Array 3 = " + Arrays.toString(arr3));

        int [] mArr = new int[(arr1.length + arr2.length + arr3.length)];

        for (int i = 0; i < arr1.length; i++) {
            mArr[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            mArr[arr1.length + i] = arr2[i];
        }

        for (int i = 0; i < arr3.length; i++) {
            mArr[arr1.length + arr2.length + i] = arr3[i];
        }

        System.out.println("Merged Array = " + Arrays.toString(mArr));

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
