
/**
 * Joey Bloom
 * Assignment #7
 * Prints the following
 *      The day and day of the week 100 days from today
 *      The weekday of my birthday
 *      The date that is 10000 days from my birthday
 */

import java.util.*;

public class DatePrinter
{
    public static void main(String[] args)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 100);
        GregorianCalendar myBDay = new GregorianCalendar(
            1996,Calendar.DECEMBER, 25);
            
        
        System.out.println("100 days from today will be " +
            DayConverter.toDay(
            cal.get(Calendar.DAY_OF_WEEK)) +
            ", " + (cal.get(Calendar.MONTH) + 1) + "/" + 
            cal.get(Calendar.DAY_OF_MONTH) + "/" +
            cal.get(Calendar.YEAR) + ".");
            
        System.out.println("I was born on a " +
            DayConverter.toDay(
            myBDay.get(Calendar.DAY_OF_WEEK))
            + ".");
            
        myBDay.add(Calendar.DAY_OF_MONTH, 10000);
        System.out.println("I will be 10,000 days old on " +
            DayConverter.toDay(
            myBDay.get(Calendar.DAY_OF_WEEK))
            + ", " + (myBDay.get(Calendar.MONTH) + 1) 
            + "/" + myBDay.get(Calendar.DAY_OF_MONTH) 
            + "/" + myBDay.get(Calendar.YEAR) + ".");
        
    }
}

/*
Output:

100 days from today will be Thursday, 12/13/2012.
I was born on a Wednesday.
I will be 10,000 days old on Sunday, 5/12/2024.

 */
