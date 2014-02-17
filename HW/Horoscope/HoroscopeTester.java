/**
 * @author Joey Bloom
 * Assignment #21
 * Tests the Horoscope class
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class HoroscopeTester
{
    public static void main(String[] args)
    {
        boolean hasBadInput;
        do
        {
            Scanner in = new Scanner(System.in);
            hasBadInput = false;
            int m = 1;
            int d = 1;
            try
            {
                System.out.print("Enter month: ");
                m = in.nextInt();
                System.out.print("Enter day: ");
                d = in.nextInt();
                Horoscope h = new Horoscope(m,d);
                System.out.println(h.getHoroscope());
            }
            catch(Exception e)
            {
                System.out.println("Bad Input!\n");
                hasBadInput = true;
            }  
        }
        while(hasBadInput);
        //main(args);
    }
}
/*
Output 1:
Enter month: 12
Enter day: 25
Capricorn will have the bestest day ever.
You won't be a n00b, you'll pwn
GregorianCalendar in the face, and you
are the cooliest because I said so.

Output 2:
Enter month: not a month
Bad Input!

Enter month: 1
Enter day: not a day
Bad Input!

Enter month: -2
Enter day: -17
Bad Input!

Enter month: 17
Enter day: 17
You are too magical for my computing abilities

Output 3:
Enter month: 2
Enter day: 30
You are too magical for my computing abilities

 */
