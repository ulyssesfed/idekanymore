package com.company;

public class Q4 {
public static void main(String[] args){
    //quadratic solver
    double a = Main.getDouble("Enter the value of a");
    double b = Main.getDouble("Enter the value of b");
    double c = Main.getDouble("Enter the value of c");
    double discriminant = Math.pow(b, 2) - 4 * a * c; //calculates the discriminant
    if (discriminant < 0){ //if the discriminant is less than 0
        System.out.println("There are no real solutions"); //prints that there are no real solutions
    }
    else if (discriminant == 0){ //if the discriminant is 0
        double x = -b / (2 * a); //calculates the value of x
        System.out.println("There is one solution: " + x); //prints the solution
    }
    else{ //if the discriminant is greater than 0
        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a); //calculates the first solution
        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a); //calculates the second solution
        System.out.println("There are two solutions: " + x1 + " and " + x2); //prints the solutions
    }
    Main.menu(); //calls the menu method
    

}

}