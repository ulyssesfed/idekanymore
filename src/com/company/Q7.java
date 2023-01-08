package com.company;

public class Q7 {

    public static void run() {
        main(null);
    }

    public static void main(String[] args) {
        int numTerms = Main.getInt("Enter the number of terms");
        printPascalTriangle(numTerms);
    }

    public static void printPascalTriangle(int rows) {
        int[][] pascal = new int[rows][];

        for (int i = 0; i < rows; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}

