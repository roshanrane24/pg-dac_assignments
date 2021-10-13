/*
 Q7. Write a program to make such a pattern like right angle triangle with a number which will repeat a number in a row, as shown below : 
1
22
333
4444 
 */

class PatternSameNum {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
}
