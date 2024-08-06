package ru.andreisesiunin;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private static MortgageCalculator calculator;


    public static void printMortgage(int principal, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principal, annualInterest, years);
        double mortgage = calculator.calculateMortgage();

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(mortgage);

        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println();

    }

    public static void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");

        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println("Month " + month + ": " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(balance));
        }

    }
}
