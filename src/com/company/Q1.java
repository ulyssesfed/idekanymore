package com.company;

public class Q1{

    public static void run(){
        main(null);
    }
    public static void main(String[] args){
        int x = Main.getInt("enter the first number");
        int y = Main.getInt("enter the second number");
        int z = euclid(x, y); //calls the euclid method
        System.out.println("the greatest common divisor is " + z); //prints the greatest common divisor

        Main.menu();//calls the menu method


    }
    public static int euclid(int x, int y){ //the euclid method
        if (x == 0){
            return y; //returns y if x is 0
        }
        else if (y == 0){
            return x; //returns x if y is 0
        }
        else if (x == y){
            return x; //returns x if x and y are equal
        }
        else if (x > y){
            return euclid(x - y, y); //calls the euclid method with x - y and y
        }
        else{
            return euclid(x, y - x); //calls the euclid method with x and y - x
        }
    }//end of euclid method


}