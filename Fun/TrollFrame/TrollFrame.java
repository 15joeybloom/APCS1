
/*
 * Joey Bloom
 * 9/23/12
 * When the user mouses over the window,
 * it moves and creates a copy of itself.
 * Exponential growth ftw!
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.util.Random;
import java.awt.Rectangle;

public class TrollFrame 
       implements MouseListener
{
    private JFrame frame;
    private Random rand = new Random();
    private Rectangle bounds;
    private final int WIDTH = 216;
    private final int HEIGHT = 197;
   
    public TrollFrame(int x , int y)
    {
        frame = new JFrame("TROLOLOLOLOLOLOLOLOLOLOL");
        frame.setResizable(false);
        bounds = new Rectangle(x, y, WIDTH,HEIGHT);
        frame.setBounds(bounds);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        ImageIcon image = new ImageIcon("trollface.png");
        JLabel imageLabel = new JLabel(image);
        frame.add(imageLabel);
        
        frame.addMouseListener(this);
        frame.setVisible(true);          
        
    }
    
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
        frame.setBounds(new Rectangle(
                        rand.nextInt(1201),
                        rand.nextInt(601) + 30, 
                        WIDTH, HEIGHT));
        new TrollFrame(rand.nextInt(1201),rand.nextInt(601) + 30);
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public static void main(String[] args)
    {
        Random r = new Random();
        new TrollFrame(r.nextInt(1201),r.nextInt(601) + 30);        
    }
    
}