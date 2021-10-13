/*
 Q8. Write a program to make such a pattern like right angle triangle with number increased by 1 as shown below : 
1
2 3
4 5 6
7 8 9 10
 
 */

class PatternStepNum {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i; j <= (i + i); j++) {
                System.out.print((++num) + " ");
            }
            System.out.println();
        }
    }
}
