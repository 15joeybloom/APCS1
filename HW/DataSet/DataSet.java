
/**
 * @author Joey Bloom
 * Assignment #17
 * Computes the largest and smallest values in a sequence of numbers
 */
public class DataSet
{
    private int largest;
    private int smallest;
    
    /**
     * Creates a new DataSet with the largest number at -2^31
     * and smallest at 2^31 - 1.
     */
    public DataSet()
    {
        largest = Integer.MIN_VALUE;
        smallest = Integer.MAX_VALUE;
    }
    
    /**
     * Adds a value to the data set. If it is the largest or smallest
     * so far, the instance variables are updated accordingly.
     * 
     * @param the value to add to the set
     */
    public void addValue(int x)
    {
        if (x > largest)
            largest = x;
        if (x < smallest)
            smallest = x;
    }
    /**
     * Returns the largest value in the data set
     * 
     * @return the largest value in the data set
     */
    public int getLargest()
    {
        return largest;
    }
    /**
     * Returns the smallest value in the data set
     * 
     * @return the smallest value in the data set
     */
    public int getSmallest()
    {
        return smallest;
    }
    /**
     * Returns a String containing the largest and smallest values
     * in the data set.
     * 
     * @return a String
     */
    public String toString()
    {
        return "Largest: " + getLargest() +
               "\nSmallest: " + getSmallest();
    }
}
