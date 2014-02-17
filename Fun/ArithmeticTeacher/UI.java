
/*
 * Joey Bloom
 * Assignment #
 * 
 */

import javax.swing.JOptionPane;

public class UI
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, 
            "Welcome to the game!");
        JOptionPane.showMessageDialog(null,
            "Enter the correct answer to the simple " +
            "math problem.");
        Game g = new Game();
        while(g.getLevel() < 4)
        {
            try
            {
                int answer = Integer.parseInt(
                    JOptionPane.showInputDialog(
                    "Level: " + g.getLevel() +
                    "\nScore: " + g.getScore() +
                    "\nTries: " + g.getTries() + "\n" +
                    g.getEquation()));
                g.evaluateAnswer(answer);
            }
            catch(NumberFormatException e)
            {
                if("null".equals(e.getLocalizedMessage()))
                    break;
                else
                    JOptionPane.showMessageDialog(null,
                        "Oops, that's not a number!");
            }
        }
        if(g.getLevel() >= 4)
            JOptionPane.showMessageDialog(null, "You win!");
        JOptionPane.showMessageDialog(null,"Have a nice day!");
    }
}

