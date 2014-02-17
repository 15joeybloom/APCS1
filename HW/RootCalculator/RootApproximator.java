/**
 * @author Joey Bloom
 * Extra Credit Assignment 6.10
 * Uses the Heron Method to determine if 
 * the number has a next guess and then 
 * determines the next guess
 */
public class RootApproximator
{
    private double square;
    private double bestGuess;
    private final double EPSILON;
    
    /**
     * RootApproximator Constructor
     *
     * @param x the square to be rooted
     * @param E when the next guess is less than this distance away from
     *  the last one, hasNextGuess() returns false.
     */
    public RootApproximator(double x, double E)
    {
        square = x;
        bestGuess = 1;
        EPSILON = E;
    }
    /**
     * Returns the next guess for the root
     * @return the next guess for the root
     */
    public double nextGuess()
    {
        bestGuess = (bestGuess + square / bestGuess) / 2.0;
        return bestGuess;
    }
    /**
     * Returns true if the value of nextGuess() will 
     * be less than EPSILON away from the last nextGuess()
     */
    public boolean hasMoreGuesses()
    {
        if(Math.abs(((bestGuess + square / bestGuess ) / 2.0) - bestGuess)
            < EPSILON)
            return false;
        else
            return true;
    }
}
