
/**
 * @author Joey Bloom
 * Assignment #20
 * Takes in a "card" value of the format RS where R is the rank
 * of the card and S is the suit of the card. Ranks can be 2-10, A,
 * J, Q, K, and suits can be D, H, S, C.
 */
public class Card
{
    private String card;
    
    /**
     * Constructs a new Card with a rank and suit designated by
     * the formatted String.
     * 
     * @param cardValue the desired value of the card
     */
    public Card( String cardValue )
    {
        card = cardValue;
    }
    /**
     * Gets the card's numeric rank and suit using the
     * instance variable card.
     * 
     * @return the card's rank and suit
     */
    public String getDescription()
    {
        String description = "";
        String suit, rank, thisMightBeTen;
        try
        {
            suit = card.substring(
                card.length() - 1);
            rank = card.substring(0,1);
            thisMightBeTen = card.substring(0,2);
        }
        catch ( StringIndexOutOfBoundsException e )
        {
            return "unknown";
        }
        
        if(card.length() == 2)
        {
            if(rank.equals("2"))
            {
                description += "Two";
            }
            else if(rank.equals("3"))
            {
                description += "Three";
            }
            else if(rank.equals("4"))
            {
                description += "Four";
            }
            else if(rank.equals("5"))
            {
                description += "Five";
            }
            else if(rank.equals("6"))
            {
                description += "Six";
            }
            else if(rank.equals("7"))
            {
                description += "Seven";
            }
            else if(rank.equals("8"))
            {
                description += "Eight";
            }
            else if(rank.equals("9"))
            {
                description += "Nine";
            }
            else if(rank.equalsIgnoreCase("J"))
            {
                description += "Jack";
            }
            else if(rank.equalsIgnoreCase("Q"))
            {
                description += "Queen";
            }
            else if(rank.equalsIgnoreCase("K"))
            {
                description += "King";
            }
            else if(rank.equalsIgnoreCase("A"))
            {
                description += "Ace";
            }
            else
            {
                return "unknown";
            }
        }
        else if(card.length() == 3 && 
                thisMightBeTen.equals("10"))
        {
            description += "Ten";
        }
        else
        {
            return "unknown";
        }   
        
        description += " of ";
        
        if(suit.equalsIgnoreCase("D"))
        {
            description += "Diamonds";
        }
        else if(suit.equalsIgnoreCase("H"))
        {
            description += "Hearts";
        }
        else if(suit.equalsIgnoreCase("S"))
        {
            description += "Spades";
        }
        else if(suit.equalsIgnoreCase("C"))
        {
            description += "Clubs";
        }
        else
        {
            return "unknown";
        }
        
        return description;
    }
}