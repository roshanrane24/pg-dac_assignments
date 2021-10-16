//12. Write a program to Sort strings in alphabetical order?
import java.util.Arrays;
import java.util.Scanner;

public class SortStringArray {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String[] sArr = createStringArray();

        System.out.println("Array = " + Arrays.toString(sArr));

        Arrays.sort(sArr);

        System.out.println("Sorted Array = " + Arrays.toString(sArr));

    }

    private static String[] createStringArray() {
        System.out.print("Enter size of the array : ");

        String[] arr = new String[scan.nextInt()];

        System.out.print("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.next();
        }
        return arr;
    }
}