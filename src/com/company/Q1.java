package com.company;

public class Q1{

    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        int x = Main.getInt("Enter the first number: ");
        int y = Main.getInt("Enter the second number: ");
        int gcd = euclid(x, y);
        System.out.println("The greatest common divisor is " + gcd + ".");

        Main.menu();
    }

    public static int euclid(int x, int y) {
        if (x == 0 || y == 0) {
            return Math.max(x, y);
        } else if (x == y) {
            return x;
        } else {
            return euclid(Math.max(x, y) - Math.min(x, y), Math.min(x, y));
        }
    }



}