package com.company;

import java.util.Scanner;

public class Q9 {
public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to convert an integer to a Roman numeral (1) or a Roman numeral to an integer (2)?");
        System.out.print("Enter your choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: not an integer.");
            return;
        }

        int choice = scanner.nextInt();
        if (choice == 1) {
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
        } else if (choice == 2) {
            scanner.nextLine(); // consume the remaining newline character
            System.out.print("Enter a Roman numeral: ");

            String roman = scanner.nextLine();
            int num = fromRoman(roman);
            if (num == -1) {
                System.out.println("Error: invalid Roman numeral.");
                return;
            }

            System.out.println(roman + " is " + num + " in Arabic numerals.");
        } else {
            System.out.println("Error: invalid choice.");
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
        int lastValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int value;

            switch (c) {
                case 'M':
                    value = 1000;
                    break;
                case 'D':
                    value = 500;
                    break;
                case 'C':
                    value = 100;
                    break;
                case 'L':
                    value = 50;
                    break;
                case 'X':
                    value = 10;
                    break;
                case 'V':
                    value = 5;
                    break;
                case 'I':
                    value = 1;
                    break;
                default:
                    return -1;
            }

            if (value < lastValue) {
                num -= value;
            } else {
                num += value;
            }
            lastValue = value;
        }

        return num;
    }





}
