/*
Q16. Write a java program to ask user to enter test marks of three subjects such as Phy, Chem, Math. Max marks for each subject is 100. Now calculate average of marks. Display following message based on average marks calculated - 

avg < 30 : You are failed.
avg >= 30 but < 60 : You passed with Second division
avg >=60 but < 80 : You passed with First division
avg>=80 : You passed with First class distinction
*/

import java.util.Scanner;

class StudentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the marks of Physics, Chemistry & Maths : ");

        int phy = scanner.nextInt();
        int chem = scanner.nextInt();
        int mat = scanner.nextInt();

        scanner.close();

        int err = 0;
        if (phy > 100 || phy < 0) err = 1;
        if (chem > 100 || chem < 0) err = 1;
        if (mat > 100 || mat < 0) err = 1;
        if (err != 0) {
            System.out.println("Please enter valid marks");
            System.exit(1);
        }

        double average = ((phy + chem + mat)/300.0) * 100;

        if (average < 30) {
            System.out.println("You are failed.");
        } else if (average < 60){
            System.out.println("You passed with Second division");
        } else if (average < 80) {
            System.out.println("You passed wirh First division");
        } else {
            System.out.println("You passed with First class distinction");
        }
    }
}
