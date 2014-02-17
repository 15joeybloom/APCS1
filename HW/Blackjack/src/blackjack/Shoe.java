package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 151bloomj
 * Assignment #4
 * A Shoe has multiple decks of Cards. One can shuffle, get the size of,
 * and get a Card from a Shoe. One may also remove a Card from the top of
 * the Shoe and get whether or not the Shoe is empty.
 */
public class Shoe
{
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Constructs an empty Shoe
     */
    public Shoe(){}

    /**
     * Constructs a Shoe
     * @param n number of decks
     */
    public Shoe(int n)
    {
        this();
        addDecks(n);
    }

    /**
     * Constructs a Shoe with Deck(s)
     * @param d Decks to add
     */
    public Shoe(Deck... d)
    {
        for(Deck deck : d)
        {
            while(!deck.isEmpty())
            {
                cards.add(deck.pop());
            }
        }
    }

    /**
     * Adds a deck to the Shoe
     */
    private void addDecks(int n)
    {
        for(int i = 0; i < n; i++)
        {
            Deck d = new Deck();
            while(!d.isEmpty())
            {
                cards.add(d.pop());
            }
        }
    }

    /**
     * Shuffles the Shoe
     */
    public void shuffle()
    {
        Random rand = new Random();
        ArrayList<Card> shuffledShoe = new ArrayList<Card>();
        while(!cards.isEmpty())
        {
            shuffledShoe.add(cards.remove(rand.nextInt(cards.size())));
        }
        cards = shuffledShoe;
    }

    /**
     * Returns a String showing all the cards in the Shoe, in order starting
     * at the bottom of the Shoe. The last Card is the top Card.
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
     * Takes a Card off the top of the Shoe. The Card is removed from the Shoe
     * @return Card at the top of the Shoe
     */
    public Card pop()
    {
        return cards.remove(cards.size()-1);
    }

    /**
     * Get a Card from the Shoe. The Card is not removed from the Shoe.
     * @param n position in deck to get Card from. 0 is the bottom, this.size() - 1 is the top.
     * @return Card at position n
     */
    public Card get(int n)
    {
        return cards.get(n);
    }

    /**
     * returns the number of cards in the Shoe
     * @return size
     */
    public int size()
    {
        return cards.size();
    }

    /**
     * @return true if the Shoe is empty
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }
}