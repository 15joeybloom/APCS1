
/*
 * Joey Bloom
 * In-class Example (for Assignment #13)
 * Draws two instances of the House
 * class
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.*;
import javax.swing.JFrame;

//dont forget extends JComponent!!!
public class HouseComponent extends JComponent
{
    private int xLeft, yTop;
    
    public HouseComponent( int x, int y )
    {
        xLeft = x;
        yTop = y;        
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        House h2 = new House(xLeft,yTop);
        
        h2.draw(g2);
    }
   
}
