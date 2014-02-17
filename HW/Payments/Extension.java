/**
 * @author Joey Bloom
 * Assignment #25
 * Prints a table containing the total principal due, the
 * interest, the payment amount, and the new balance for
 * each month of the loan.
 */

import java.util.Scanner;

public class Extension
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Starting principal to invest: ");
        double principal = in.nextDouble();
        System.out.print("Annual Rate of return (%): ");
        double monthlyInterestRate = in.nextDouble() / 100.0 / 12.0;
        System.out.print("Monthly addition to principal: ");
        double payment = in.nextDouble();
        System.out.print("Number of months to iterate: ");
        int month = in.nextInt();
        
        System.out.println(
            "\nMonth   Principal   Interest   Investment   New Balance\n");
        double totalInterest = 0;
        int m = 1;
        while(m <= month)
        {
            double interest = principal * monthlyInterestRate;
            totalInterest += interest;
            double newBalance = principal + interest + payment;
            String output = String.valueOf(m);
            String pr = String.valueOf(Math.round(principal * 100) / 100.0);
            pr = fixTwo(pr);
            String i = String.valueOf(Math.round(interest * 100) / 100.0);
            i = fixTwo(i);
            String pay = String.valueOf(Math.round(payment * 100) / 100.0);
            pay = fixTwo(pay);
            String nB = String.valueOf(Math.round(newBalance * 100) / 100.0);
            nB = fixTwo(nB);
            while(output.length() < "Month".length())
                output = " " + output;
            output += "   ";
            while(pr.length() < "Principal".length())
                pr = " " + pr;
            output += pr + "   ";
            while(i.length() < "Interest".length())
                i = " " + i;
            output += i + "   ";
            while(pay.length() < "Investment".length())
                pay = " " + pay;
            output += pay + "   ";
            while(nB.length() < "New Balance".length())
                nB = " " + nB;
            output += nB + "   ";
            System.out.println(output);
            m++;
            principal = newBalance;
        }
        String tI = fixTwo(String.valueOf(Math.round(totalInterest * 100) / 100.0));
        System.out.println(
            "\n                     " + tI + " Total Interest");             
    }
    /**
     * value is a String containing a double. this adds a zero to the end
     * of the String if it only has one decimal place
     * @return String with a zero possibly added to the end
     */
    public static String fixTwo(String value)
    {
        if( value.indexOf(".") == value.length() - 2)
            value += "0";
        return value;        
    }
}