
/**
 * Joey Boom
 * Assignment #5
 * Draws an expressionless face.
 */

import javax.swing.JFrame;

public class FaceViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(150,150);
        frame.setTitle("Challenge Accepted.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FaceComponent component = new FaceComponent();
        frame.add(component);
        
        frame.setVisible(true);
                
    }
}
