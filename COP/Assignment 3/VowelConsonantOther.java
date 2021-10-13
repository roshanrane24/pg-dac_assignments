// Q18. Write a Java program to check if character entered by user is a vowel, consonant or other character?

import java.util.Scanner;

class VowelConsonantOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Character : ");
        char ch = scan.next().charAt(0);

        scan.close();

        switch (ch) {
        // check if character's ASCII value is ASCII value of A,E,I,O,U,a,e,i,o,u
            case 97, 101, 105, 111, 117, 65, 69, 73, 79, 85-> {
                System.out.println(ch + " -> Vowel.");
            }

            default -> {
            	
                if (((int)ch > 65 && (int)ch <= 90) || ((int)ch > 97 && (int)ch <= 122)) {
                    System.out.println(ch + " -> Consonant.");
                } else {
                    System.out.println(ch + " -> Other Character.");
                }
            }
        }
    }
}
