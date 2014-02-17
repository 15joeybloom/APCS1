/**
 * @author Joey Bloom
 * InclassExample for ch8
 * a blueprint for a Coin object
 */
public class Coin implements Measureable, Comparable<Coin>
{
    private final double value;
    private final String name;
    
    public Coin()
    {
        this("",0);
    }
    public Coin(String n, double v)
    {
        value = v;
        name = n;
    }
    public Coin(Coin c)
    {
        this(c.getName(),c.getValue());
    }
    public String getName()
    {
        return name;
    }
    public double getValue()
    {
        return value;
    }
    public double getMeasure()
    {
        return getValue();
    }
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
    public String toString()
    {
        return name + " is worth $" + value;
    }
}
