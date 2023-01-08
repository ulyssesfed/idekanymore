package com.company;

import java.util.Random;

public class Q5 {

    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int length = Main.getInt("Enter the length of the password");
        while (length < 8) {
            System.out.println("The password must be at least 8 characters long");
            length = Main.getInt("Enter the length of the password");
        }
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+~`|}{[]:;?><,.\\/-=12345678908".toCharArray();
        String password = generatePassword(length, chars, rand);
        while (!hasNumber(password) || !hasSpecial(password) || !hasCapital(password)) {
            password = generatePassword(length, chars, rand);
        }
        System.out.println(password);
        Main.menu();
    }

    private static String generatePassword(int length, char[] chars, Random rand) {
        String password = "";
        for (int i = 0; i < length; i++) {
            password += chars[rand.nextInt(chars.length)];
        }
        return password;
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