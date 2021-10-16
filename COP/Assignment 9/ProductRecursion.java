//3. Write a program to calculate the product of two integers using recursion? (Multiplication & Division operators are not allowed)
import java.util.Scanner;

public class ProductRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter two numbers : ");

        int a = scan.nextInt();
        int b = scan.nextInt();

        int prod = product(a, b);

        System.out.println(a + " X " + b + " = " + prod);
    }

    private static int product(int a, int b) {
        if (b == 1) return a;
        return product(a, --b) + a;
    }
}
