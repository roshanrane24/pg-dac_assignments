/*
7. Write a java program to calculate compound interest, get the required inputs 
using Scanner ?
 */

import java.util.Scanner;

class CInterest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter principle amount: ");
        int principle = scan.nextInt();

        System.out.print("Enter rate of interest: ");
        double rate = scan.nextDouble();

        System.out.print("Enter duration in year: ");
        double time = scan.nextDouble();
        
        scan.close();

        double CI;
        if (time < 1) {
            CI = principle * (1 + ((rate * time)/100));
        } else {
            CI = principle * Math.pow((1 + (rate / 100)), time);
        }

        System.out.println("Compound interest = " + CI);
    }
}
