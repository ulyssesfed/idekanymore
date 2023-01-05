package com.company;

public class Q7 {

    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        int n = Main.getInt("Enter the number of rows"); //gets the number of rows from the user
        int[][] pascal = new int[n][]; //creates a 2d array with n rows
        for (int i = 0; i < n; i++) { //loops through the rows
            pascal[i] = new int[i + 1]; //sets the number of columns to i + 1
            pascal[i][0] = 1; //sets the first value of each row to 1
            pascal[i][i] = 1; //sets the last value of each row to 1
            for (int j = 1; j < i; j++) { //loops through the columns
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j]; //calculates the value of the array
            }
        }
        for (int i = 0; i < n; i++) { //loops through the rows
            for (int j = 0; j < i + 1; j++) { //loops through the columns
                System.out.print(pascal[i][j] + " "); //prints the value of the array
            }
            System.out.println(); //prints a new line
        }
        Main.menu(); //calls the menu method

    }
}