/*
6. Write a program to display the pattern like right angle triangle with a number as shown below : 
1
12
123
1234 
 */


class PatternNum {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}
