/**
 * @author Joey Bloom
 * Assignment #36
 * a blueprint for a Coin object
 */
public class Coin implements Comparable<Coin>
{
    private final double value;
    private final String name;
    
    /**
     * Constructs an empty Coin
     */
    public Coin()
    {
        this("",0);
    }
    /**
     * Constructs a coin with name and value
     * @param n name
     * @param v value
     */    
    public Coin(String n, double v)
    {
        value = v;
        name = n;
    }
    /**
     * Constructs a Coin identical to another coin
     * @param c another Coin
     */
    public Coin(Coin c)
    {
        this(c.getName(),c.getValue());
    }
    /**
     * returns name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * returns value
     * @return value
     */
    public double getValue()
    {
        return value;
    }
    /**
     * returns -1,0, or 1 if this Coin's value is less than, equal to, or greater than other
     * @param other Coin to be compared to
     * @return -1, 0, or 1
     */
    public int compareTo(Coin other)
    {
        if(getValue() < other.getValue())
        {
            return -1;
        }
        else if(getValue() > other.getValue())
        {
            return 1;
        }
        else
        {
            return 0;
        }       
    }
    /**
     * Returns a String representation of this Coin
     * @return String
     */
    public String toString()
    {
        return name + " is worth $" + value;
    }
}
