
/**
 * @author Steve Svetlik
 * In-class Example (Chapter 7)
 * Introduces helper methods focusing
 * on passing arrays as parameters
 */

import java.util.ArrayList;

public class HelperMethods
{
    public static void main(String[] args)
    {
        int[] numbers = {6,3,2,3,4,6,6,8};
        int sixes = numberInstances(numbers, 6);
        int threes = numberInstances(numbers, 3);
        int seventeens = numberInstances(numbers, 17);
        System.out.println(sixes);
        System.out.println(threes);
        System.out.println(seventeens);
        int firstFour = firstInstance(numbers, 4);
        int firstSix = firstInstance(numbers, 6);
        int firstSeventeen = firstInstance(numbers, 17);
        System.out.println(firstFour);
        System.out.println(firstSix);
        System.out.println(firstSeventeen);
    }
    /**
     * Find the number of instance a given target value is
     * contained within a given array, and returns that number.
     * @param x the array we wish to traverse
     * @param target the number we are searching for
     * @return the number of instances the number was found
     */
    public static int numberInstances(int[] x, int target)
    {
        int numberTimes = 0;
        //I have no clue how to do the rest of this :(
//         for(int i = 0; i < x.length; i++)
//         {
//             if(x[i] == target)
//                 numberTimes++;
//         }
        for( int number : x)
        {
            if(number == target)
                numberTimes++;
        }
        return numberTimes;
    }
    /**
     * Finds the first instance of a target value within a given
     * array, and returns the location of that instance. Returns -1
     * if target is absent.
     * 
     * @param x the array we wish to traverse
     * @param target the number wea are searching for
     * @return the index of the first instance of the target
     */
    public static int firstInstance(int[] x, int target)
    {
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] == target)
                return i;
        }
        return -1;
    }
}