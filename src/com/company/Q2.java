package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    File file = new File("src/com/company/words.txt"); //creates a file object
    public static void main(String[] args){
        String[] words = getFile(); //calls the getFile method
        String characters = Main.getString("Enter the characters: "); //gets the characters from the user
        char[] chars = characters.toCharArray(); //converts the characters to an array of characters
        for (int i = 0; i < words.length; i++){ //loops through the array of words
            if (isWord(chars, words[i])){//checks if the word is a word
                System.out.println(words[i]);//prints the word if it is a word
            }
        }

        Main.menu(); //calls the menu method
        
    }

    private static boolean isWord(char[] chars, String word){ //checks if the word is a word
        char[] wordChars = word.toCharArray(); //converts the word to an array of characters
        for (int i = 0; i < wordChars.length; i++){//loops through the array of characters in the word
            if (!isChar(chars, wordChars[i])){//checks if the character is in the array of characters
                return false;//returns false if the character is not in the array of characters
            }
        }
        return true;//returns true if the word is a word
    }

    private static boolean isChar(char[] chars, char c){ //checks if the character is in the array of characters
        for (int i = 0; i < chars.length; i++){ //loops through the array of characters
            if (chars[i] == c){ //checks if the character is in the array of characters
                return true; //returns true if the character is in the array of characters
            }
        }
        return false; //returns false if the character is not in the array of characters
    }
    public static String[] getFile(){ //gets the words from the file
        File file = new File("src/com/company/words.txt"); //creates a file object
        int lines = 25487; //the number of lines in the file
        String[] words = new String[lines]; //creates an array of words
        try { //tries to get the words from the file
            Scanner scanner = new Scanner(file); //creates a scanner object
            for (int i = 0; i < lines; i++) { //loops through the file
                words[i] = scanner.nextLine(); //gets the words from the file
            }
        } catch (FileNotFoundException e) { //catches the exception if the file is not found
            e.printStackTrace(); //prints the stack trace
        }
        return words; //returns the array of words
    }
    

    
}
