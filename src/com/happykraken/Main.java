package com.happykraken;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int DEFAULT_PRINCIPLE = 500000;
    static double DEFAULT_INTEREST = 0.06;
    static int DEFAULT_YEARS = 30;
    static double DEFAULT_TAX = 0.008;
    static int DEFAULT_INSURANCE = 900;

    public static void main(String[] args) {
	// write your code here
        MortgageCalc mort = new MortgageCalc();

        int principle = get_principle();
        double interest_rate = get_rate();
        int years = years_loan();
        double tax = homeowner_tax();
        int insurance = get_insurance();
        double monthly_payments = mort.prep_equation(principle, interest_rate, years, tax, insurance);
        System.out.println(monthly_payments);
    }

    public static int get_principle() {
        System.out.print("What is the principle? ($500,000) ");

        try {
            return Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            return DEFAULT_PRINCIPLE;
        }
    }

    public static double get_rate() {
        System.out.print("What is the APR? (0.06) ");

        try {
            return Double.parseDouble(in.nextLine());
        } catch (Exception e) {
            return DEFAULT_INTEREST;
        }
    }

    public static int years_loan() {
        System.out.print("How many years is the loan for? (30) ");

        try {
            return Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            return DEFAULT_YEARS;
        }

    }

    public static double homeowner_tax() {
        System.out.print("What is the property tax rate? (0.008) ");

        try {
            return Double.parseDouble(in.nextLine());
        } catch (Exception e) {
            return DEFAULT_TAX;
        }
    }

    public static int get_insurance() {
        System.out.print("How much is the property insurance? ($900) ");

        try {
            return Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            return DEFAULT_INSURANCE;
        }
    }
}
