/**
 * @author Joey Bloom
 * Assignment #20
 * Tests the Card class
 */

import java.util.Scanner;

public class CardTester
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the card notation");
        Card c = new Card(reader.nextLine());
        System.out.println(c.getDescription());
        //main(args);
        //:P
    }
}

/*
Output 1:
Enter the card notation
5d
Five of Diamonds

Output 2:
Enter the card notation
10S
Ten of Spades

Output 3:
Enter the card notation
 0S
unknown

Output 4:
Enter the card notation
 
unknown

Output 5:
Enter the card notation
 9c
unknown

Output 6:
Enter the card notation
9c
Nine of Clubs
 */