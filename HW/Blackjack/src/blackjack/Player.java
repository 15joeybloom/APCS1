package blackjack;

/**
 * @author Joey Bloom
 *
 */
public class Player
{
    private String name;
    private int money;
    private Hand hand;
    private boolean insured;

    /**
     * Constructs a Player
     * @param n name
     * @param m money
     */
    public Player(String n, int m)
    {
        name = n;
        money = m;
    }

    /**
     * @return Player's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return number of dollars the Player has
     */
    public int getBalance()
    {
        return money;
    }

    /**
     * Sets the name of the Player
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return true if the Player is insured
     */
    public boolean insured()
    {
        return insured;
    }

    /**
     * Sets the player's insured value
     * @param b insured value
     */
    public void setInsured(boolean b)
    {
        insured = b;
    }

    /**
     * Pays the Player
     * @param amt the amount to pay
     */
    public void pay(int amt)
    {
        assert amt >= 0;
        money += amt;
    }

    /**
     * Subtracts from the Player's money
     * @param amt amount to bet
     */
    public void bet(int amt)
    {
        assert 0 <= amt && amt <= money;
        money -= amt;
        assert money >= 0;
    }

    /**
     * @return Player's Hand
     */
    public Hand getHand()
    {
        return hand;
    }

    /**
     * Sets the player's Hand
     * @param h player's new Hand
     */
    public void setHand(Hand h)
    {
        hand = h;
    }
}
