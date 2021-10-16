//4. Write a program to calculate the power of any number using recursion?
import java.util.Scanner;

public class PowerRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Number to find power (base power) : ");

        int base = scan.nextInt();
        int power = scan.nextInt();

        int ans = power(base, power);

        System.out.println(base + "^" + power + " = " + ans);
    }

    private static int power(int base, int power) {
        if (power == 1) return base;
        return power(base, --power) * base;
    }
}
