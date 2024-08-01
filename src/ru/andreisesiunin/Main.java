package ru.andreisesiunin;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mortgageCalculator();

    }

    public static void mortgageCalculator() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal (1K - 1M): ");
            principal = scanner.nextInt();

            if (principal < 1_000 || principal > 1_000_000) {
                System.out.println("Enter a number between 1.000 and 1.000.000");
            } else break;
        }

        double annualInterestRate;
        double monthlyInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextDouble() / PERCENT;
            if (annualInterestRate <= 0 || annualInterestRate > 0.3) {
                System.out.println("Enter a value grater than 0 and less than or equal than 30");
            } else {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
                break;
            }
        }

        byte periodYears;
        int numberOfPayments;
        while (true) {
            System.out.print("Period (Years): ");
            periodYears = scanner.nextByte();
            if (periodYears < 1 || periodYears > 30) {
                System.out.println("Enter a value between 1 and 30");
            } else {
                numberOfPayments = periodYears * MONTHS_IN_YEAR;
                break;
            }
        }


        double monthlyPayment = principal
                * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)));

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(monthlyPayment);
        System.out.println("Mortgage: " + mortgageFormatted);


    }
}