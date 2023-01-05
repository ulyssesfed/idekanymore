package com.company;

public class Q8 {


    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        // tax calculator for the uk that takes into account the tax free allowance and the tax bands and allows the user to enter the amount of income

        double income = 0; //creates a variable for the income
        System.out.println("woul dyou like calculate your total income from your hourly wage or your annual wage?"); // asks the user if they want to calculate their income from their hourly wage or their annual wage
        String answer = Main.getString("enter hourly or annual"); // gets the answer from the user
        if (answer.equals("hourly")) { // if the answer is hourly
            double hourlywage = Main.getDouble("enter your hourly wage"); // gets the hourly wage from the user
            double hoursPerDay = Main.getDouble("enter the number of hours you work per day"); // gets the number of hours worked per day from the user
            double daysworked = Main.getDouble("enter the number of days you worked per week"); // gets the number of hours worked from the user
            int daysOff = Main.getInt("enter the number of days you have taken off through the year"); // gets the number of days off from the user
            income = (hourlywage * ((daysworked*hoursPerDay)*52)+hourlywage*hoursPerDay) - (hourlywage*hoursPerDay)*daysOff; // calculates the income
        } else if (answer.equals("annual")) { // if the answer is annual
            income = Main.getDouble("enter your annual wage"); // gets the annual wage from the user
        } else { // if the answer is not hourly or annual
            System.out.println("invalid answer"); // prints invalid answer
            System.out.println("try again");
            main(args); // restarts the program
        }
        double tax = 0; //creates a variable for the tax
        if (income <= 12500) { //checks if the income is less than or equal to the tax free allowance
            tax = 0; //sets the tax to 0
        } else if (income <= 50000) { //checks if the income is less than or equal to the first tax band
            tax = (income - 12500) * 0.2; //calculates the tax
        } else if (income <= 150000) { //checks if the income is less than or equal to the second tax band
            tax = 7500 + (income - 50000) * 0.4; //calculates the tax
        } else { //checks if the income is greater than the second tax band
            tax = 47500 + (income - 150000) * 0.45; //calculates the tax
        }
        System.out.println("your total income is £" + income); //prints the income
        System.out.println("The tax is £" + tax); //prints the tax

        System.out.println("your remaining income is £" + (income - tax)); //prints the remaining income
        Main.menu(); //calls the menu method
    }

}
