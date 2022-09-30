package com.company;

public class Q1{
    public static void main(String[] args){
        int x = Main.getInt("enter the first number");
        int y = Main.getInt("enter the second number");
        int z = euclid(x, y);
        System.out.println("the greatest common divisor is " + z);

        Main.menu();


    }
    public static int euclid(int x, int y){
        if (x == 0){
            return y;
        }
        else if (y == 0){
            return x;
        }
        else if (x == y){
            return x;
        }
        else if (x > y){
            return euclid(x - y, y);
        }
        else{
            return euclid(x, y - x);
        }
    }


}