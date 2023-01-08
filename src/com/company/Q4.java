package com.company;

import static com.company.Main.menu;

public class Q4 {

    public static void run() {
        main(null);
    }

    public static void main(String[] args) {
        double a = Main.getDouble("Enter the value of a: ");
        double b = Main.getDouble("Enter the value of b: ");
        double c = Main.getDouble("Enter the value of c: ");

        double[] solutions = solveQuadratic(a, b, c);
        printSolutions(solutions);

        menu();
    }

    private static double[] solveQuadratic(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{x1, x2};
        }
    }

    private static void printSolutions(double[] solutions) {
        if (solutions.length == 0) {
            System.out.println("There are no real solutions");
        }
        for (double solution : solutions) {
            System.out.println("x = " + solution);
        }



    }
}