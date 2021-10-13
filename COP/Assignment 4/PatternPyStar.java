/*
 Q9. Write a program to make such a pattern like a pyramid with an asterisk, as show below : 
   * 
  * * 
 * * * 
* * * *
 
 */

class PatternPyStar {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
                System.out.printf("%" + (4-(i)) + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
