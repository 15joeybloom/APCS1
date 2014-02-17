/**
 * @author Joey Bloom
 * Assignment #22
 * Calculates the income tax for the given income
 * according to 1913 law.
 */

import java.util.Scanner;

public class TaxPrinter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your income? ");
        try
        {
            double i = in.nextDouble();
            System.out.println("\nYour income tax is: " + get1913Tax(i));
        }
        catch(Exception e)
        {
            System.out.println("Bad input!");
            main(args);
        }
    }
    /**
     * Calculates the income tax for the given income according
     * to the following algorithm:
     * 1% on the first $50,000
     * 2% on the amount over $50,000 up to $75,000
     * 3% on the amount over $75,000 up to $100,000
     * 4% on the amount over $100,000 up to $250,000
     * 5% on the amount over $250,000 up to $500,000
     * 6% on the amount over $500,000
     * @return income tax according to 1913 law
     */
    public static double get1913Tax(double income)
    {
        final double LVL1 = 50000;
        final double LVL2 = 25000;
        final double LVL3 = 25000;
        final double LVL4 = 150000;
        final double LVL5 = 250000;
        if(income < 0)
        {
            return 0;
        }
        double incomeTax = 0;
        incomeTax += .01 * Math.min(income, LVL1);
        income -= LVL1;
        if(income >= 0)
        {
            incomeTax += .02 * Math.min(income, LVL2);
            income -= LVL2;
            if(income >= 0)
            {
                incomeTax += .03 * Math.min(income, LVL3);
                income -= LVL3;
                if(income >= 0)
                {
                    incomeTax += .04 * Math.min(income, LVL4);
                    income -= LVL4;
                    if(income >= 0)
                    {
                        incomeTax += .05 * Math.min(income, LVL5);
                        income -= LVL5;
                        if(income >= 0)
                        {
                            incomeTax += .06 * income;
                        }
                    }
                }
            }
        }
        return incomeTax;
    }
}
/*
Output 1:
What is your income? 17000

Your income tax is: 170.0

Output 2:
What is your income? 60000

Your income tax is: 700.0

Output 3:
What is your income? 100000

Your income tax is: 1750.0

Output 4:
What is your income? 200000

Your income tax is: 5750.0

Output 5:
What is your income? 300000

Your income tax is: 10250.0

Output 6:
What is your income? 1000000

Your income tax is: 50250.0

 */