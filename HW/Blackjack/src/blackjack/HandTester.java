package blackjack;

/**
 * @author 151bloomj
 * Assignment #5
 * Tests Hand
 */
public class HandTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Hand bj = new Hand(new Card(10,3),new Card(0,2));
        System.out.println(getHandInfo(bj));
        bj.addCard(new Card(Card.QUEEN,Card.SPADES));
        System.out.println("For whatever reason, you hit with blackjack... ");
        System.out.println(getHandInfo(bj));
        System.out.println();        
        
        Hand five = new Hand(new Card(0,Card.SPADES), new Card(0,Card.HEARTS));
        System.out.println(getHandInfo(five));
        System.out.println("Add some Cards: ");
        
        five.addCard(new Card(2,Card.DIAMONDS));
        five.addCard(new Card(4,Card.SPADES));
        five.addCard(new Card(7,Card.CLUBS));
        System.out.println(getHandInfo(five));
        System.out.println();
        
        Hand notBJ = new Hand(new Card(10,Card.HEARTS),new Card(Card.KING,Card.CLUBS));
        notBJ.addCard(new Card(Card.HARD_ACE,Card.DIAMONDS));
        System.out.println(getHandInfo(notBJ));
        System.out.println();
        
        Hand bust = new Hand(new Card(10,Card.SPADES),new Card(10,Card.CLUBS));
        System.out.println(getHandInfo(bust));
        bust.addCard(new Card(2,Card.DIAMONDS));
        System.out.println(getHandInfo(bust));
        
    }
    /**
     * Returns the toString() for a Hand, 
     * followed by blackjack, busted, and fiveCardCharlie.
     */
    private static String getHandInfo(Hand h)
    {
        String returnMe = "";
        returnMe += h;
        returnMe += "\nBlackjack: " + h.blackjack();
        returnMe += "\nBusted: " + h.busted();
        returnMe += "\nFive Card Charlie: " + h.fiveCardCharlie();
        return returnMe;
    }
}

/*
Output:
10♦ A♥ 
Value: 21
Blackjack: true
Busted: false
Five Card Charlie: false
For whatever reason, you hit with blackjack... 
10♦ A♥ Q♠ 
Value: 21
Blackjack: false
Busted: false
Five Card Charlie: false

A♠ A♥ 
Value: 12
Blackjack: false
Busted: false
Five Card Charlie: false
Add some Cards: 
A♠ A♥ 2♦ 4♠ 7♣ 
Value: 15
Blackjack: false
Busted: false
Five Card Charlie: true

10♥ K♣ A♦ 
Value: 21
Blackjack: false
Busted: false
Five Card Charlie: false

10♠ 10♣ 
Value: 20
Blackjack: false
Busted: false
Five Card Charlie: false
10♠ 10♣ 2♦ 
Value: 22
Blackjack: false
Busted: true
Five Card Charlie: false
 */