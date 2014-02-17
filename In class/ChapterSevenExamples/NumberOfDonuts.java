/**
 * @author Joey Bloom
 * In-class Example (for Assignment #26?)
 * 
 */

import java.util.Scanner;

public class NumberOfDonuts
{
    public static void main(String[] args)
    {
//         int henry = 5;//shooting big
//         int theKeesh = 3;//stretching as he says it
//         int wexler = 6;//feeling ambitious
//         int ross = 10;//for real?
//         final int andyGordon = 17;//feeling smart
//         int alexis = 40;//wow
        Scanner reader = new Scanner(System.in);
        
//         int[] numDonuts = new int[8];
//         numDonuts[0] = 5;
//         numDonuts[1] = 3;
//         numDonuts[2] = 6;
//         numDonuts[3] = 10;
//         numDonuts[4] = 17;
//         numDonuts[5] = 40;
//         System.out.println(numDonuts);
        System.out.println("Hi. How many students in the class?");
        int students = reader.nextInt();
        int[] numDonuts = new int[students];
        for(int i = 0; i < numDonuts.length; i++)
        {
            System.out.println("How many donuts for astudent " + i + "?");
            numDonuts[i] = reader.nextInt();
        }
    }
}
