//10. Write a program to add two matrix of numbers?

import java.util.Scanner;

public class AddMatrix {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] mat1 = createMatrix();
        int[][] mat2 = createMatrix();

        System.out.println("Matrix 1");
        printMatrix(mat1);
        System.out.println("Matrix 2");
        printMatrix(mat2);

        int[][] mat3 = addMatrix(mat1, mat2);

        System.out.println("Matrix 1 + Matrix 2");
        printMatrix(mat3);
    }

    private static int[][] addMatrix(int[][] mat1, int[][] mat2) {
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            System.out.println("Addition is not possible.");
            System.exit(1);
        }
        int[][] matResult = new int[mat1.length][mat1[0].length];

        for (int i = 0; i < matResult.length; i++) {
            for (int j = 0; j < matResult[i].length; j++) {
                matResult[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return matResult;
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row: mat ) {
            for (int elem: row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] createMatrix() {
        System.out.print("Enter the size of matrix : ");
        int[][] mat = new int[scan.nextInt()][scan.nextInt()];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (int)(Math.random() * 100);
            }
        }
        return mat;
    }


}
