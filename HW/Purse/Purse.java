/**
 * @author Joey Boom
 * Assignment #29
 * A Purse holds coins, and you can add coins
 * to it and reverse it and transfer another Purse's
 * contents to it and check if it has the same contents
 * as another Purse or the same coins as another Purse
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Purse
{
    private ArrayList<String> coins;
    /**
     * Constructs a new Purse with the given coins
     * @param coins the coins already in the purse
     */
    public Purse(ArrayList<String> coins)
    {
        this.coins = new ArrayList<>(coins);
    }
    /**
     * Constructs an empty Purse
     */
    public Purse()
    {
        coins = new ArrayList<>();
    }
    /**
     * Adds a coin to the Purse
     * @param coinName the coin to add
     */
    public void addCoin(String coinName)
    {
        coins.add(coinName);
    }
    /**
     * Returns an ArrayList containing the contents of the Purse
     * @return the contents of the Purse
     */
    public ArrayList<String> getContents()
    {
        return coins;
    }
    /**
     * Reverses the order of the contents
     * of the Purse.
     */
    public void reverse()
    {
        ArrayList<String> queue = new ArrayList<>();
        while(coins.size() > 0)
            queue.add(coins.remove(coins.size() - 1));
        coins = queue;
    }
    /**
     * Transfers the contents of a to b
     * @param a Purse to be emptied
     */
    public void transfer(Purse a)
    {
        a.reverse();
        ArrayList<String> aContents = a.getContents();
        while(aContents.size() > 0)
        {
            addCoin(aContents.remove(aContents.size() - 1));
        }
    }
    /**
     * a String containing the contents of the purse
     * @return a String contatining the contents of the purse
     */
    public String toString()
    {
        return "Purse" + coins;
    }
    /**
     * Tests if a has the same coins in the same order
     * @param a other Purse to be tested
     * @return true if same contents same order
     */
    public boolean sameContents(Purse a)
    {
        ArrayList<String> aContents = new ArrayList<>(a.getContents());
        if(getContents().size() != aContents.size())
        {
            return false;
        }
        for(int i = 0; i <= aContents.size(); i++)
        {
            if(i == aContents.size())
            {
                return true;
            }
            if(!getContents().get(i).equals(aContents.get(i)))
            {
                break;
            }
        }
        return false;
    }
}