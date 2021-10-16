//1. Write a java class named as NumUtil with following static methods to - 
// double getPower(double x, int n)
// long getFactorial(int num);
// boolean isPrime(int num);
// boolean isEven(int num);
// boolean isOdd(int num);
// 
// 1.1) Write test class named as NumUtilMain to test all these methods.
//
// 1.2) Extends question 2.1 to make it menu driven, based on the user choice , read relevant data from user and call static methods.

import java.util.Scanner;

public class NumUtilMain {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1.1 Testing numUtil class");
        System.out.println("--------------------------------------------------");

        System.out.println("double getPower(double x, int n)");
        System.out.println("-------------------------");
        System.out.print("Enter a double number : ");
        double x = scan.nextDouble();
        System.out.print("Enter a number : ");
        int n = scan.nextInt();
        System.out.println("Returns : " + NumUtil.getPower(x, n));
        System.out.println();

        System.out.println("long getFactorial(int num);");
        System.out.println("-------------------------");
        System.out.print("Enter a number : ");
        n = scan.nextInt();
        System.out.println("Returns : " + NumUtil.getFactorial(n));
        System.out.println();

        System.out.println("boolean isPrime(int num);");
        System.out.println("-------------------------");
        System.out.print("Enter a number : ");
        n = scan.nextInt();
        System.out.println("Returns : " + NumUtil.isPrime(n));
        System.out.println();

        System.out.println("boolean isEven(int num);");
        System.out.println("-------------------------");
        System.out.print("Enter a number : ");
        n = scan.nextInt();
        System.out.println("Returns : " + NumUtil.isEven(n));
        System.out.println();

        System.out.println("boolean isOdd(int num);");
        System.out.println("-------------------------");
        System.out.print("Enter a number : ");
        n = scan.nextInt();
        System.out.println("Returns : " + NumUtil.isOdd(n));
        System.out.println("==================================================");

        System.out.println("1.2 Menu Driven");
        System.out.println("--------------------------------------------------");

        System.out.println("========================= NumUtil =========================");

        int choice;
        do {

            displayMenu();

            System.out.print("Select : ");
            choice = scan.nextInt();

            perform(choice);
            System.out.println();

        } while (choice != 0);
    }

    private static void perform(int choice) {

        int n;

        switch (choice) {
            case 0 -> System.out.println("========================= TERMINATING =========================");
            case 1 -> {
                System.out.print("Enter a double number : ");
                double x = scan.nextDouble();
                System.out.print("Enter a number : ");
                n = scan.nextInt();
                System.out.println("Returns : " + NumUtil.getPower(x, n));
            }
            case 2 -> {
                System.out.print("Enter a number : ");
                n = scan.nextInt();
                System.out.println("Returns : " + NumUtil.getFactorial(n));
            }
            case 3 -> {
                System.out.print("Enter a number : ");
                n = scan.nextInt();
                System.out.println("Returns : " + NumUtil.isPrime(n));
            }
            case 4 -> {
                System.out.print("Enter a number : ");
                n = scan.nextInt();
                System.out.println("Returns : " + NumUtil.isEven(n));
            }
            case 5 -> {
                System.out.print("Enter a number : ");
                n = scan.nextInt();
                System.out.println("Returns : " + NumUtil.isOdd(n));
            }
            default -> System.out.println("Not a valid choice.");
        }
    }

    private static void displayMenu() {
        System.out.println("1 > Power of a double.");
        System.out.println("2 > Factorials of a number.");
        System.out.println("3 > Check Prime.");
        System.out.println("4 > Check Even");
        System.out.println("5 > Check Odd");
        System.out.println("0 > Exit");
    }
}
