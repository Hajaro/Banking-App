package controllers;

public class LoanCalculator {
    public double calculateMonthlyPayment(double loanAmount, int termInYears, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        int termInMonths = termInYears * 12;
        return loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -termInMonths));
    }
}
