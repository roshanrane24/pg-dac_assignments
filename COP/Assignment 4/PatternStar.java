/*
5. Write a program to display the pattern like right angle triangle using an asterisk as shown below:

*
**
***
****
 
 */
class PatternStar {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
