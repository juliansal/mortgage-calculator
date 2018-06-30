package com.happykraken;

public class MortgageCalc {

    private static double mortgage_equation(int principle, double interest_rate, int years) {
        return (principle * ((interest_rate * (Math.pow(1 + interest_rate, years)) / ((Math.pow(1 + interest_rate, years)) - 1))));
    }

    public static double prep_equation(int principle, double interest_rate, int years, double tax, int ins) {
        principle = set_principle(principle);
        interest_rate = set_rate(interest_rate);
        int months = set_mortgage_years(years);
        tax = set_monthly_tax(principle, tax);
        float insurance = property_insurance(ins);

        double mort = mortgage_equation(principle, interest_rate, months);
        double total = mort + tax + insurance;

        return Math.round(total * 100) / 100D;
    }

    private static int set_principle(int principle) {
        return principle;
    }

    private static double set_rate(double rate) {
        return rate / 12;
    }

    private static int set_mortgage_years(int yrs) {
        return yrs * 12;
    }

    private static double set_monthly_tax(int principle, double tax_rate) {
        principle = set_principle(principle);

        return (principle * tax_rate) / 12;
    }

    private static float property_insurance(int insurance) {
        return insurance / 6;
    }
}
