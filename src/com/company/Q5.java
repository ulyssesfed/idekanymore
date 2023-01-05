package com.company;

import java.util.Random;

public class Q5 {

    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        Random rand = new Random(); //creates a random object
        var password = ""; //creates a string for the password
        int length = Main.getInt("Enter the length of the password"); //gets the length of the password from the user
        while (length < 8) { //checks if the length is less than 8
            System.out.println("The password must be at least 8 characters long"); //prints an error message
            length = Main.getInt("Enter the length of the password"); //gets the length of the password from the user
        }
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+~`|}{[]:;?><,.\\/-=12345678908" //creates an array of characters
                .toCharArray(); //converts the string to an array of characters
        for (int i = 0; i < length; i++) { //loops through the length of the password
            password += chars[rand.nextInt(chars.length)]; //adds a random character to the password
        }
        while (!hasNumber(password) || !hasSpecial(password) || !hasCapital(password)) { //checks if the password has a number, special character, and capital letter
            password = ""; //resets the password
            for (int i = 0; i < length; i++) { //loops through the length of the password
                password += chars[rand.nextInt(chars.length)]; //adds a random character to the password
            } //loops until the password has a number, special character, and capital letter
        } 
        System.out.println(password); //prints the password

        Main.menu(); //calls the menu method

    }
    private static boolean hasNumber(String password) { //checks if the password has a number
        for (int i = 0; i < password.length(); i++) { //loops through the password
            if (Character.isDigit(password.charAt(i))) { //checks if the character is a number 
                return true; //returns true if the password has a number
            }
        }
        return false; //returns false if the password does not have a number
    }

    private static boolean hasSpecial(String password) { //checks if the password has a special character
        for (int i = 0; i < password.length(); i++) { //loops through the password
            if (!Character.isLetterOrDigit(password.charAt(i))) {//checks if the character is a special character
                return true;//returns true if the password has a special character
            }
        }
        return false;//returns false if the password does not have a special character
    }

    private static boolean hasCapital(String password) { //checks if the password has a capital letter
        for (int i = 0; i < password.length(); i++) { //loops through the password
            if (Character.isUpperCase(password.charAt(i))) { //checks if the character is a capital letter
                return true; //returns true if the password has a capital letter
            }
        }
        return false; //returns false if the password does not have a capital letter
    }
}