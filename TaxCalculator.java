import java.util.Scanner;
abstract class Taxoperation {
    abstract double calculateTax(double taxableIncome);
}
class NewTax extends Taxoperation {
    public double calculateTax(double income) {
        double tax = 0;
        if (income <= 300000) {
            tax = 0;
        } else if (income <= 600000) {
            tax = (income - 300000) * 0.05;
        } else if (income <= 900000) {
            tax = (300000 * 0.05) + (income - 600000) * 0.10;
        } else if (income <= 1200000) {
            tax = (300000 * 0.05) + (300000 * 0.10)
                    + (income - 900000) * 0.15;
        } else {
            tax = (300000 * 0.05) + (300000 * 0.10)
                    + (300000 * 0.15) + (income - 1200000) * 0.20;
        }
        return tax;
    }
}
class TaxPayer {
    private String name;
    private String pan;
    private double income;
    private double deduction;
    public TaxPayer(String name, String pan, double income, double deduction) {
        this.name = name;
        this.pan = pan;
        this.income = income;
        this.deduction = deduction;
    }
    public String getName() {
        return name;
    }
    public String getPan() {
        return pan;
    }
    public double getIncome() {
        return income;
    }
    public double getDeduction() {
        return deduction;
    }
    public double getTaxableIncome() {
        return income - deduction;
    }
}
class Salaried extends TaxPayer {
    public Salaried(String name, String pan, double income, double deduction) {
        super(name, pan, income, deduction);
    }
}
class Business extends TaxPayer {
    public Business(String name, String pan, double income, double deduction) {
        super(name, pan, income, deduction);
    }
}
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Smart Tax Calculator");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your PAN number: ");
        String pan = sc.nextLine();
        System.out.print("Enter your annual income: ");
        double income = sc.nextDouble();
        System.out.print("Enter deductions (if any): ");
        double deduction = sc.nextDouble();
        Taxoperation obj = new NewTax();
        TaxPayer tp = new Salaried(name, pan, income, deduction);
        System.out.println("\nTaxpayer: " + tp.getName());
        System.out.println("PAN: " + tp.getPan());
        System.out.println("Annual Income: " + tp.getIncome());
        System.out.println("Deductions: " + tp.getDeduction());
        double taxableIncome = tp.getTaxableIncome();
        double tax = obj.calculateTax(taxableIncome);
        System.out.println("Taxable Income: " + taxableIncome);
        System.out.println("Total Tax Payable: ₹" + tax);
    }
}
