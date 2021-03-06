import java.util.Scanner;
import java.util.Date;

class Loan
{
    private double amount, year, interest;

    public Loan()
    {
        amount = 1000.0;
        year = 1.0;
        interest = 2.5;
    }

    public Loan(double amount, double year, double interest)
    {
        this.amount = amount;
        this.interest = interest;
        this.year = year;

    }

    public double getAmount()
    {
        return amount;
    }

    public double getYear()
    {
        return year;
    }

    public double getInterest()
    {
        return interest;
    }

    public Date getDate()
    {
        Date date = new Date();

        return date;
    }

    public double getMonthlyPayment()
    {
        double monthly_interest = interest / 12 / 100;

        return (amount * monthly_interest) / (1 - (1 / Math.pow((1 + monthly_interest), (year * 12))));
    }

    public double getTotal()
    {
        return this.getMonthlyPayment() * year * 12;
    }
}

public class Question1
{
    public static void main(String[] args)
    {
        System.out.print("Loan Calculation");

        Scanner input = new Scanner(System.in);

        System.out.print("\nLoan Amount: ");
        double amount = input.nextDouble();

        System.out.print("Year(s) of Loan: ");
        double year = input.nextDouble();

        System.out.print("Annual Interest Rate: ");
        double interest = input.nextDouble();

        Loan loan = new Loan(amount, year, interest);

        System.out.print("\nThe loan was created on " + loan.getDate());
        System.out.print("\nMonthly payment: " + String.format("%.2f", loan.getMonthlyPayment()));
        System.out.print("\nOverall payment including " + loan.getInterest() + "% annual interest rate: " + String.format("%.2f", loan.getTotal()));

    }
}
