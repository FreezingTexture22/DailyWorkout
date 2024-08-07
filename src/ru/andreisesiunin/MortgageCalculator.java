package ru.andreisesiunin;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        double monthlyInterestRate = getMonthlyInterest(annualInterest);
        byte numberOfPayments = getNumberOfPayments();
        return principal
                * ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - (Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)))
                / ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - 1);
    }

    public double calculateMortgage() {
        double monthlyInterestRate = getMonthlyInterest(annualInterest);
        byte numberOfPayments = getNumberOfPayments();
        return principal * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)));
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month-1] = calculateBalance(month);
        }
        return balances;
    }

    private byte getNumberOfPayments() {
        return (byte) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterest(float annualInterest) {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

}
