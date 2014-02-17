/**
 * @author Joey Bloom
 * Assignment #32b
 * User enters a sequence of numbers. sequence is checked
 * for length is a square number, all positive integers up
 * to and including length are present, and then checks the sum
 * of the rows, columns, and diagonals.
 */

import java.util.Scanner;

public class MagicSquareChecker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Square test1 = new Square(16,3,2,13,
                                  5,10,11,8,
                                  9,6,7,12,
                                  4,15,14,1);
        Square test2 = new Square(
                16,3,2,13,
                5,10,11,8,
                4,15,14,1,
                9,6,7,12);
        Square test3 = new Square(
                11,18,25,2,9,
                10,12,19,21,3,
                4,6,13,20,22,
                23,5,7,14,16,
                17,24,1,8,15);
        Square test4 = new Square(
                2,7,6,
                9,5,1,
                4,3,8);
        Square test5 = new Square(1);
        System.out.println(test1.isMagic());//true
        System.out.println(test2.isMagic());//false
        System.out.println(test3.isMagic());//true
        System.out.println(test4.isMagic());//true
        System.out.println(test5.isMagic());//true
    }
}
/*
Output:
true
false
true
true
true
 */
