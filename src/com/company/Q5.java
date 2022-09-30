package com.company;

import java.util.Random;

public class Q5 {
    public static void main(String[] args) {
        // secure password generator
        Random rand = new Random();
        var password = "";
        int length = Main.getInt("Enter the length of the password");
        // if the input is less than 8 they will be prompted to enter a new value
        while (length < 8) {
            System.out.println("The password must be at least 8 characters long");
            length = Main.getInt("Enter the length of the password");
        }
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+~`|}{[]:;?><,.\\/-=12345678908"
                .toCharArray();
        for (int i = 0; i < length; i++) {
            password += chars[rand.nextInt(chars.length)];
        }
        // if the pasword oesnt contain a number and a special character and a capitl it
        // will be generated again
        while (!hasNumber(password) || !hasSpecial(password) || !hasCapital(password)) {
            password = "";
            for (int i = 0; i < length; i++) {
                password += chars[rand.nextInt(chars.length)];
            }
        }
        System.out.println(password);

        Main.menu();

    }
    private static boolean hasNumber(String password) {
        // check if the password contains a number
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecial(String password) {
        // check if the password contains a special character
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCapital(String password) {
        // check if the password contains a capital letter
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}