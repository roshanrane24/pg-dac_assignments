import java.util.Scanner;

class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your basic salary : ");
        int basic = scan.nextInt();

        float hra = 0.4f * basic;
        float pf = 0.12f * basic;

        System.out.println("In-hand salary = " + (basic - hra - pf - 1200 - 800 - 300));
    }
}
