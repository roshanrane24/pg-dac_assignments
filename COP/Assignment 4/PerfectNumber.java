/* is a perfect number or not?

Note : 
Defintion of Perfect Number : sum of all divisor of the number is equal to the number itself.
 */

import java.util.Scanner;

class PerfectNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = scan.nextInt();
        int sum = 0;
        scan.close();

        if (num%2 == 0) {
            for (int i = 1; i <= (num/2); i++) {
                if (num%i == 0) sum += i;
            }
        } else {
            for (int i = 1; i <= (num/3); i++) {
                if (num%i == 0) sum += i;
            }
        }

        if (sum == num) {
            System.out.println(num + " is a perfect number");
        } else {
            System.out.println(num + " is NOT a perfect number");
        }
    }
}
