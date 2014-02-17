/*
 * Joey Bloom
 * Homework Assignment #2
 * Introduces user input
 */

import java.util.Scanner;

public class InputExample
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);        
        System.out.println("Hi. What's your name?");
        String name = reader.nextLine();
        System.out.println("       ,-------------,");
        System.out.println("      / Pleasure to / ");
        System.out.println("     / meet you,   /  ");
        System.out.println("      " + name + ".");
        System.out.println("   / '           / '  ");
        System.out.println("  /' /          /'/   ");
        System.out.println("    /           /     ");
        System.out.println("    /         /       ");
        System.out.println("   /        /         ");
        System.out.println("   /      /           ");
        System.out.println("  /     /             ");
        System.out.println("  /   /               ");
        System.out.println(" /  /                 ");
        System.out.println(" //                   ");
        System.out.println(" '                    ");
        
    }
}

/*
 * Output:
Hi. What's your name?
Joey
       ,-------------,
      / Pleasure to / 
     / meet you,   /  
      Joey.
   / '           / '  
  /' /          /'/   
    /           /     
    /         /       
   /        /         
   /      /           
  /     /             
  /   /               
 /  /                 
 //                   
 ' 
 
 * 
 */

