
/**
 * @author Joey Bloom
 * In-class example (Chapter 6)
 * Introduces a while-loop
 */

import java.util.Scanner;

public class UntilNegativeOne
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println
            ("Enter any positive integer" +
             ", or -1 to quit.");
        int userInput = reader.nextInt();
        
        while(userInput != -1)
        {
            System.out.println(userInput * userInput);
            userInput = reader.nextInt();
        }
    }
}
