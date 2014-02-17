/**
 * @author Joey Bloom
 * Assignment #
 * 
 */

import java.util.Random;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class CombinationLock implements ActionListener
{
    public static void main(String[] args)
    {
        CombinationLock lock = new CombinationLock('J','P','B');
        lock.GUI();
    }
    public static final char[] LET =
        { 'A', 'B', 'C', 'D', 'E',
          'F', 'G', 'H', 'I', 'J',
          'K', 'L', 'M', 'N', 'O',
          'P', 'Q', 'R', 'S', 'T',
          'U', 'V', 'W', 'X', 'Y', 'Z' };
    private final char FIRST, SECOND, THIRD;
    private char currentFirst, currentSecond, currentThird;
    boolean isLocked;
    private JLabel label;
    /**
     * Parameterized constructor with letters. 
     * Sets the combination of the
     * CombinationLock to the three provided chars.
     * 
     * @param one The first letter in the combo
     * @param two The second letter in the combo
     * @param three the third letter in the combo
     */
    public CombinationLock( char one, 
                            char two, 
                            char three )
    {
        FIRST = one;
        SECOND = two;
        THIRD = three;
        isLocked = true;
    }
    /**
     * Parameterized constructor with numbers. Sets the combo
     * of the CombinationLock to the letters corresponding to
     * the three provided ints.
     */
    public CombinationLock( int one,
                            int two,
                            int three )
    {
        this(LET[one - 1], LET[two - 1], LET[three - 1]);
    }
    /**
     * No-parameters constructor. Uses three random letters
     * as the combo.
     */
    public CombinationLock()
    {
        this( new Random().nextInt(25), 
              new Random().nextInt(25), 
              new Random().nextInt(25));
    }
    
    /**
     * Turn the lock to a letter.
     * 
     * @param let The letter being turned to.
     */
    public void turnTo(char let)
    {
        currentFirst = currentSecond;
        currentSecond = currentThird;
        currentThird = let;
        checkLocked();
    }
    
    private void checkLocked()
    {
        if ( currentFirst == FIRST &&
             currentSecond == SECOND &&
             currentThird == THIRD )
        {
            isLocked = false;
        }
        else
        {
            isLocked = true;
        }
    }
    
    /**
     * Starts a GUI for the combination lock, where the user
     * can enter combinations and see if the CombinationLock is
     * locked or not
     */
    public void GUI()
    {
        JFrame frame = new JFrame("Lock");
        frame.setSize(500,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,9));
        
        int x = 0;
        int y = 0;
        final String[] QWERTY =
            { "Q","W","E","R","T","Y","U","I","O","P",
              "A","S","D","F","G","H","J","K","L", "",
              "Z","X","C","V","B","N","M", "", "", "",};
        for( int i = 0 ; i < 30 ; i++ )
        {
            JButton button = 
                new JButton(QWERTY[i]);
            
            if(!button.getText().equals(""))
                button.addActionListener(this);
            panel.add(button);
        }
        
        label = new JLabel("Locked");
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        frame.add(label,BorderLayout.SOUTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public void actionPerformed( ActionEvent e )
    {
        //when button is clicked, 
        //turn the lock to the respective letter
        JButton button = (JButton) e.getSource();        
        turnTo((button.getText()).charAt(0));
        if(isLocked)
            label.setText("Locked");
        else
            label.setText("Unlocked");
    }    
}

