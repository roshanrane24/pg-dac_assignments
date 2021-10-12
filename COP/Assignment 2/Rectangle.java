import java.util.Scanner;

class Rectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Width of Rectangle: ");
        int width = scan.nextInt();

        System.out.print("Height of Rectangle: ");
        int height = scan.nextInt();

        scan.close();

        System.out.println("Area of the Rectangle = " + (width * height));
        System.out.println("Perimeter of the Rectangle = " + (2 * (width + height)));
    }
}
