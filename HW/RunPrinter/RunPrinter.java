/**
 * @author Joey Bloom
 * Assignment #31
 * Prints a random sequence of numbers, and puts 
 * parentheses around the longest run
 */

import java.util.Random;

public class RunPrinter
{
    public static void main(String[] args)
    {
        final int TOSSES = 20;
        Random gen = new Random();
        int[] seq = new int[TOSSES];
        for(int i = 0; i < TOSSES; i++)
        {
            seq[i] = gen.nextInt(6) + 1;
        }
        boolean inRun = false;
        for(int i = 0; i < TOSSES - 1; i++)
        {
            if(inRun)
            {
                if(seq[i] != seq[i - 1])
                {
                    System.out.print(") ");
                    inRun = false;
                }
                else
                    System.out.print(" ");
            }  
            else
            {
                if(seq[i] == seq[i + 1])
                {
                    System.out.print(" (");
                    inRun = true;
                }
                else
                    System.out.print(" ");
            }
            System.out.print(seq[i]);
        }
        if(inRun)
            System.out.print(")");
    }
}
/*
Output:
 5 2 5 1 6 5 2 5 4 (3 3) 6 2 6 (5 5) 3 3 5
 2 4 2 1 2 1 6 4 2 1 (5 5 5) 6 5 2 6 1 6
 (3 3) 2 2 6 5 3 6 2 (3 3) 6 2 5 3 (5 5) 3 1
 */
