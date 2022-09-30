package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    File file = new File("src/com/company/words.txt");
    public static void main(String[] args){
        //put the content of word.txt int an array of strings
        String[] words = getFile();
        String characters = Main.getString("Enter the characters: ");
        //split the characters into an array of characters
        char[] chars = characters.toCharArray();
        //find every possible word that can be made from the characters
        for (int i = 0; i < words.length; i++){
            if (isWord(chars, words[i])){
                System.out.println(words[i]);
            }
        }

        Main.menu();
        
    }

    private static boolean isWord(char[] chars, String word){
        //split the word into an array of characters
        char[] wordChars = word.toCharArray();
        //check if the word can be made from the characters
        for (int i = 0; i < wordChars.length; i++){
            if (!isChar(chars, wordChars[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean isChar(char[] chars, char c){
        //check if the character is in the array of characters
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return true;
            }
        }
        return false;
    }
    public static String[] getFile(){
        //read the file
        File file = new File("src/com/company/words.txt");
        //get the number of lines in the file
        int lines = 25487;
        //create an array of strings with the number of lines
        String[] words = new String[lines];
        //read the file line by line and put it in the array
        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < lines; i++) {
                words[i] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }
    

    
}
