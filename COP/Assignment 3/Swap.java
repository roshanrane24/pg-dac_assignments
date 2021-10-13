// Q1. Write a java program to swap two numbers stored in local variables?

class Swap {
    public static void main(String[] args) {
        int a = 12;
        int b = 144;

        System.out.println("Variable a = " + a + " & Variable b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("Variable a = " + a + " & Variable b = " + b);
    }
}
