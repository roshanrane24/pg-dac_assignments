//6. Write a Java program to test if an array contains a specific value?

import java.util.Scanner;

public class SearchArray {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = getIntArray();

        System.out.print("Enter a number to search : ");
        int n = scan.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                System.out.println("Found " + n + " in array.");
                break;
            }
        }

        System.out.println(n + " not ound in array.");
    }

    private static int[] getIntArray() {

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
