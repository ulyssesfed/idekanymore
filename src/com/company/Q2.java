package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.menu;

public class Q2 {
    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        String[] words = getFile();
        String characters = Main.getString("Enter the characters: ");
        char[] chars = characters.toCharArray();

        for (String word : words) {
            if (isWord(chars, word)) {
                System.out.println(word);
            }
        }

        menu();
    }


    private static boolean isWord(char[] chars, String word) {
        for (char c : word.toCharArray()) {
            if (!isChar(chars, c)) {
                return false;
            }
        }
        return true;
    }


    private static boolean isChar(char[] chars, char c) {
        return Arrays.binarySearch(chars, c) >= 0;
    }

    public static String[] getFile() {
        File file = new File("src/com/company/words.txt");
        List<String> wordsList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                wordsList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordsList.toArray(new String[0]);
    }




}
