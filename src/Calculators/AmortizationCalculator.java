package Calculators;

import utils.InputScanner;

public class AmortizationCalculator {

    double amountBorrowed;
    double annualInterestRate;
    int years;


    public void calculateAmortization() {
        System.out.print("What is the amount you borrowed? $");
        amountBorrowed = InputScanner.getScan().nextDouble();

        System.out.print("What is the interest rate? (i.e 5.418% --> 5.418) ");
        annualInterestRate = InputScanner.getScan().nextDouble() / 100;

        System.out.print("How long is the loan in years? ");
        years = InputScanner.getScan().nextInt();

        double amortizationAmount = calculateAmortizationAmount(amountBorrowed, annualInterestRate, years);
        System.out.println("Your monthly payment is $" + Math.round(amortizationAmount * 100.0) / 100.0);
        System.out.println("Here is a calendar your your principal and interest:");
        System.out.println("-------------------------------------------------");
        calculateAmortizationCalendar(amountBorrowed, annualInterestRate, years, amortizationAmount);
    }

    private double calculateAmortizationAmount(double amount, double rate, int years) {
        double months = years * 12;
        double monthlyInterest = rate / 12;

        double sqrt = Math.pow(1 + monthlyInterest, months);
        double numerator = monthlyInterest * sqrt;
        double denominator = sqrt - 1;
        return amount * (numerator / denominator);
    }

    private void calculateAmortizationCalendar(double amount, double rate, int years, double amortAmount) {
        double months = years * 12;
        double monthlyInterest = rate / 12; // 0.0025
        double interest;
        double principal;

        System.out.println("Month | Interest | Principal | Balance");
        // TODO: refactor into a List
        for (int month = 1; month <= months; month++) {

            interest = amount * monthlyInterest;
            principal = amortAmount - interest;
            amount -= principal;

            System.out.printf("%-10s %-10.2f %-10.2f %-10.2f%n", month, interest, principal, amount);
        }


    }
}
