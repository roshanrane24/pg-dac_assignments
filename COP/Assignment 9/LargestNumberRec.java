//8. Write a program to get the largest element of an array using recursion?
import java.util.Arrays;
import java.util.Scanner;

public class LargestNumberRec {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Size of the Array : ");

        int[] arr = createArray(scan.nextInt());

        System.out.println(Arrays.toString(arr));

        System.out.println("Max number is " + max(arr, arr.length));
    }

    private static int max(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        return Math.max(arr[n-1], max(arr, n-1));
    }

    private static int[] createArray(int n) {
       int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }


}
