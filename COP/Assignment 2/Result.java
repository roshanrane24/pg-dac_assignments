import java.util.Scanner;

public class Result {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the Roll Number of the student : ");
        int roll_no = scanner.nextInt();

        System.out.print("Input the Name of the Student : ");
        String name = scanner.next();

        System.out.print("Input the marks of Physics, Chemistry & Maths : ");

        int phy = scanner.nextInt();
        int chem = scanner.nextInt();
        int mat = scanner.nextInt();
        scanner.close();

        System.out.println();
        System.out.println("Roll No. : " + roll_no);
        System.out.println("Name of Student : " + name);
        System.out.println("Marks in Physics : " + phy);
        System.out.println("Marks in Chemistry : " + chem);
        System.out.println("Marks in Maths : " + mat);
        System.out.println("Total Marks : " + (phy + chem + mat));
        System.out.println("Percentage : " + (((phy + chem + mat)/300.0) * 100));

    }
}
