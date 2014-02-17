/**
 * @author Joey Bloom
 * Extra Credit Assignment 6.10
 * Tests the RootApproximator class
 */

import java.util.Scanner;

public class RootCalculator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number you'd like to square root: ");
        double a = in.nextDouble();
        final double EPSILON = 1E-20;
        RootApproximator approx = new RootApproximator(a, EPSILON);
        while(approx.hasMoreGuesses())
            System.out.println(approx.nextGuess());
    }
}
/*
Output 1:
Enter the number you'd like to square root: 49
25.0
13.48
8.557507418397627
7.141736912383411
7.001406475243939
7.000000141269659
7.000000000000002
7.0

Output 2:
Enter the number you'd like to square root: 2
1.5
1.4166666666666665
1.4142156862745097
1.4142135623746899
1.414213562373095

Output 3:
Enter the number you'd like to square root: 6.25
3.625
2.674568965517241
2.505697053266276
2.500006476524342
2.500000000008389
2.5

 */