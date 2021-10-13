/*
Q17. Write a java program to ask user to enter a number between 1 and 7, print week day as per below mappings - 
 (1 - Monday, 2-Tuesday, .... 7-Sunday)
 */

import java.util.Scanner;

class Weekday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Day number (1-7) : ");
        int month =  scan.nextInt();

        scan.close();

        switch (month) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Not a valid day number (1-7).");
        }
    }
}
