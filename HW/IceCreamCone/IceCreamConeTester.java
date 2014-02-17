
/**
 * Joey Bloom
 * Assignment #15
 * Tests the IceCreamCone class.
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class IceCreamConeTester
{
    public static void main(String[] args)
    {
        int radius = Integer.parseInt(
                     JOptionPane.showInputDialog(
                     "Enter radius: "));
        int height = Integer.parseInt(
                     JOptionPane.showInputDialog(
                     "Enter height: "));
        IceCreamCone cone = new IceCreamCone( radius, height );
        
        JFrame frame = new JFrame("We all scream for: ");
        frame.setBounds(50,50, 500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new IceCreamConeComponent(radius, height));
        frame.setVisible(true);
        
        JOptionPane.showMessageDialog(null, cone);
    }
}