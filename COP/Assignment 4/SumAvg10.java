// Q 2. Write a java program to read 10 numbers from keyboard and find their  sum and average?

import java.util.Scanner;

class SumAvg10 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 Numbers: ");

        for (int i = 1; i <= 10; i++) {
            sum += scan.nextInt();
        }
    
        scan.close();

        System.out.println("Sum of 10 numbers is " + sum);
        System.out.format("Average = %.2f%n", (sum/10.0));
    }
}
