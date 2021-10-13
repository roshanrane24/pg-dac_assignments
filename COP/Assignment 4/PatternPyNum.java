/*
 Q9. Write a program to make such a pattern like a pyramid with an asterisk, as show below : 
   1
  2 2
 3 3 3
4 4 4 4 
 
 */

class PatternPyNum {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
                System.out.printf("%" + (4-(i)) + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
    }
}
