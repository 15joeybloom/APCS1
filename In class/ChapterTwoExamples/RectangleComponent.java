import java.awt.*;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;

/*
 * Joey Bloom
 * In-class Example 6
 * This is where the actual drawing
 * takes place.
 */

//Do no forget the "extends" part!!!
public class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        Rectangle box = new Rectangle(5,10,20,30);
        g2.draw(box);
        
        Rectangle boxTwo = new Rectangle(50,10,20,30);
        g2.draw(boxTwo);
        
        Ellipse2D.Double circle = 
            new Ellipse2D.Double(25,30,30,30);
        g2.draw(circle);
    }
}