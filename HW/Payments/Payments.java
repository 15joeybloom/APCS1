/**
 * @author Joey Bloom
 * Assignment #25
 * Prints a table containing the total principal due, the
 * interest, the payment amount, and the new balance for
 * each month of the loan.
 */

import java.util.Scanner;

public class Payments
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = in.nextDouble();
        System.out.print("Annual Interest Rate (%): ");
        double monthlyInterestRate = in.nextDouble() / 100.0 / 12.0;
        System.out.print("Monthly payment: ");
        double payment = in.nextDouble();
        
        System.out.println(
            "\nMonth   Principal   Interest   Payment   New Balance\n");
        int month = 1;
        double totalInterest = 0;
        while(principal > payment)
        {
            double interest = principal * monthlyInterestRate;
            totalInterest += interest;
            double newBalance = principal + interest - payment;
            String output = String.valueOf(month);
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
            while(pay.length() < "Payment".length())
                pay = " " + pay;
            output += pay + "   ";
            while(nB.length() < "New Balance".length())
                nB = " " + nB;
            output += nB + "   ";
            System.out.println(output);
            month++;
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
/*
Output:
Principal: 12000
Annual Interest Rate (%): 8.8
Monthly payment: 500

Month   Principal   Interest   Payment   New Balance

    1    12000.00      88.00    500.00      11588.00   
    2    11588.00      84.98    500.00      11172.98   
    3    11172.98      81.94    500.00      10754.91   
    4    10754.91      78.87    500.00      10333.78   
    5    10333.78      75.78    500.00       9909.56   
    6     9909.56      72.67    500.00       9482.23   
    7     9482.23      69.54    500.00       9051.77   
    8     9051.77      66.38    500.00       8618.15   
    9     8618.15      63.20    500.00       8181.35   
   10     8181.35      60.00    500.00       7741.35   
   11     7741.35      56.77    500.00       7298.12   
   12     7298.12      53.52    500.00       6851.64   
   13     6851.64      50.25    500.00       6401.88   
   14     6401.88      46.95    500.00       5948.83   
   15     5948.83      43.62    500.00       5492.45   
   16     5492.45      40.28    500.00       5032.73   
   17     5032.73      36.91    500.00       4569.64   
   18     4569.64      33.51    500.00       4103.15   
   19     4103.15      30.09    500.00       3633.24   
   20     3633.24      26.64    500.00       3159.88   
   21     3159.88      23.17    500.00       2683.05   
   22     2683.05      19.68    500.00       2202.73   
   23     2202.73      16.15    500.00       1718.88   
   24     1718.88      12.61    500.00       1231.49   
   25     1231.49       9.03    500.00        740.52   
   26      740.52       5.43    500.00        245.95   

                     1245.95 Total Interest

 */
