/**
 * Joey Bloom
 * Assignment #15
 * Draws an instance of the IceCreamCone
 * class.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.*;
import javax.swing.JFrame;

//dont forget extends JComponent!!!
public class IceCreamConeComponent extends JComponent
{
    private int radius, height;
    
    /**
     * Constructs an IceCreamConeComponent with the
     * given radius and height
     * 
     * @param r radius
     * @param h height
     */
    public IceCreamConeComponent( int r, int h )
    {
        radius = r;
        height = h;        
    }
    
    /**
     * Draws a cone with radius and height from constructor.
     * Executed when the component is added to something.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        IceCreamCone c = new IceCreamCone(radius, height);
        
        c.draw(g2);
    }   
}