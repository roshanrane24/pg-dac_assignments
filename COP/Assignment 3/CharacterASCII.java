// Q13. Write a Java program to print the ascii value of a given character?
import java.util.Scanner;

class CharacterASCII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Character : ");
        char ch = scan.next().charAt(0);

        scan.close();

        System.out.println(ch + " --> " + (int)ch);
    }
}
