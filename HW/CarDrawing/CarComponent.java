
/*
 * Joey Bloom
 * In-class Example (for Assignment #13)
 * Draws two instances of the Car
 * class
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

//dont forget extends JComponent!!!
public class CarComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        Car car1 = new Car();
        
        int x = getWidth() - 60;
        int y = getHeight() - 30;
        
        Car car2 = new Car(x,y);
        
        car1.draw(g2);
        car2.draw(g2);
    }
}
