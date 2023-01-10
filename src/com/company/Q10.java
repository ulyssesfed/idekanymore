package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q10 {
    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        char[] chars = tochars(getChars());
        String charString = new String(chars);
        String[] words = getFile();
        calculateValue(words, charString);
    }
    
    public static char[] tochars(String[] chars) {
        return chars[0].toCharArray();
    }
    
    public static char[] getChars(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of letters");
        return scanner.nextLine().toCharArray();
    }

public static String[] getFile() {
    String filePath = "src/com/company/words.txt";
    try {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return lines.toArray(new String[0]);
    } catch (IOException e) {
        System.err.println("An error occurred while reading the file: " + e.getMessage());
        return new String[0];
    }
}

    public static void calculateValue(String[] words, String inputChars) {
        int max = 0;
        String maxWord = "";
        for (String word : words) {
            int value = 0;
            String remainingChars = inputChars;
            for (char c : word.toCharArray()) {
                if (remainingChars.indexOf(c) != -1) {
                    value += getValue(c);
                    remainingChars = remainingChars.replaceFirst(Character.toString(c), "");
                } else {
                    value = 0;
                    break;
                }
            }
            if (value > max) {
                max = value;
                maxWord = word;
            }
        }
        System.out.println("The highest value word that can be made using the input characters is '" + maxWord + "' with a value of " + max);
    }
    

    private static final Map<Character, Integer> scrabbleValues = new HashMap<Character, Integer>() {
        {
            put('A', 1);
            put('B', 3);
            put('C', 3);
            put('D', 2);
            put('E', 1);
            put('F', 4);
            put('G', 2);
            put('H', 4);
            put('I', 1);
            put('J', 8);
            put('K', 5);
            put('L', 1);
            put('M', 3);
            put('N', 1);
            put('O', 1);
            put('P', 3);
            put('Q', 10);
            put('R', 1);
            put('S', 1);
            put('T', 1);
            put('U', 1);
            put('V', 4);
            put('W', 4);
            put('X', 8);
            put('Y', 4);
            put('Z', 10);
        }
    };
    public static int getValue(char c) {
        return scrabbleValues.getOrDefault(Character.toUpperCase(c), 0);
    }


}

