package blackjack;

/**
 * @author 151bloomj
 * Assignment #3
 * Tests Deck
 */
public class DeckTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Deck d = new Deck();
        System.out.println(getDeckInfo(d));
        System.out.println();
        d.shuffle();
        System.out.println("Shuffled: ");
        System.out.println(getDeckInfo(d));
        System.out.println();
        System.out.println("Popped Card: " + d.pop());
        System.out.println(getDeckInfo(d));
    }
    private static String getDeckInfo(Deck d)
    {
        String returnMe = "";
        returnMe += d;
        returnMe += "\nFirst: " + d.get(0);
        returnMe += "\nThird: " + d.get(2);
        returnMe += "\nLast: " + d.get(d.size() - 1);
        returnMe += "\nSize: " + d.size();
        return returnMe;
    }
}

/*
Output:
A♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ A♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦
First: A♠
Third: 3♠
Last: K♦
Size: 52

Shuffled:
K♣ 3♦ 4♣ J♠ 3♥ 8♣ 7♠ 5♥ 8♥ 4♦ 4♥ 6♦ 5♠ 10♦ K♥ 2♣ A♥ 8♠ 5♦ A♠ 10♠ 4♠ A♦ 2♥ 9♠ 9♣ 5♣ Q♦ 7♦ J♣ 6♥ J♥ Q♣ K♦ 3♣ 7♣ J♦ 2♦ Q♠ K♠ 3♠ 8♦ Q♥ 7♥ 6♣ 2♠ 10♣ 9♥ 9♦ 6♠ 10♥ A♣
First: K♣
Third: 4♣
Last: A♣
Size: 52

Popped Card: A♣
K♣ 3♦ 4♣ J♠ 3♥ 8♣ 7♠ 5♥ 8♥ 4♦ 4♥ 6♦ 5♠ 10♦ K♥ 2♣ A♥ 8♠ 5♦ A♠ 10♠ 4♠ A♦ 2♥ 9♠ 9♣ 5♣ Q♦ 7♦ J♣ 6♥ J♥ Q♣ K♦ 3♣ 7♣ J♦ 2♦ Q♠ K♠ 3♠ 8♦ Q♥ 7♥ 6♣ 2♠ 10♣ 9♥ 9♦ 6♠ 10♥
First: K♣
Third: 4♣
Last: 10♥
Size: 51
 */
