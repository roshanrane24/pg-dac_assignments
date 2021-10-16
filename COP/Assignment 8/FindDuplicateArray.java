//8. Write a Java program to find the duplicate values of an array of integer values?
import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicateArray {

    public static void main(String[] args) {
        int[] arr = getIntArray();


        System.out.println("Array = " + Arrays.toString(arr));

        findDplicates(arr);
        }

    private static void findDplicates(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) System.out.print(arr[i] + " ");
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
