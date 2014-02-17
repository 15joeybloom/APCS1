
/*
 * Joey Bloom
 * Assignment #
 * 
 */
import javax.swing.JFrame;
import java.awt.event.*;

public class MouseMethods implements MouseListener
{
    public MouseMethods()
    {
        JFrame frame = 
            new JFrame("MouseMethods");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.addMouseListener(this);
        frame.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) 
    {
        System.out.println("The frame was clicked at (" + 
                            (e.getX() - 8) + ", " + 
                            (e.getY()  - 30) + ").");
        
    }


    public void mouseEntered(MouseEvent e) 
    {
        System.out.println("The mouse entered the frame.");
    }


    public void mouseExited(MouseEvent e) 
    {
        System.out.println("The mouse exited the frame.");
    }


    public void mousePressed(MouseEvent e) 
    {
        System.out.println("The left mouse button was pressed.");
    }


    public void mouseReleased(MouseEvent e) 
    {
        System.out.println("The left mouse button was released.");
    }

    public static void main(String[] args)
    {
        new MouseMethods();
    }
}

