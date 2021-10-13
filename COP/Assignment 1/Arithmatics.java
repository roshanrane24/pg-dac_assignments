// Q10. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers received from command line?

class Arithmatics {
    public static void main(String[] args) {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);

        System.out.println("Addition " + first + " + " + second + " = " + (first + second));
        System.out.println("Substraction " + first + " - " + second + " = " + (first - second));
        System.out.println("Multiplication " + first + " * " + second + " = " + (first * second));
        System.out.println("Division " + first + " / " + second + " = " + (first / second));
        System.out.println("Remainder " + first + " % " + second + " = " + (first % second));
    }

}
