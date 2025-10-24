import java.time.Year;
import java.util.Scanner;
public class Main {
    void main() {
        Scanner scan = new Scanner(System.in);

        double loanAmount;
        double apr;
        double loanTerm;
        double years;
        char percent = '%';

        System.out.print("Amount borrowed: ");
        loanAmount = scan.nextDouble();

        System.out.print("APR amount (i.e 13.34% --> 13.34): ");
        apr = scan.nextDouble() / 100;

        System.out.print("How long is your loan in months?: ");
        loanTerm = scan.nextDouble();

        years = loanTerm / 12;
        double compoundingYears = years * 365.25;

        double dailyApr = (apr / compoundingYears) * 100;
        String formattedDailyApr = String.format("%.5f", dailyApr);

        double dailyCompoundingApr = (Math.pow(1 + apr, 1.0 / 365.25) - 1) * 100;
        String formattedDailyCompoundingApr = String.format("%.5f", dailyCompoundingApr);

        System.out.println("-----------------------------------");

        System.out.println("Your daily interest rate is " + formattedDailyApr + percent);
        System.out.println("Your daily COMPOUNDING interest rate is " + formattedDailyCompoundingApr + percent);
        scan.close();
    }
}
