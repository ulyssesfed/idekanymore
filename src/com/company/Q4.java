package com.company;

public class Q4 {
public static void main(String[] args){
    //quadratic solver
    double a = Main.getDouble("Enter the value of a");
    double b = Main.getDouble("Enter the value of b");
    double c = Main.getDouble("Enter the value of c");
    double discriminant = Math.pow(b, 2) - 4 * a * c;
    if (discriminant < 0){
        System.out.println("There are no real solutions");
    }
    else if (discriminant == 0){
        double x = -b / (2 * a);
        System.out.println("There is one solution: " + x);
    }
    else{
        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        System.out.println("There are two solutions: " + x1 + " and " + x2);
    }
    Main.menu();
    

}

}