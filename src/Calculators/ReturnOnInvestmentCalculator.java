package Calculators;

import utils.InputScanner;

public class ReturnOnInvestmentCalculator {

    double cashRisked;
    double total;

    public void calculateReturnOnInvestment() {
        System.out.print("What amount of cash did you risk? $");
        cashRisked = InputScanner.getScan().nextDouble();

        System.out.print("What is your cash total after the sale? $");
        total = InputScanner.getScan().nextDouble();

        double cashAdded = total - cashRisked;
        String formattedDollarAmount = String.format("$%.2f", cashAdded);

        String roi = calculateROIPercent(cashRisked, total);
        determineReturnOnInvestment(cashAdded, roi, formattedDollarAmount);
    }

    private String calculateROIPercent(double cashRisked, double total) {
        double returnOnInvestment = ((total - cashRisked) / cashRisked) * 100;
        String stringifyReturn = String.valueOf(returnOnInvestment);
        boolean isEmptyDecimal = stringifyReturn.contains(".0");

        if (isEmptyDecimal) {
            int wholeReturn = (int) returnOnInvestment;
            return wholeReturn + "%";
        }
        return String.format("%.2f%%", returnOnInvestment);
    }

    private void determineReturnOnInvestment(double cashAdded, String roi, String formattedDollarAmount) {
        if (cashAdded > 0) {
            System.out.println("Your return is " + roi + ", or " + formattedDollarAmount);
        } else if (cashAdded == 0) {
            System.out.println("Your return is " + roi + "; you broke even.");
        } else {
            formattedDollarAmount = formattedDollarAmount.replace("-", "");
            System.out.println("Your return is " + roi + ", you lost " + formattedDollarAmount);
        }
    }


}
