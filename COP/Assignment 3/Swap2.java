// Q2. Write a java program to swap two numbers stored in local variables without using additional variable?

class Swap2 {
    public static void main(String[] args) {
        int a = 12;
        int b = 144;

        System.out.println("Variable a = " + a + " & Variable b = " + b);

        a += b;
        b = a - b;
        a -= b;

        System.out.println("Variable a = " + a + " & Variable b = " + b);
    }
}
