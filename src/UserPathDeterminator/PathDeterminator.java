package UserPathDeterminator;
import Calculators.AmortizationCalculator;
import Calculators.CompoundInterestCalculator;
import Calculators.ReturnOnInvestmentCalculator;
import utils.InputScanner;


public class PathDeterminator {
    CompoundInterestCalculator compoundInterest = new CompoundInterestCalculator();
    ReturnOnInvestmentCalculator roiCalculator = new ReturnOnInvestmentCalculator();
    AmortizationCalculator amortizationCalculator = new AmortizationCalculator();
    String response;

    public void determineUserFinancialNeed() {
        System.out.println("Hello, what kind of calculation are you looking for?");
        System.out.println(
            "[1] " + Choices.LOAN_INTEREST_CALCULATOR +
            " [2] " + Choices.ROI_CALCULATOR +
            " [3] " + Choices.AMORTIZATION_CALCULATOR
        );
        response = InputScanner.getScan().nextLine();
        switch (response) {
            case "1":
                System.out.println("So you want an auto loan calculation. Okay.");
                compoundInterest.calculateInterest();
                break;
            case "2":
                System.out.println("So you want a ROI calculation. Okay.");
                roiCalculator.calculateReturnOnInvestment();
                break;
            case "3":
                System.out.println("So you want a amortization calculation. Okay.");
                amortizationCalculator.calculateAmortization();
                break;
            default:
                System.out.println("Please choose an number 1-3");
        }
        InputScanner.getScan().close();
    }

}
