package com.company;

public class Q8 {


    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        double income = 0;

        System.out.println("Would you like to calculate your total income from your hourly wage or your annual wage?");
        String answer = Main.getString("Enter 'hourly' or 'annual'");

        if (answer.equals("hourly")) {
            double hourlyWage = Main.getDouble("Enter your hourly wage");
            double hoursPerDay = Main.getDouble("Enter the number of hours you work per day");
            double daysWorked = Main.getDouble("Enter the number of days you worked per week");
            int daysOff = Main.getInt("Enter the number of days you have taken off this year");
            income = (hourlyWage * ((daysWorked * hoursPerDay) * 52) + hourlyWage * hoursPerDay) - (hourlyWage * hoursPerDay) * daysOff;
        } else if (answer.equals("annual")) {
            income = Main.getDouble("Enter your annual wage");
        } else {
            System.out.println("Invalid answer. Try again.");
            main(args);
        }

        // Personal allowance threshold for the tax year 2021-2022
        final double PERSONAL_ALLOWANCE_THRESHOLD = 12500;

        // Basic rate threshold for the tax year 2021-2022
        final double BASIC_RATE_THRESHOLD = 50000;

        // Higher rate threshold for the tax year 2021-2022
        final double HIGHER_RATE_THRESHOLD = 150000;

        double tax;

        if (income <= PERSONAL_ALLOWANCE_THRESHOLD) {
            // No tax is due on income within the personal allowance threshold
            tax = 0;
        } else if (income <= BASIC_RATE_THRESHOLD) {
            // Calculate the tax due on income within the basic rate threshold
            tax = (income - PERSONAL_ALLOWANCE_THRESHOLD) * 0.2;
        } else if (income <= HIGHER_RATE_THRESHOLD) {
            // Calculate the tax due on income within the higher rate threshold
            tax = (BASIC_RATE_THRESHOLD - PERSONAL_ALLOWANCE_THRESHOLD) * 0.2 + (income - BASIC_RATE_THRESHOLD) * 0.4;
        } else {
            // Calculate the tax due on income within the additional rate threshold
            tax = (HIGHER_RATE_THRESHOLD - BASIC_RATE_THRESHOLD) * 0.4 + (income - HIGHER_RATE_THRESHOLD) * 0.45;
        }


        System.out.println("Your total income is £" + income);
        System.out.println("Your total tax is £" + tax);
        System.out.println("Your net income is £" + (income - tax));
    }
}
