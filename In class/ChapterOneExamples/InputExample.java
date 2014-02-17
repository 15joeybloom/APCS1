/*
 * Joey Bloom
 * In-Class Example #2
 * Introduces user input
 */

import java.util.Scanner;

public class InputExample
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);        
        System.out.println("Hi. How much money do you have in your pocket?");
        double money = reader.nextDouble();
        System.out.println("You have: $" + money + " in your pocket.");
        
    }
}

/*
 * Output:
 * Hi. What is your age?
 * 15
 * Your age is: 15
 * 
 */

