//5. Write a recursive program to print Fibonacci Series for given number of terms?
import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number to find fibonacci series : ");
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo(i) + " ");
        }
    }

    private static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = fibo(n-2);
        int b = fibo(n-1);

        return a + b;
    }
}

