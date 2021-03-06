// Q3. Write a java program to calculate simple interest, get the required inputs 

import java.util.Scanner;

class SIScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Principle Amount: ");
        int principle = scan.nextInt();

        System.out.print("Enter  Rate of Interest: ");
        float rate = scan.nextFloat();

        System.out.print("Enter Time in Years: ");
        float time = scan.nextFloat();
        
        scan.close();

        System.out.println("Simple Interest = " + ((principle * rate * time)/100));

    }
}
