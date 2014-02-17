
/**
 * Joey Bloom
 * 9/13/12
 * MeanMedianMode provides static
 * methods for calculating the mean, median,
 * and mode of the data set passed
 * to the method.
 */

import java.util.*;

public class MeanMedianMode
{
      
    /**
     * Returns the sum of all the elements in the data set
     * divided by the number of elements in the data set.
     * 
     * @param dataSet The data set that the mean
     *                is being found of.
     * @return The mean of the data set.
     */
    
    public static double mean( ArrayList<Double> dataSet)
    {
        double sum = 0;
        for(int i = 0 ; i < dataSet.size() ; i++ )
        {
            sum = sum + dataSet.get(i);
        }
        return sum / (double) dataSet.size();
    }
    
    /**
     * Returns the median of the data set by determining
     * the lowest value in the array, removing it, determining
     * the highest value in the array, removing it, and repeat.
     * When there is either 2 or 1 values left after removing
     * equal amounts of highest and lowest, the method returns
     * the average of the 2 remaining if there are 2 remaining
     * or the remaining number if there is 1 remaining.
     * 
     * @param dataSet The data set that the median
     *                is being found of.
     * @return The median of the data set.
     */
    public static double median( ArrayList<Double> dataSet)
    {
        ArrayList<Double> medianSet =
            new ArrayList<Double>(dataSet);
        int lowest = 0;
        int highest = 0;
        while( medianSet.size() > 2 )
        {
            lowest = 0;
            for(int i = 1 ; i < medianSet.size() ; i++)
            {
                if( medianSet.get(i) < medianSet.get(lowest) )
                {
                    lowest = i;
                }
            }
            medianSet.remove(lowest);
            highest = 0;
            for(int i = 1 ; i < medianSet.size() ; i++ )
            {
                if( medianSet.get(i) > medianSet.get(highest) )
                {
                    highest = i;
                }
            }
            medianSet.remove(highest);
        }
        if( medianSet.size() == 2 )
        {
            return (medianSet.get(0) 
                + medianSet.get(1)) / 2.0;
        }
        else if( medianSet.size() == 1 )
        {
            return medianSet.get(0);
        }
        else 
        {    
            return 3.1415926;
        }
    }
    
    /**
     * Returns the number in the data set that occurs 
     * the greatest number of times. The method
     * creates an array of ints such that the int at
     * index i represents the number of occurrences
     * of the double at index i in the data set
     * passed in. Then, it finds the largest number
     * in this new array. Then, for every index
     * in the new array that has the largest number, it
     * adds the double at that index in the data set
     * to the array of doubles containing the mode(s)
     * of the data set, unless the mode array already
     * has the current selection.
     * 
     * @param dataSet The data set that 
     *                the mode is being found of.
     * @return The mode of dataSet.                
     */
    public static ArrayList<Double> mode( 
        ArrayList<Double> dataSet)
    {
        ArrayList<Double> modeSet =
            new ArrayList<Double>(dataSet);
        ArrayList<Double> modes = 
            new ArrayList<Double>();
        ArrayList<Integer> occurrencesArray =
            new ArrayList<Integer>(modeSet.size());
        
        //initialize the array of the number of occurrences
        for( int i = 0 ; i < modeSet.size() ; i++ )
        {
            occurrencesArray.add( 
                numberOfOccurrences(modeSet, 
                                    modeSet.get(i)));            
        }
        
        int mostOccurrencesIndex = occurrencesArray.get(0);
        
        //find the highest number of number of occurrences
        for(int i = 1 ; i < occurrencesArray.size() - 1 ; i++ )
        {
            if( occurrencesArray.get(i) > 
                occurrencesArray.get(mostOccurrencesIndex) )
            {
                mostOccurrencesIndex = i;
            }
        }
        
        //checks that there is a mode(s)
        boolean isThereAMode = false;
        for(int i = 1 ; i < occurrencesArray.size() ; i++)
        {
            if( occurrencesArray.get(0) != 
                occurrencesArray.get(i) )
            {
                isThereAMode = true;
                break;
            }
        }
        if( isThereAMode == false )
        {
            return modes;
        }
        
        //if number is a mode and isn't already in the mode
        //array, then add it to the mode array
        for( int i = 0 ; i < occurrencesArray.size() ; i++ )
        {
            if(occurrencesArray.get(i) == 
               occurrencesArray.get(mostOccurrencesIndex) && 
                !modes.contains( modeSet.get(i)))
            {
                modes.add(modeSet.get(i));
            }
            
        }
        return modes;
    }
    
    /**
     * Returns how many occurrences of the
     * specified double there are in the
     * specified array of doubles.
     * 
     * @param tempSet The ArrayList<Double> you would
     *      like to search.
     * @param number The double you would like to search for.
     * @return The number of occurrences of number in tempSet.
     */
    private static int numberOfOccurrences( 
        ArrayList<Double> dataSet, 
        double number )
    {
        ArrayList<Double> tempSet =
            new ArrayList<Double>(dataSet);
        int indexOfNext;
        int occurrences = 0;
        while (true)
        {
            indexOfNext =
                tempSet.indexOf(number);
            if(indexOfNext == -1)
            {
                break;
            }
            else
            {
                occurrences++;
                tempSet.remove(indexOfNext);
            }
        }
        return occurrences;
    }
}