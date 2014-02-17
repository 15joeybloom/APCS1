package blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author 151bloomj
 * Assignment #2
 * A Card has suit and rank. In blackjack, a Card has a value as well.
 */
public class Card
{
    private byte dat;

    private static final byte SUIT = 3;
    private static final byte RANK = 60;
    private static final String[] SUIT_SYMBOLS =
        { "\u2660", //spade
          "\u2663", //club
          "\u2665", //heart
          "\u2666"  //diamond
        };
    private static final String[] RANK_STRINGS =
        { "A", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private static final int[] VALUES =
        { 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

    public static final int SPADES = 0;
    public static final int CLUBS = 1;
    public static final int HEARTS = 2;
    public static final int DIAMONDS = 3;

    public static final int SOFT_ACE = 0;
    public static final int HARD_ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int CARD_W = 79;
    public static final int CARD_H = 123;
    private static BufferedImage PACK;
    static
    {
        try
        {
            PACK = ImageIO.read(Card.class.getResource("cards.png"));
        }
        catch(IOException e)
        {
            PACK = null;
        }
    }
    public static ImageIcon CARD_BACK = new ImageIcon(PACK.getSubimage(3 * CARD_W, 4 * CARD_H, CARD_W, CARD_H));

    /**
     * Constructs a Card.
     * @param r rank precondition: 0 <= r <= 13
     * @param s suit precondition: 0 <= s <= 4
     */
    public Card(int r, int s)
    {
        dat |= r;
        dat <<= 2;
        dat |= s;
    }
    /**
     * Constructs a Card with same rank and suit as another Card
     * @param c other Card
     */
    public Card(Card c)
    {
        this(c.getRank(),c.getSuit());
    }

    /**
     * returns the suit as an integer
     * 0 = spades
     * 1 = clubs
     * 2 = hearts
     * 3 = diamonds
     * @return suit
     */
    public int getSuit()
    {
        return dat & SUIT;
    }

    /**
     * returns the suit as a symbol
     * @return suit symbol
     */
    public String getSuitSymbol()
    {
        return SUIT_SYMBOLS[getSuit()];
    }

    /**
     * returns the rank as an int
     * 0 = soft A
     * 1 = hard A
     * 2-10 = 2-10
     * 11 = J
     * 12 = Q
     * 13 = K
     * @return rank int
     */
    public int getRank()
    {
        return (dat & RANK) >> 2;
    }

    /**
     * returns the rank as a String
     * 0 = A
     * 1 = A
     * 2-10 = 2-10
     * 11 = J
     * 12 = Q
     * 13 = K
     * @return rank int
     */
    public String getRankString()
    {
        return RANK_STRINGS[getRank()];
    }

    /**
     * @return the point value of the card in Blackjack
     */
    public int getValue()
    {
        return VALUES[getRank()];
    }

    /**
     * @return the Card represented by a String, like A\u2660 for Ace of Spades
     */
    @Override
    public String toString()
    {
        return getRankString() + getSuitSymbol();
    }

    /**
     * If this card is an Ace, it sets the value to 1.
     */
    public void hardenAce()
    {
        if(getRank() == SOFT_ACE) dat |= 4;
    }

    /**
     * Returns a BufferedImage of this Card
     * @return BufferedImage
     */
    public BufferedImage getBufferedImage()
    {
        return PACK.getSubimage(getRank() * CARD_W, getSuit() * CARD_H, CARD_W, CARD_H);
    }


    /**
     * Returns an ImageIcon of this Card
     * @return ImageIcon
     */
    public ImageIcon getImageIcon()
    {
        return new ImageIcon(getBufferedImage());
    }
}
