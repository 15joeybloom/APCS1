package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Joey Bloom
 *
 */
public class Dealer
{
    private String name;
    private Player player;
    private Hand hand;
    private Shoe shoe;
    private int bet;

    private static String[] names;
    static
    {
        try(BufferedReader namesIn = new BufferedReader(new InputStreamReader(Dealer.class.getResourceAsStream("dealerNames.txt"))))
        {
            String big = "";
            String temp = namesIn.readLine();
            while(temp != null)
            {
                big += temp + "\n";
                temp = namesIn.readLine();
            }
            if(big.length() > 0)
            {
                names = big.split("\n");
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e)
        {
            names = new String[]{"Joe"};
        }

    }

    //to-do: random silly dealer names
    /**
     * Constructs a Dealer
     * @param p Player
     */
    public Dealer(Player p)
    {
        player = p;
        name = "Dealer " + names[new Random().nextInt(names.length)];
        shoe = new Shoe(6);
        shoe.shuffle();
        bet = 0;
    }

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return hand
     */
    public Hand getHand()
    {
        return hand;
    }

    /**
     * @return bet
     */
    public int getBet()
    {
        return bet;
    }

    /**
     * Deals a new round.
     * Deals new Hands to Player and Dealer.
     * Sets the player's bet.
     * Sets player to uninsured.
     * @param b bet
     */
    public void dealNewRound(int b)
    {
        replaceShoe();
        Card c1 = shoe.pop();
        Card c2 = shoe.pop();
        player.setHand(new Hand(c1,shoe.pop()));
        hand = new Hand(c2,shoe.pop());
        bet = b;
        player.bet(b);
        player.setInsured(false);
    }
    /**
     * @return true if Dealer should offer insurance to the player
     */
    public boolean shouldOfferInsurance()
    {
        if(player.getBalance() < bet / 2)
        {
            return false;
        }
        int maybeAce = hand.getCards().get(1).getRank();
        return maybeAce == Card.HARD_ACE || maybeAce == Card.SOFT_ACE;
    }

    /**
     * Gives the player insurance.
     * Subtracts bet / 2 (rounded down) from player's money
     * and set's player's insured value to true
     */
    public void giveInsurance()
    {
        int amt = bet / 2;
        player.bet(amt);
        player.setInsured(true);
    }
    /**
     * Doubles down the player
     */
    public void doubleDown()
    {
        player.bet(bet);
        bet *= 2;
        playerHit();
    }
    /**
     * Hits the Dealer
     */
    public void dealerHit()
    {
        hand.addCard(shoe.pop());
    }

    /**
     * Hits the Player
     */
    public void playerHit()
    {
        player.getHand().addCard(shoe.pop());
    }

    /**
     * replace the Shoe if necessary
     * necessary is defined as the Shoe is two-thirds empty
     */
    private void replaceShoe()
    {
        if(shoe.size() < Deck.CARDS_IN_A_DECK * 2)
        {
            shoe = new Shoe(6);
            shoe.shuffle();
        }
    }
    /**
     * Returns the result of the round based on the current state of the Dealer's
     * and his Player's hands. Also pays Player appropriate amounts as necessary.
     * @return results
     */
    public String results()
    {
        String returnMe = "";
        Hand playerHand = player.getHand();
        if(hand.blackjack())
        {
            returnMe += "Dealer's Blackjack: " + hand + "\n";
            if(player.insured())
            {
                int insurancePay = getBet() / 2 * 3;
                returnMe += "Insurance pays 2:1\n";
                returnMe += "Dealer pays you $" + insurancePay;
                player.pay(insurancePay);
            }
        }
        else if(hand.busted())
        {
            returnMe += "Dealer Busted!: " + hand + "\n";
            returnMe += "Dealer pays you $" + getBet() * 2 + ".\n";
            player.pay(getBet() * 2);
        }
        else
        {
            returnMe += "Your Hand: " + playerHand + "\n";
            if(playerHand.busted())
                returnMe += "Busted!" + "\n";
            else if(playerHand.blackjack())
            {
                returnMe += "Blackjack!" + "\n";
                int amt = getBet() * 5 / 2;
                returnMe += "Dealer pays you $" + amt + ".\n";
                player.pay(amt);
            }
            else if(playerHand.fiveCardCharlie())
            {
                returnMe += "Five Card Charlie!" + "\n";
                returnMe += "Dealer pays you $" + getBet() * 2 + ".\n";
                player.pay(getBet() * 2);
            }
            else
            {
                final int PV = playerHand.getValue();
                final int DV = getHand().getValue();
                returnMe += "\tValue: " + PV + "\n";
                returnMe += "Dealer's Hand: " + getHand() + "\n";
                returnMe += "\tValue: " + DV + "\n";
                if(PV == DV)
                {
                    returnMe += "Push." + "\n";
                    returnMe += "Dealer pays you back your bet of $" + getBet() + ".\n";
                    player.pay(getBet());
                }
                else if(PV < DV)
                {
                    returnMe += "Dealer wins. \n";
                    returnMe += "You get nothing." + "\n";
                }
                else if(PV > DV)
                {
                    returnMe += "You win!\n";
                    returnMe += "Dealer pays you $" + getBet() * 2 + ".\n";
                    player.pay(getBet() * 2);
                }
            }
        }
        return returnMe;
    }

    /**
     * Replaces the Player
     * @param p new Player
     */
    public void setPlayer(Player p)
    {
        player = p;
    }
}
