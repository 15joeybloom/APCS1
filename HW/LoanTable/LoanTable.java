/**
 * @author Joey Bloom
 * Assignment #24
 * Calculates the monthly payment on a loan
 */

import java.util.Scanner;

public class LoanTable
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Principal ($): ");
        double p = in.nextDouble();
        System.out.print("Time (years): ");
        int n = in.nextInt() * 12;
        System.out.print("Low Rate (%): ");
        double lowRate = in.nextDouble();
        System.out.print("High Rate (%): ");
        double highRate = in.nextDouble();
        System.out.println();
        output(p,n,lowRate,highRate);
    }
    public static void output(double p, int n, 
                              double lowRate, double highRate)
    {
        System.out.println("Annual Interest Rate | Monthly Payment");
        System.out.println("---------------------+----------------");
        double i = lowRate;
        while(i <= highRate)
        {
            double k = i / 100.0 / 12.0;
            double c = Math.pow(1+k,n);
            double a = ( p * k * c )
                             /
                         ( c - 1 );
            a = Math.round( a * 100 ) / 100.0;
            String rate = String.valueOf(i);
            String payment = " " + String.valueOf(a);
            while(rate.length() < "Annual Interest Rate ".length())
                rate += " ";
            rate += "|";
            System.out.println(rate + payment);
            i += 0.25;
        }
    }
}
/*
Output 1:
Annual Interest Rate | Monthly Payment
---------------------+----------------
8.0                  | 1375.44
8.25                 | 1408.25
8.5                  | 1441.33
8.75                 | 1474.67
9.0                  | 1508.27
9.25                 | 1542.11
9.5                  | 1576.18
9.75                 | 1610.48
10.0                 | 1645.01
10.25                | 1679.74
10.5                 | 1714.68
10.75                | 1749.81
11.0                 | 1785.13
11.25                | 1820.63
11.5                 | 1856.3
11.75                | 1892.14
12.0                 | 1928.13

Output 2:
Annual Interest Rate | Monthly Payment
---------------------+----------------
10.0                 | 254.96
10.25                | 256.44
10.5                 | 257.93
10.75                | 259.42
11.0                 | 260.91
11.25                | 262.41
11.5                 | 263.91
11.75                | 265.42
12.0                 | 266.93

 */