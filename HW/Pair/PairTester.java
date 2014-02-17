/**
 * @author Joey Bloom
 * Assignment #16
 * Tests the Pair class
 */
import javax.swing.JOptionPane;
public class PairTester
{
    public static void main(String[] args)
    {
        boolean worked;
        double first;
        double second;
        do
        {
            worked = true;
            try
            {
                first = Double.parseDouble(
                        JOptionPane.showInputDialog(
                        null,
                        "Enter first number: ", 
                        "First", 
                        JOptionPane.INFORMATION_MESSAGE ));
                second = Double.parseDouble(
                         JOptionPane.showInputDialog(
                         null,
                         "Enter second number: ", 
                         "Second", 
                         JOptionPane.INFORMATION_MESSAGE ));
            }
            catch( NumberFormatException e)
            {
                worked = false;
                JOptionPane.showMessageDialog(
                    null, 
                    "I'm sorry, that's not an " +
                    "actual number. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                continue;
            }
            Pair pair = new Pair(first,second);
            JOptionPane.showMessageDialog( null, pair );
        }   while( worked == false );
    }
}