package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 151bloomj
 * Assignment #3
 * A Deck has Cards, starting with one of each of the 52 cards unique
 * in rank and suit. One may get a Card from any position in the Deck,
 * remove the top Card from a Deck, get the size of the Deck, shuffle the
 * Deck, and get whether the Deck is empty.
 */
public class Deck
{
    private ArrayList<Card> cards = new ArrayList<Card>();

    public static final int CARDS_IN_A_DECK = 52;

    /**
     * Constructs a full Deck. Just like when you get a physical Deck of Cards,
     * it does not come pre-shuffled. You do it.
     */
    public Deck()
    {
        for(int s = 0; s < 4; s++)
        {
            cards.add(new Card(0,s));
            for(int r = 2; r <= 13; r++)
            {
                cards.add(new Card(r,s));
            }
        }
    }

    /**
     * Shuffles the Deck
     */
    public void shuffle()
    {
        Random rand = new Random();
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while(!cards.isEmpty())
        {
            shuffledDeck.add(cards.remove(rand.nextInt(cards.size())));
        }
        cards = shuffledDeck;
    }

    /**
     * Returns a String showing all the cards in the Deck, in order starting
     * at the bottom of the Deck. The last Card is the top Card.
     * @return a String of the Deck
     */
    @Override
    public String toString()
    {
        String returnMe = "";
        for(Card c : cards)
        {
            returnMe += c + " ";
        }
        return returnMe;
    }

    /**
     * Takes a Card off the top of the Deck. The Card is removed from the Deck.
     * @return Card at the top of the Deck, or null if <code> isEmpty() == true </code>.
     */
    public Card pop()
    {
        if(!isEmpty())
        {
            return cards.remove(cards.size()-1);
        }
        else
        {
            return null;
        }
    }

    /**
     * Get a Card from the Deck. The Card is not removed from the Deck.
     * @param n position in deck to get Card from. 0 is the bottom, this.size() - 1 is the top.
     * @return Card at position n
     */
    public Card get(int n)
    {
        return cards.get(n);
    }

    /**
     * returns the number of cards in the Deck
     * @return size
     */
    public int size()
    {
        return cards.size();
    }

    /**
     * @return true if the Deck is empty
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
}
