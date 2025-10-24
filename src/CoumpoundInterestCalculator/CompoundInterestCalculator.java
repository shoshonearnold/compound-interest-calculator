package CoumpoundInterestCalculator;

import java.util.Scanner;

public class CompoundInterestCalculator {
    Scanner scan = new Scanner(System.in);

    double loanAmount;
    double apr;
    double loanTerm;
    double years;
    char percent = '%';

    public void calculateInterest() {
        gatherUserInput();
        years = loanTerm / 12;
        String formattedDailyApr = this.determineDailyApr(years, apr);
        String formattedDailyCompoundingApr = this.determineDailyCompoundingApr(apr);
        System.out.println("-----------------------------------");

        System.out.println("Your daily interest rate is "+ formattedDailyApr + percent);
        System.out.println("Your daily COMPOUNDING interest rate is "+formattedDailyCompoundingApr +percent);
    }

    private void gatherUserInput() {
        System.out.print("Amount borrowed: ");
        loanAmount = scan.nextDouble();
        System.out.print("APR amount (i.e 13.34% --> 13.34): ");
        apr = scan.nextDouble() / 100;
        System.out.print("How long is your loan in months?: ");
        loanTerm = scan.nextDouble();
        scan.close();
    }

    private String determineDailyApr(double years, double apr) {
        double compoundingYears = years * 365.25;
        double dailyApr = (apr / compoundingYears) * 100;
        return String.format("%.5f", dailyApr);
    }

    private String determineDailyCompoundingApr(double apr) {
        double dailyCompoundingApr = (Math.pow(1 + apr, 1.0 / 365.25) - 1) * 100;
        return String.format("%.5f", dailyCompoundingApr);
    }
}
