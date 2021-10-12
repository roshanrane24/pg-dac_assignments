import java.util.Scanner;
import java.lang.Math;

class Circle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Radius of Circle: ");
        int radi = scan.nextInt();
        scan.close();

        System.out.println("Area of the circle = " + (Math.PI * Math.pow(radi, 2)));
        System.out.println("Circumference of the circle = " + (Math.PI * radi * 2));
    }
}
