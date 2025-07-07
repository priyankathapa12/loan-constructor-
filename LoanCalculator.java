import java.util.Scanner;

public class LoanCalculator {
    private double loanAmount;
    private double interestRate;
    private int loanDurationYears;
    

    public LoanCalculator(double loanAmount, double interestRate, int loanDurationYears) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDurationYears = loanDurationYears;
    }

    public boolean isValidInput() {
        return loanAmount > 0 && interestRate > 0 && loanDurationYears > 0;
    }

    public double calculateTotalInterest() {
        return loanAmount * (interestRate / 100) * loanDurationYears;
    }

    public double calculateMonthlyPayment() {
        double totalAmount = loanAmount + calculateTotalInterest();
        return totalAmount / (loanDurationYears * 12);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLoanDurationYears() {
        return loanDurationYears;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter loan amount in ( NPR): ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double interestRate = scanner.nextDouble();

        System.out.print("Enter loan duration in years: ");
        int loanDurationYears = scanner.nextInt();

        LoanCalculator calculator = new LoanCalculator(loanAmount, interestRate, loanDurationYears);

        if (calculator.isValidInput()) {
            double totalInterest = calculator.calculateTotalInterest();
            double monthlyPayment = calculator.calculateMonthlyPayment();

           System.out.printf("Loan Amount: NPR %.2f%n", calculator.getLoanAmount());
            System.out.printf("Interest Rate: %.2f%%%n", calculator.getInterestRate());
            System.out.printf("Loan Duration: %d years%n", calculator.getLoanDurationYears());
            System.out.printf("Total Interest: NPR %.2f%n", totalInterest);
            System.out.printf("Monthly Payment: NPR %.2f%n", monthlyPayment);  
        } else {
            System.out.println("Invalid input! Please ensure all values are positive.");
        }

        scanner.close();
    }
}