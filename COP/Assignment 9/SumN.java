//2. Write a java program to calculate the sum of numbers from 1 to N using recursion? 
import java.util.Scanner;

public class SumN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Number to find sum upto : ");
        int n = scan.nextInt();

        int sum = sumN(n);

        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    private static int sumN(int n) {
        if (n == 0) return n;
        return sumN(n-1) + n;
    }
}
