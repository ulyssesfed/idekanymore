package com.company;

import java.util.Scanner;

public class Main {
    private static String type;

    static int loginfails = 0;

    public static void main(String[] args){

       if( login(getString("username"), getString("Password: "))){
        System.out.println("hello " + type);
        menu(); //if the login is successful, the menu is called


       }
       else {
           System.out.println("Login Failed");
           loginfails++; //increments the number of login fails
              if (loginfails == 3){//if the number of login fails is 3, the program exits
                System.out.println("Too many failed attempts"); 
                System.exit(0);//exits the program
              }
              else {
                main(args);//if the number of login fails is less than 3, the program restarts
              }
           
       }
	
    }
    static int getInt(String prompt){ //gets an integer from the user
        Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            return scanner.nextInt();
        
    }
    static String getString(String prompt){ //gets a string from the user
        Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            return scanner.nextLine();
        }

        public static double getDouble(String string) { //gets a double from the user
            Scanner scanner = new Scanner(System.in);
            System.out.println(string);
            return scanner.nextDouble();
        }

    private static boolean login(String username, String password){
        String[][] users = { //the array of users
                {"admin", "admin"},
                {"user", "user"},
                {"guest", "guest"}
        };
        for (int i = 0; i < users.length; i++){ //loops through the array of users
            if (users[i][0].equals(username) && users[i][1].equals(password)){ //checks if the username and password match
                type = users[i][0]; //sets the type of user
                return true; //returns true if the username and password match
            }
        }
        return false; //if the username and password don't match, it returns false
        
    }
    static void menu(){ //the menu
        System.out.println("Welcome to this demonstration");
        System.out.println("__________________________________");
        System.out.println("| 1. Euclids algorithm           |");
        System.out.println("| 2. Anagram                     |");
        System.out.println("| 3. tic tac toe (2player)       |");
        System.out.println("| 4. Quadratic solver            |");
        System.out.println("| 5. Passord generator           |");
        System.out.println("| 6. Fibonacci sequence          |");
        System.out.println("| 7. pascals triangle(wip)       |");
        System.out.println("| 8. Exit                        |");
        System.out.println("|________________________________|");
        int choice = getInt("Enter your choice: "); //gets the users choice
        choice(choice); //calls the choice method

    }
    private static void choice(int choice){ //the choice method
        switch (choice){
            case 1:
                Q1.main(null);
                break;
            case 2:
                Q2.main(null);
                break;
            case 3:
                Q3.main(null);
                break;
            case 4:
                Q4.main(null);
                break;
            case 5:
                Q5.main(null);
                break;
            case 6:
                Q6.main(null);
                break;
            case 7:
                Q7.main(null);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                menu();
        } //there is almost certainly a better way to do this, but I don't know it
    }
    
}
