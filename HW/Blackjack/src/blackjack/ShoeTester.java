package blackjack;

/**
 * @author 151bloomj
 * Assignment #3
 * Tests Shoe
 */
public class ShoeTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Shoe shoe = new Shoe(3);
        System.out.println(shoe);
        System.out.println(shoe.size());
        shoe.shuffle();
        System.out.println(shoe);
        System.out.println(shoe.size());
        System.out.println(shoe.get(0));
        System.out.println(shoe.get(1));
        System.out.println("Take off top: " + shoe.pop());
        System.out.println("Shoe is now: ");
        System.out.println(shoe);
        System.out.println(shoe.size());
    }
}

/*
Output:
A♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ A♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ A♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ A♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ A♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ A♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦
156
4♥ K♦ 9♣ 7♠ K♥ Q♦ 4♠ 6♣ 10♣ 7♥ 4♠ J♦ 3♥ 8♦ A♦ 10♠ K♠ 3♥ 8♠ J♦ 9♥ J♣ 8♠ 2♥ J♥ K♣ J♠ 9♣ 6♣ 4♦ 3♠ 6♣ 5♣ 8♥ 3♦ 10♣ 5♠ 8♣ Q♠ J♠ 7♦ 8♦ A♦ 5♥ 2♦ 6♠ 4♣ 3♣ 10♥ K♣ 8♠ 9♥ 2♦ 8♣ A♥ 2♠ 9♥ 7♥ K♦ 7♣ 5♥ A♥ 2♠ 9♦ 4♦ Q♣ 2♠ Q♦ J♣ 2♣ 2♥ 5♠ 7♦ K♠ 9♦ J♣ J♠ 10♠ 4♥ 6♥ Q♣ 7♣ 9♠ 10♦ 3♦ 10♦ 4♥ 5♣ 5♦ 7♠ A♣ K♦ 9♠ 7♣ 9♠ A♣ 6♥ 3♣ A♦ 3♣ 3♠ A♥ 2♦ 5♣ 8♦ 8♣ 10♥ A♠ 7♥ 5♦ 3♥ Q♣ Q♥ Q♥ 5♠ 7♠ K♥ 3♠ Q♠ Q♠ A♠ 4♠ 5♥ 2♣ 8♥ A♠ 6♥ Q♦ 4♣ J♥ J♦ 9♦ 3♦ K♠ 2♥ 10♦ 7♦ 5♦ Q♥ 4♣ 6♦ 6♠ K♥ 10♠ J♥ 4♦ 9♣ K♣ 10♥ 8♥ 10♣ A♣ 6♦ 6♦ 2♣ 6♠
156
4♥
K♦
Take off top: 6♠
Deck is now:
4♥ K♦ 9♣ 7♠ K♥ Q♦ 4♠ 6♣ 10♣ 7♥ 4♠ J♦ 3♥ 8♦ A♦ 10♠ K♠ 3♥ 8♠ J♦ 9♥ J♣ 8♠ 2♥ J♥ K♣ J♠ 9♣ 6♣ 4♦ 3♠ 6♣ 5♣ 8♥ 3♦ 10♣ 5♠ 8♣ Q♠ J♠ 7♦ 8♦ A♦ 5♥ 2♦ 6♠ 4♣ 3♣ 10♥ K♣ 8♠ 9♥ 2♦ 8♣ A♥ 2♠ 9♥ 7♥ K♦ 7♣ 5♥ A♥ 2♠ 9♦ 4♦ Q♣ 2♠ Q♦ J♣ 2♣ 2♥ 5♠ 7♦ K♠ 9♦ J♣ J♠ 10♠ 4♥ 6♥ Q♣ 7♣ 9♠ 10♦ 3♦ 10♦ 4♥ 5♣ 5♦ 7♠ A♣ K♦ 9♠ 7♣ 9♠ A♣ 6♥ 3♣ A♦ 3♣ 3♠ A♥ 2♦ 5♣ 8♦ 8♣ 10♥ A♠ 7♥ 5♦ 3♥ Q♣ Q♥ Q♥ 5♠ 7♠ K♥ 3♠ Q♠ Q♠ A♠ 4♠ 5♥ 2♣ 8♥ A♠ 6♥ Q♦ 4♣ J♥ J♦ 9♦ 3♦ K♠ 2♥ 10♦ 7♦ 5♦ Q♥ 4♣ 6♦ 6♠ K♥ 10♠ J♥ 4♦ 9♣ K♣ 10♥ 8♥ 10♣ A♣ 6♦ 6♦ 2♣
155
 */
