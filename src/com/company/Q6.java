package com.company;

public class Q6 {
    public static void main(String[] args) {
        int n = Main.getInt("Enter the number of terms"); //gets the number of terms from the user
        int a = 0; //creates a variable for the first term
        int b = 1; //creates a variable for the second term
        int c = 0; //creates a variable for the third term
        System.out.print(a + " " + b + " "); //prints the first two terms
        for (int i = 0; i < n - 2; i++) { //for loop that runs n - 2 times
            c = a + b; //calculates the third term
            System.out.print(c + " "); //prints the third term
            a = b; //sets a to b
            b = c; //sets b to c
        }
        System.out.println(); //prints a new line
        Main.menu(); //calls the menu method
    }
    
}
