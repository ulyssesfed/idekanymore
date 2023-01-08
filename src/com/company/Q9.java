package com.company;

import java.util.Scanner;

public class Q9 {
public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 3999: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: not an integer.");
            return;
        }

        int num = scanner.nextInt();
        if (num < 1 || num > 3999) {
            System.out.println("Error: number must be between 1 and 3999.");
            return;
        }

        System.out.println(num + " is " + toRoman(num) + " in Roman numerals.");
    }

    public static String toRoman(int num) {
        StringBuilder roman = new StringBuilder();

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(numerals[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }




}
