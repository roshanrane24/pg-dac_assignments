//7. Write a Java program to find the index of an array element?

import java.util.Scanner;

public class IndexSearchArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = getIntArray();

        System.out.print("Enter a number to search : ");
        int n = scan.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                System.out.println("Found " + n + " in array at index " + i);
                break;
            }
        }

        System.out.println(n + " not found in array.");
        scan.close();
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
