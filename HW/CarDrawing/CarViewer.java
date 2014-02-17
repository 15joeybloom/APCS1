
/*
 * Joey Bloom
 * In-class Example (for Assignment #13)
 * Contains the main method that runs
 * the entire program
 */

import javax.swing.JFrame;

public class CarViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(300,400);
        frame.setTitle("Two cars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CarComponent c = new CarComponent();
        frame.add(c);
        
        frame.setVisible(true);
    }
}
