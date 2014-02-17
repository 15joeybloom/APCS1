package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Joey Bloom
 *
 */
public class GUI extends JFrame
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                new GUI();
            }
        });
    }

    private JMenuBar menuBar;
        private JMenu fileMenu;
            private JMenuItem newPlayer;
            private JMenuItem load;
            private JMenuItem save;
            private JMenuItem saveAndClose;
            private JMenuItem close;
        private JMenu editMenu;
            private JMenuItem changeName;
            private JMenuItem getNewDealer;

    private JPanel leftSidePanel;
        private JScrollPane messageScroll;
            private JTextArea messageArea;

    private JPanel centerPanel;
        private GamePanel gamePanel;
            private JLabel betLabel;
            private JLabel balanceLabel;
            private JLabel[] dealerCards;
            private JLabel[] playerCards;
        private JPanel buttonPanel;
            private JButton newRound;
            private JButton hit;
            private JButton stand;
            private JButton doubleDown;

    private Dealer dealer;
    private Player player;

    public static ImageIcon CHIPS;
    public static ImageIcon MORE_CHIPS;
    static
    {
        try
        {
            CHIPS = new ImageIcon(ImageIO.read(GUI.class.getResource("chips.png")));
            MORE_CHIPS = new ImageIcon(ImageIO.read(GUI.class.getResource("moreChips.png")));
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Constructs a GUI
     */
    public GUI()
    {
        setTitle("The Most Amazing Blackjack Game You'll Ever Play");
        setSize(1126,476);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new RedXListener());

        menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
                newPlayer = new JMenuItem("New Player...");
                    newPlayer.addActionListener(new NewPlayerListener());
                load = new JMenuItem("Load...");
                    load.addActionListener(new LoadListener());
                save = new JMenuItem("Save...");
                    save.addActionListener(new SaveListener());
                saveAndClose = new JMenuItem("Save and Close...");
                    saveAndClose.addActionListener(new SaveAndCloseListener());
                close = new JMenuItem("Close");
                    close.addActionListener(new CloseListener());

                fileMenu.add(newPlayer);
                fileMenu.add(load);
                fileMenu.add(save);
                fileMenu.add(saveAndClose);
                fileMenu.add(close);
            editMenu = new JMenu("Edit");
                changeName = new JMenuItem("Change Player Name...");
                    changeName.addActionListener(new ChangeNameListener());
                getNewDealer = new JMenuItem("Get New Dealer");
                    getNewDealer.addActionListener(new GetNewDealerListener());

                editMenu.add(changeName);
                editMenu.add(getNewDealer);

            menuBar.add(fileMenu);
            menuBar.add(editMenu);

        setJMenuBar(menuBar);

        leftSidePanel = new JPanel();
                messageArea = new JTextArea(25,20);
                    messageArea.setEditable(false);
                    messageArea.setLineWrap(true);
                    messageArea.setWrapStyleWord(true);
            messageScroll = new JScrollPane(messageArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            leftSidePanel.add(messageScroll);

        centerPanel = new JPanel();
            centerPanel.setBackground(new Color(0xa67d3d));
            gamePanel = new GamePanel();
                Dimension d;
                betLabel = new JLabel("$50000");
                    betLabel.setForeground(Color.white);
                    betLabel.setIcon(CHIPS);
                    d = betLabel.getPreferredSize();
                    betLabel.setBounds(281,243,d.width,d.height);
                    betLabel.setText("");
                    betLabel.setIcon(null);
                balanceLabel = new JLabel("$50000");
                    balanceLabel.setForeground(Color.white);
                    balanceLabel.setIcon(MORE_CHIPS);
                    d = balanceLabel.getPreferredSize();
                    balanceLabel.setBounds(338,307,d.width,d.height);
                    balanceLabel.setText("");
                    balanceLabel.setIcon(null);
                dealerCards = new JLabel[6];
                playerCards = new JLabel[6];
                for(int i = 0; i < 6; i++)
                {
                    dealerCards[i] = new JLabel();
                    dealerCards[i].setSize(Card.CARD_W,Card.CARD_H);
                    dealerCards[i].setLocation(300 + (int)(.23 * Card.CARD_W) * i,0);

                    playerCards[i] = new JLabel();
                    playerCards[i].setSize(Card.CARD_W,Card.CARD_H);
                    playerCards[i].setLocation((int)(.23 * Card.CARD_W) * i, 399 - Card.CARD_H);
                }

                gamePanel.setLayout(null);
                gamePanel.add(betLabel);
                gamePanel.add(balanceLabel);
                for(JLabel x : dealerCards)
                {
                    gamePanel.add(x);
                }
                for(JLabel x : playerCards)
                {
                    gamePanel.add(x);
                }

            buttonPanel = new JPanel();
            newRound = new JButton("New Round");
                newRound.setEnabled(false);
                newRound.addActionListener(new NewRoundListener());
            hit = new JButton("Hit");
                hit.setEnabled(false);
                hit.addActionListener(new HitListener());
            stand = new JButton("Stand");
                stand.setEnabled(false);
                stand.addActionListener(new StandListener());
            doubleDown = new JButton("Double Down");
                doubleDown.setEnabled(false);
                doubleDown.addActionListener(new DoubleDownListener());

            buttonPanel.setLayout(new GridLayout(1,4));
            buttonPanel.add(newRound);
            buttonPanel.add(hit);
            buttonPanel.add(stand);
            buttonPanel.add(doubleDown);

            centerPanel.setLayout(new BorderLayout());
            centerPanel.add(buttonPanel,BorderLayout.SOUTH);
            centerPanel.add(gamePanel,BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(centerPanel,BorderLayout.CENTER);
        add(leftSidePanel,BorderLayout.WEST);

        setVisible(true);

        //welcome message
        newPlayer.doClick();
    }

    //listeners!!!!!

    /**
     * Controls what happens when the New Player menu item is clicked
     */
    private class NewPlayerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            if(player != null)
            {
                if(!promptSave())
                {
                    return;
                }
            }
            String n = JOptionPane.showInputDialog(null,"What is your name?","New Player",JOptionPane.PLAIN_MESSAGE);
            if(n == null || n.equals(""))
            {
                return;
            }
            player = new Player(n,500);
            if(dealer == null)
            {
                dealer = new Dealer(player);
            }
            else
            {
                dealer.setPlayer(player);
            }
            dealerWelcome();
            updateBalance();

            newRound.setEnabled(true);
            repaint();
        }
    }

    /**
     * Controls what happens when the Load menu item is clicked
     */
    private class LoadListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            if(player != null)
            {
                if(!promptSave())
                {
                    return;
                }
            }
            String n = JOptionPane.showInputDialog(null,"What is the name you would like to load?","Load");
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(new File("saves/" + n + ".boom")));
                player = new Player(in.readLine(),Integer.parseInt(in.readLine()));
            }
            catch(NumberFormatException | IOException | NullPointerException ex)
            {
                messageArea.append("Error loading file\n");
                messageArea.append(ex + "\n");
                return;
            }
            if(dealer == null)
            {
                dealer = new Dealer(player);
            }
            else
            {
                dealer.setPlayer(player);
            }
            updateBalance();
            updatePlayerHand();
            updateDealerHand();
            displayBet(dealer.getBet());
            newRound.setEnabled(true);
            repaint();
            dealerWelcome();
        }
    }

    /**
     * Controls what happens when the Save menu item is clicked
     */
    private class SaveListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            try
            {
                File f = new File("saves/" + player.getName() + ".boom");
                if(f.exists())
                {
                    int n = JOptionPane.showConfirmDialog(null,"Overwrite " + f + "?", "Overwrite",JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.NO_OPTION)
                    {
                        return;
                    }
                }
                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f))))
                {
                    out.println(player.getName());
                    out.println(player.getBalance());
                }
                messageArea.append("Player " + player.getName() + " saved successfully.\n");
            }
            catch(IOException | NullPointerException ex)
            {
                messageArea.append("Save failed.\n");
                messageArea.append(ex.toString() + "\n");
            }
        }
    }

    /**
     * Controls what happens when the Save and Close menu item is clicked
     */
    private class SaveAndCloseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            save.doClick();
            dispose();
            System.exit(0);
        }
    }

    /**
     * Controls what happens when the Close menu item is clicked
     */
    private class CloseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            if(!promptSave())
            {
                return;
            }
            dispose();
            System.exit(0);
        }
    }

    /**
     * Controls what happens when the Change Name menu item is clicked
     */
    private class ChangeNameListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            String n = JOptionPane.showInputDialog(null, "What's your name?", "Name", JOptionPane.PLAIN_MESSAGE);
            if(n != null && !n.equals(""))
            {
                player.setName(n);
            }
            dealerWelcome();
        }
    }

    /**
     * Controls what happens when the Get New Dealer menu item is clicked
     */
    private class GetNewDealerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            messageArea.append(dealer.getName() + " says goodbye!\n");
            dealer = new Dealer(player);
            dealerWelcome();
        }
    }

    /**
     * Controls what happens when the New Round button is clicked
     */
    private class NewRoundListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            newRound.setEnabled(false);
            fileMenu.setEnabled(false);
            editMenu.setEnabled(false);
            String err = "";
            loop:
            while(true)
            {
                try
                {
                    int b = Integer.parseInt(
                        JOptionPane.showInputDialog(null, err + "How much would you like to bet?", "Bet", JOptionPane.PLAIN_MESSAGE));
                    if(b > player.getBalance())
                    {
                        err = "Bet cannot be greater than balance.\n";
                    }
                    else if(b < 2)
                    {
                        err = "Minimum bet is $2.\n";
                    }
                    else
                    {
                        dealer.dealNewRound(b);
                        displayBet(b);
                        break loop;
                    }
                }
                catch(NullPointerException ex)
                {
                    err = "";
                }
                catch(NumberFormatException ex)
                {
                    err = "NaN\n";
                }
            }
            updateBalance();
            updatePlayerHand();
            updateDealerHand();
            dealerCards[0].setIcon(Card.CARD_BACK);
            repaint();
            if(dealer.shouldOfferInsurance())
            {
                int x = JOptionPane.showConfirmDialog(null, dealer.getName() + " has an ace showing. Would you like insurance?\n", "Insurance", JOptionPane.YES_NO_OPTION);
                if(x == JOptionPane.YES_OPTION)
                {
                    dealer.giveInsurance();
                }
            }
            hit.setEnabled(true);
            stand.setEnabled(true);
            doubleDown.setEnabled(true);
            if(player.getHand().blackjack() || dealer.getHand().blackjack())
            {
                results();
            }
        }
    }

    /**
     * Controls what happens when the Hit button is clicked
     */
    private class HitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            doubleDown.setEnabled(false);
            dealer.playerHit();
            updatePlayerHand();
            repaint();
            Hand pH = player.getHand();
            if(pH.busted() || pH.fiveCardCharlie())
            {
                results();
            }
        }
    }

    /**
     * Controls what happens when the Stand button is clicked
     */
    private class StandListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            hit.setEnabled(false);
            stand.setEnabled(false);
            doubleDown.setEnabled(false);

            while(dealer.getHand().getValue() < 17)
            {
                dealer.dealerHit();
                messageArea.append(dealer.getName() + " hit.\n");
            }
            if(!dealer.getHand().busted())
            {
                messageArea.append(dealer.getName() + " stood\n");
            }
            updateDealerHand();
            repaint();
            results();
        }
    }

    /**
     * Controls what happens when the Double Down button is clicked
     */
    private class DoubleDownListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            dealer.doubleDown();
            updatePlayerHand();
            displayBet(dealer.getBet());
            if(player.getHand().busted())
            {
                results();
            }
            else
            {
                stand.doClick();
            }
        }
    }

    /**
     * Controls what happens when the user clicks the red x in the corner
     */
    private class RedXListener extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent ev)
        {
            if(player != null && !promptSave())
            {
                return;
            }
            dispose();
            System.exit(0);
        }
    }

    //helper methods!!!!!

    /**
     * Updates the displayed balance
     */
    private void updateBalance()
    {
        int bal = player.getBalance();
        if(bal > 0)
        {
            balanceLabel.setText("$" + bal);
            balanceLabel.setIcon(MORE_CHIPS);
        }
        else
        {
            balanceLabel.setText("");
            balanceLabel.setIcon(null);
            if(betLabel.getText().equals("$0"))
            {
                JOptionPane.showMessageDialog(null, "Thanks for your moneys!\nGoodbye!", "You're broke!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    /**
     * Updates the Player's displayed Hand
     */
    private void updatePlayerHand()
    {
        Hand playerHand = player.getHand();
        int i = 0;
        try
        {
            for(; i < 6; i++)
            {
                playerCards[i].setIcon(playerHand.get(i).getImageIcon());
            }
        }
        catch(IndexOutOfBoundsException | NullPointerException ex)
        {
            for(; i < 6; i++)
            {
                playerCards[i].setIcon(null);
            }
        }
    }

    /**
     * Updates the Dealer's displayed Hand
     */
    private void updateDealerHand()
    {
        Hand dealerHand = dealer.getHand();
        int i = 0;
        try
        {
            for(; i < 6; i++)
            {
                dealerCards[i].setIcon(dealerHand.get(i).getImageIcon());
            }
        }
        catch(IndexOutOfBoundsException | NullPointerException ex)
        {
            for(; i < 6; i++)
            {
                dealerCards[i].setIcon(null);
            }
        }
    }

    /**
     * Updates the displayed bet
     * @param b bet to display
     */
    private void displayBet(int b)
    {
        if(b > 0)
        {
            betLabel.setText("$" + b);
            betLabel.setIcon(CHIPS);
        }
        else
        {
            betLabel.setText("");
            betLabel.setIcon(null);
        }
    }

    /**
     * Called when the round is over. changes the bet display to show the
     * gross earnings from this round
     */
    private void results()
    {
        newRound.setEnabled(true);
        hit.setEnabled(false);
        stand.setEnabled(false);
        doubleDown.setEnabled(false);

        int oldBalance = player.getBalance();
        messageArea.append(dealer.results() + "\n");
        int gross = player.getBalance() - oldBalance;
        displayBet(gross);
        updateBalance();

        fileMenu.setEnabled(true);
        editMenu.setEnabled(true);
    }

    /**
     * Prompts the user if they would like to save the current Player.
     * This is called before loading or creating a new Player or closing.
     * If user selects yes, the player is saved.
     * @return true if yes or no was selected, false if canceled
     */
    private boolean promptSave()
    {
        int x = JOptionPane.showConfirmDialog(null, "Would you like to save the current player?\n" + player.getName() + "\n$" + player.getBalance(), "Save", JOptionPane.YES_NO_CANCEL_OPTION);
        if(x == JOptionPane.YES_OPTION)
        {
            save.doClick();
        }
        return x != JOptionPane.CANCEL_OPTION;
    }

    /**
     * Prints a Welcome message from the dealer
     */
    private void dealerWelcome()
    {
        messageArea.setText("Hi, " + player.getName() + ". I am " + dealer.getName() + ". I will be your dealer tonight.\n");
        displayBet(0);
        updateBalance();
    }
}