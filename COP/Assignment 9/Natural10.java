//1. Write a java program to print first 10 natural number using recursion?
public class Natural10 {
    public static void main(String[] args) {
        int count = 0;
        printNatural10(count);
    }

    private static void printNatural10(int count) {
        if (count == 10) return;

        System.out.print(count + 1 + " ");
        count++;

        printNatural10(count);
    }


}
