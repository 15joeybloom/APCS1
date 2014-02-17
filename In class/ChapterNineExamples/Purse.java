import java.util.ArrayList;
/**
 * @author Joey Bloom
 * InclassExample for ch8
 * a blueprint for a Coin object
 */
public class Purse implements Measureable
{
    private ArrayList<Coin> coins;
    
    public Purse()
    {
        coins = new ArrayList<Coin>();
    }
    public void add(Coin c)
    {
        coins.add(c);
    }
    public String toString()
    {
        return coins + "\nTotal Contents: $" + getSum();
    }
    public double getSum()
    {
        double sum = 0;
        for(Coin fart : coins)
        {
            sum += fart.getValue();
        }
        return sum;
    }
    public double getMeasure()
    {
        return getSum();
    }
}
