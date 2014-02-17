package blackjack;

import java.util.ArrayList;

/**
 * @author 151bloomj
 * Assignment #5
 * A Hand has Cards, and a value that is equal to the sum of the Cards' values.
 * One may add Cards to the Hand, get the value, and get whether it meets
 * various Hand criteria (busted, blackjack, five card charlie).
 */
public class Hand
{
    private ArrayList<Card> cards;
    private byte value;

    /**
     * Constructs a Hand
     * @param down face down Card
     * @param up face up Card
     */
    public Hand(Card down, Card up)
    {
        cards = new ArrayList<Card>();
        value = 0;
        addCard(down);
        addCard(up);
    }

    /**
     * Adds a Card to the Hand
     * @param c Card to add
     */
    public final void addCard(Card c)
    {
        cards.add(c);
        value += c.getValue();
        if(busted() && hardenOneAce())
            value -= 10;
    }

    /**
     * Hardens exactly one Ace if possible
     * @return true if an Ace was hardened
     */
    private boolean hardenOneAce()
    {
        for(Card c : cards)
        {
            if(c.getRank() == Card.SOFT_ACE)
            {
                c.hardenAce();
                return true;
            }
        }
        return false;
    }
    /**
     * @return the STORED value of the Hand
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @return a deep copy of the Cards in the Hand. the first Card is the face down Card.
     */
    public ArrayList<Card> getCards()
    {
        ArrayList<Card> returnMe = new ArrayList<Card>();
        for(Card c : cards)
        {
            returnMe.add(new Card(c));
        }
        return returnMe;
    }

    /**
     * @param n the index of the Card to get
     * @return a clone of the nth Card in the Hand
     */
    public Card get(int n)
    {
        return new Card(cards.get(n));
    }

    /**
     * @return true if the Hand is busted
     */
    public boolean busted()
    {
        return getValue() > 21;
    }

    /**
     * @return true if the Hand is blackjack
     */
    public boolean blackjack()
    {
        return cards.size() == 2 && getValue() == 21;
    }

    /**
     * @return true if the Hand has 5 or more Cards and not busted
     */
    public boolean fiveCardCharlie()
    {
        return cards.size() >= 5 && !busted();
    }

    /**
     * Prints the Cards in the Hand, then the value of the Hand. The first Card
     * printed is the face down Card.
     */
    @Override
    public String toString()
    {
        String returnMe = "";
        for(Card c : cards)
        {
            returnMe += c + " ";
        }
//        returnMe += "\nValue: " + getValue();
        return returnMe;
    }
}
