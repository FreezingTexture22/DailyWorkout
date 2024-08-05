package ru.andreisesiunin;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Mortgage mortgage = new Mortgage();
        mortgage.mortgageCalculator();
    }
}


class Mortgage {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;
    int principal;
    float annualInterestRate;
    byte periodYears;
    float monthlyInterestRate;
    int numberOfPayments;


    public Mortgage() {
        this.principal = (int) readNumber("Principal (1K - 1M)", 1000, 1_000_000);
        this.annualInterestRate = (float) readNumber("Annual Interest Rate", 0, 30);
        this.periodYears = (byte) readNumber("Period (Years)", 1, 30);
        this.monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        this.numberOfPayments = periodYears * MONTHS_IN_YEAR;
    }


    public void mortgageCalculator() {
        double monthlyPayment = calculateMonthlyPayment(principal);
        printMortgagePayments(monthlyPayment);
    }


    private double calculateMonthlyPayment(int principal) {
        return principal * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)));
    }


    public double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("Enter a value between " + min + " and " + max);
        }
    }


    public void printMortgagePayments(double monthlyPayment) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(monthlyPayment);
        System.out.println("MORTGAGE" + "\n" + "________");
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println();
        System.out.println("PAYMENT SCHEDULE" + "\n" + "________________");

        for (short month = 1; month < numberOfPayments; month++) {
            double balance = calculateBalance(month);

            System.out.println("Month " + month + ": " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(balance));
        }

    }

    private double calculateBalance(short numberOfPaymentsMade) {
        return principal
                * ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - (Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)))
                / ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - 1);
    }

}