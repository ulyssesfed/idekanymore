package com.company;

import java.util.Scanner;

public class Q9 {
public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        System.out.println("do you want to convert an int to nuerals(1) or numerals to int(2)");
        int choice = Main.getInt("Enter your choice: ");
        if (choice == 1) {
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

            Main.menu();
        } else if (choice == 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a Roman numeral: ");

            String roman = scanner.nextLine();
            int num = fromRoman(roman);
            if (num == -1) {
                System.out.println("Error: invalid Roman numeral.");
                return;
            }

            System.out.println(roman + " is " + num + " in Arabic numerals.");

            Main.menu();
        } else {
            System.out.println("Error: invalid choice.");
            return;

        }
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
    public static int fromRoman(String roman) {
        int num = 0;

        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        char[] numerals = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            int value = 0;

            for (int j = 0; j < numerals.length; j++) {
                if (c == numerals[j]) {
                    value = values[j];
                    break;
                }
            }

            if (value == 0) {
                return -1;
            }

            if (i + 1 < roman.length()) {
                char next = roman.charAt(i + 1);
                int nextValue = 0;

                for (int j = 0; j < numerals.length; j++) {
                    if (next == numerals[j]) {
                        nextValue = values[j];
                        break;
                    }
                }

                if (nextValue > value) {
                    value *= -1;
                }
            }

            num += value;
        }

        return num;
    }




}
