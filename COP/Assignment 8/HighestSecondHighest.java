//3. Write a program to find out highest and
//second highest number in an array?

import java.util.Scanner;

public class HighestSecondHighest {


    public static void main(String[] args) {

        int[] arr = HighestSecondHighest.getIntArray();

        int max=0;
        int secondMax = 0;

        for (int i: arr) {
            if (i > max) max = i;
        }

        for (int i: arr) {
            if (i > secondMax && i < max) secondMax = i;
        }

        System.out.println("Highest number is " + max + " & second highest number is " + secondMax);
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
