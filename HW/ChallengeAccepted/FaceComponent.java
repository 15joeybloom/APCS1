import java.awt.*;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/*
 * Joey Bloom
 * Assignment #5
 * This is where the actual drawing
 * takes place.
 */

//Do no forget the "extends" part!!!
public class FaceComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        Ellipse2D.Double head = 
            new Ellipse2D.Double(10,10,80,80);
        g2.draw(head);
        
        Ellipse2D.Double leftEye = 
            new Ellipse2D.Double(25,35,10,10);
        g2.draw(leftEye);
        
        Ellipse2D.Double rightEye =
            new Ellipse2D.Double(65,35,10,10);
        g2.draw(rightEye);
        
        Line2D.Double mouth =
            new Line2D.Double(25,65,75,65);
        g2.draw(mouth);
        
        
    }
}