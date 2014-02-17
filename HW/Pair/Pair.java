/**
 * @author Joey Bloom
 * Assignment #16
 * Represents a pair of numbers,
 * with methods for finding various
 * calculations on said pair.
 */
public class Pair
{
    private double first;
    private double second;
    
    /**
     * Constructs a pair
     * @param one the first number
     * @param two the second number 
     */
    public Pair(double one, double two)
    {
        first = one;
        second = two;
    }
    
    /**
     * Returns the first value of the Pair
     * @return the first value of the Pair
     */
    public double getFirst()
    {
        return first;
    }
    
    /**
     * Returns the second value of the Pair
     * @return the second value of the Pair
     */
    public double getSecond()
    {
        return second;
    }
    
    /**
     * Computes the sum of the values of this pair
     * @return the sum of the first and second values
     */
    public double getSum()
    {
        return first + second;
    }
    
    /**
     * Computes the difference of the values of this pair
     * @return the difference of the first and second values
     */
    public double getDifference()
    {
        return first - second;
    }
    
    /**
     * Computes the product of the values of this pair
     * @return the product of the first and second values
     */
    public double getProduct()
    {
        return first * second;
    }
    
    /**
     * Computes the average of the values of this pair
     * @return the average of the first and second values
     */
    public double getAverage()
    {
        return getSum() / 2.0;
    }
    
    /**
     * Computes the distance between the values of this pair
     * @return the distance between the first and second values
     */
    public double getDistance()
    {
        return Math.abs(getDifference());
    }
    
    /**
     * Computes the maximum of the values of this pair
     * @return the maximum of the first and second values
     */
    public double getMaximum()
    {
        return Math.max(first, second);
    }
    
    /**
     * Computes the minimum of the values of this pair
     * @return the maximum of the first and second values
     */
    public double getMinimum()
    {
        return Math.min(first, second);
    }
    
    /**
     * Returns a String representation of the Pair,
     * including the two values of the pair and all
     * of the various computations in the Pair class.
     * @return a String representation of the Pair
     */
    public String toString()
    {
        return "First: " + getFirst() +
               "\nSecond: " + getSecond() + 
               "\nSum: " + getSum() +
               "\nDifference: " + getDifference() + 
               "\nProduct: " + getProduct() + 
               "\nAverage: " + getAverage() + 
               "\nDistance: " + getDistance() +
               "\nMaximum: " + getMaximum() + 
               "\nMinimum: " + getMinimum();
    }   
}