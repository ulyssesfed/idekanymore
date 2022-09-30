package com.company;

import java.util.Scanner;

public class Main {
    private static String type;

    static int loginfails = 0;

    public static void main(String[] args){

       if( login(getString("username"), getString("Password: "))){
        System.out.println("hello " + type);
        menu();


       }
       else {
           System.out.println("Login Failed");
           loginfails++;
              if (loginfails == 3){
                System.out.println("Too many failed attempts");
                System.exit(0);
              }
              else {
                main(args);
              }
           
       }
	
    }
    static int getInt(String prompt){
        Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            return scanner.nextInt();
        
    }
    static String getString(String prompt){
        Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            return scanner.nextLine();
        }

    private static boolean login(String username, String password){
        String[][] users = {
                {"admin", "admin"},
                {"user", "user"},
                {"guest", "guest"}
        };
        for (int i = 0; i < users.length; i++){
            if (users[i][0].equals(username) && users[i][1].equals(password)){
                type = users[i][0];
                return true;
            }
        }
        return false;
        
    }
    static void menu(){
        System.out.println("Welcome to this demonstration");
        System.out.println("__________________________________");
        System.out.println("| 1. Euclids algorithm           |");
        System.out.println("| 2. Anagram                     |");
        System.out.println("| 3. tic tac toe (2player)       |");
        System.out.println("| 4. Quadratic solver            |");
        System.out.println("| 5. Passord generator           |");
        System.out.println("| 5. Exit                        |");
        System.out.println("|________________________________|");
        int choice = getInt("Enter your choice: ");
        choice(choice);

    }
    private static void choice(int choice){
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
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                menu();
        }
    }
    public static double getDouble(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        return scanner.nextDouble();
    }
}
