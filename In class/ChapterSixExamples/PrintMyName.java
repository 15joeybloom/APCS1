/**
 * @author Joey Bloom
 * In-class Example (for Chapter 6)
 * Introduces a for-loop
 */

import java.util.Random;

public class PrintMyName
{
    public static void main(String[] args)
    {
        int r = (new Random()).nextInt(10000) + 1;
        for(int i = 1 ; i < 10000 ; i++)
        {
            if (i % 200 == 0)
            {
                System.out.println("");
            }
            if(i == r)
            {
                System.out.print("U");
                continue;
            }
            System.out.print("V");
        }
    }
}
