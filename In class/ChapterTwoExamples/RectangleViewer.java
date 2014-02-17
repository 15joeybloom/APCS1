
/**
 * Joey Boom
 * In-class Example 6
 * My first GUI!! :D
 */

import javax.swing.JFrame;

public class RectangleViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(400,400);
        frame.setTitle("Empty Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        RectangleComponent component = new RectangleComponent();
        frame.add(component);
        
        frame.setVisible(true);
                
    }
}
