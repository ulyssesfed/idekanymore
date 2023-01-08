package com.company;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    loginLoop();
}

    public static void loginLoop() {
        int loginAttempts = 0;
        while (loginAttempts < 3) {
            String username = getString("Username: ");
            String password = getString("Password: ");

            if (login(username, password)) {
                menu();
                return;
            } else {
                loginAttempts++;
            }
        }

        System.out.println("Maximum number of login attempts exceeded. Exiting program.");
        System.exit(0);
    }


    static int getInt(String prompt) { // gets an integer from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }

    static String getString(String prompt) { // gets a string from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static double getDouble(String string) { // gets a double from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        return scanner.nextDouble();
    }

    private static boolean login(String username, String password) {
        String[][] users = { // the array of users
                { "admin", "admin" },
                { "user", "user" },
                { "guest", "guest" }
        };

        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                System.out.println("User " + username + " logged in.");
                return true;
            }
        }

        System.out.println("User " + username + " failed to log in.");
        return false;
    }


    static void menu() { // the menu
        System.out.println("Welcome to this demonstration");
        System.out.println("__________________________________");
        System.out.println("| 1. Euclid's algorithm          |");
        System.out.println("| 2. Anagram                     |");
        System.out.println("| 3. tic tac toe (2player)       |");
        System.out.println("| 4. Quadratic solver            |");
        System.out.println("| 5. Password generator           |");
        System.out.println("| 6. Fibonacci sequence          |");
        System.out.println("| 7. pascals triangle(wip)       |");
        System.out.println("| 8. Tax calculator              |");
        System.out.println("| 9. Exit                        |");
        System.out.println("|________________________________|");
        String choice = getString("Enter your choice: "); // gets the users choice
        choice(choice); // calls the choice method
    }
    private static void choice(String choice){
        String className = "com.company.Q" + choice;

        if (choice.equals("9")) {
            System.exit(0);
        }

        try {
            // Load the class with the specified name
            Class<?> cls = Class.forName(className);

            // Create an instance of the class
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Find the method with the "run" name and no arguments
            Method method = cls.getDeclaredMethod("run");

            // Invoke the "run" method on the instance
            method.invoke(obj);
            //have the menu method called again if an invalid choice is made
        } catch (ClassNotFoundException e) {
            System.err.println("Invalid choice");
            menu();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}