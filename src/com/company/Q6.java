package com.company;

public class Q6 {
    public static void main(String[] args) {
        int numTerms = Main.getInt("Enter the number of terms");

        if (numTerms < 1) {
            System.out.println("The number of terms must be at least 1.");
            return;
        }

        int a = 0;
        int b = 1;

        System.out.print(a + " ");

        if (numTerms == 1) {
            return;
        }

        System.out.print(b + " ");

        if (numTerms == 2) {
            return;
        }

        for (int i = 2; i < numTerms; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

        System.out.println();

        Main.menu();
    }


}
