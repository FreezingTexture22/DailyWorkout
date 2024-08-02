package ru.andreisesiunin;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        mortgageCalculator();
    }

    public static void mortgageCalculator() {
        int principal = (int) readNumber("Principal (1K - 1M)", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate", 0, 30);
        byte periodYears = (byte) readNumber("Period (Years)", 1, 30);

        calculateMortgage(principal, annualInterestRate, periodYears);
    }

    private static void calculateMortgage(int principal, float annualInterestRate, byte periodYears) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = periodYears * MONTHS_IN_YEAR;

        double monthlyPayment = principal
                * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)));

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(monthlyPayment);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Enter a value berween " + min + " and " + max);
        }
    }
}