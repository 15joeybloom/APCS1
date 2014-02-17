package blackjack;

import java.util.*;

/**
 * @author 151bloomj
 * Runs the blackjack game, text based.
 */
public class Game
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("What's your name? ");
        int money = 500;
        String name = in.nextLine();
//        in.nextLine();
//        System.out.println("Input read good");
        Player player = new Player(name,money);
//        System.out.println("Made player");
        Dealer dealer = new Dealer(player);
//        System.out.println("Made dealer");
        System.out.println("Hi, " + player.getName() + ". I am " + dealer.getName() + ".");
        System.out.println("I will be your dealer tonight. You have $" + player.getBalance() + ".");
        System.out.println();

        while(true)
        {
            System.out.println("NEW HAND");
            System.out.println("Balance: $" + player.getBalance());

            int bet = 0;
            bet:
            while(true)
            {
                System.out.print("Enter your bet: ");
                try
                {
                    bet = in.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("NaN");
                    continue bet;
                }
                finally
                {
                    in.nextLine();
                }

                if(bet > player.getBalance())
                {
                    System.out.println("Bet is greater than your balance.");
                    continue bet;
                }
                else if(bet < 2)
                {
                    System.out.println("Minimum bet is $2.");
                    continue bet;
                }
                else
                {
                    dealer.dealNewRound(bet);
                    break bet;
                }
            }

            System.out.println("Your Hand: " + player.getHand());
            System.out.println("Dealer's up Card: " + dealer.getHand().getCards().get(1));
            System.out.println();
            if(dealer.shouldOfferInsurance())
            {
                System.out.println(dealer.getName() + " has an ace showing. Would you like insurance?");
                System.out.println("Insurance is equal to half of your initial bet, rounded down, and pays 2:1.");
                System.out.println("In this case, your insurance is $" + dealer.getBet() / 2 + ".");
                System.out.print("Type \"y\" if you would like insurance: ");
                if(in.nextLine().equals("y"))
                {
                    dealer.giveInsurance();
                }
                System.out.println();
            }
            //begin play
            play:
            while(!player.getHand().blackjack() && !dealer.getHand().blackjack())
            {
                System.out.println("Hit, Stand, or Double Down?");
                System.out.println("Enter \"h\", \"s\", or \"d\"");
                switch(in.nextLine())
                {
                    case "s":
                        break;
                    case "d":
                        dealer.doubleDown();
                        System.out.println("Your bet is now $" + dealer.getBet());
                        if(!player.getHand().busted())
                        {
                            System.out.println("Your hand: " + player.getHand());
                            in.nextLine();
                        }
                        else
                        {
                            break play;
                        }
                        break;
                    case "h":
                        dealer.playerHit();
                        Hand playerHand = player.getHand();

                        if(playerHand.busted())
                        {
                            break play;
                        }
                        hitLoop:
                        while(true)
                        {
                            System.out.println();
                            System.out.println("Your hand: " + playerHand);
                            System.out.println("Hit or Stand?");
                            System.out.println("Enter \"h\" or \"s\"");
                            String x = in.nextLine();
                            if(x.equals("h"))
                            {

                                dealer.playerHit();
                                playerHand = player.getHand();
                                if(playerHand.busted() || playerHand.fiveCardCharlie())
                                {
                                    break play;
                                }
                            }
                            else if(x.equals("s"))
                            {
                                break hitLoop;
                            }
                            else
                            {
                                System.out.println("Try again, stoopid!");
                            }
                        }
                        break;
                    default:
                        System.out.println("Try again, stoopid!");
                        continue play;
                }
                System.out.println();
                //the dealer plays out his hand
                //this part is only executed after the player has stuck or doubled down
                System.out.print("Dealer's Hand: " + dealer.getHand());
                in.nextLine();
                while(dealer.getHand().getValue() < 17)
                {
                    dealer.dealerHit();
                    System.out.println("Dealer hit. ");
                    System.out.print("Dealer's Hand: " + dealer.getHand());
                    in.nextLine();
                }
                if(!dealer.getHand().busted())
                {
                    System.out.print("Dealer stood. ");
                    in.nextLine();
                }
                System.out.println();
                break play;
            }
            //results
            System.out.println(dealer.results());
            System.out.println("Balance: $" + player.getBalance());
            System.out.println();

            System.out.print("Continue? Enter \"y\" to continue: ");
            if(!in.nextLine().equalsIgnoreCase("y"))
            {
                break;
            }
            else
            {
                System.out.println();
            }
        }
        System.out.println(dealer.getName() + " says goodbye!");
        System.out.println("Thanks for playing!");
    }
}
