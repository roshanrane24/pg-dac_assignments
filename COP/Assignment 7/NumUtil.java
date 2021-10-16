public class NumUtil {

    public static double getPower(double x, int n) {

        return Math.pow(x, n);
    }

    public static long getFactorial(int num) {

        int result = 1;

        for (int i=2; i <= num; i++) {
            result *= i;
        }

        return result;
    }

    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        } else if (num < 3) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isEven(int num) {

        return num % 2 == 0;
    }

    public static boolean isOdd(int num) {

        return num % 2 != 0;
    }
}
