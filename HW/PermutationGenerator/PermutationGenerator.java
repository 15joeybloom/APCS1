/**
 * @author Joey Bloom
 * Assignment #30
 * Generates random permutations of the numbers 1-10
 */

import java.util.ArrayList;
import java.util.Random;

public class PermutationGenerator
{
    public static void main(String[] args)
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println("List " + i + ": " + nextPermutation());
        }
    }
    public static ArrayList<Integer> nextPermutation()
    {
        ArrayList<Integer> oneToTen = new ArrayList<Integer>(10);
        for(int i = 1; i <= 10; i++)
        {
            oneToTen.add(i);
        }
        ArrayList<Integer> returnMe = new ArrayList<Integer>(10);
        Random gen = new Random();
        for(int i = 10; i > 0; i--)
        {
            returnMe.add(oneToTen.remove(gen.nextInt(i)));
        }
        return returnMe;
    }
}
/*
Output:
List 1: [8, 7, 2, 5, 1, 10, 9, 6, 3, 4]
List 2: [8, 4, 1, 6, 7, 2, 9, 5, 10, 3]
List 3: [6, 2, 7, 10, 9, 5, 8, 1, 3, 4]
List 4: [1, 7, 10, 4, 9, 5, 2, 8, 3, 6]
List 5: [2, 3, 9, 7, 10, 5, 6, 1, 4, 8]
List 6: [9, 3, 6, 2, 4, 10, 5, 8, 7, 1]
List 7: [7, 10, 2, 8, 9, 4, 3, 5, 1, 6]
List 8: [3, 7, 1, 2, 10, 5, 6, 9, 4, 8]
List 9: [1, 10, 6, 9, 3, 8, 2, 4, 7, 5]
List 10: [5, 7, 8, 3, 6, 9, 1, 10, 2, 4]
 */
