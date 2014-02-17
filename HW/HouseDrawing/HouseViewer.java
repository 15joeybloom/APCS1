
/*
 * Joey Bloom
 * Assignment #13
 * Contains the main method that runs
 * the entire program
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;

public class HouseViewer 
       implements MouseListener, ActionListener
{
    private JFrame frame;
   
    public HouseViewer(int x , int y, int w, int h)
    {
        frame = new JFrame("A Very Fine House");
        frame.setBounds(x, y, w, h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttPanel = new JPanel();
        buttPanel.setOpaque(false);
        buttPanel.setLayout(null);
        buttPanel.setBounds(0,0,0,0); 
        frame.add(buttPanel);
                            
        JButton butt = new JButton("Clear");
        butt.setBounds(0,0,75,50);
        buttPanel.add(butt); 
        
        frame.addMouseListener(this);               
        butt.addActionListener(this);
        
        frame.setVisible(true);
        
        
    }
    
    /**
     * When the button is clicked, the frame is
     * reset, at the same location and size but
     * no houses.
     */
    public void actionPerformed(ActionEvent e)
    {
        frame.setVisible(false);
        new HouseViewer( frame.getX(), frame.getY(),
                         frame.getWidth(), frame.getHeight());
    }
    
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    /**
     * When the mouse is released on the frame,
     * a house is drawn at that location.
     */
    public void mouseReleased(MouseEvent e)
    {
        HouseComponent h = 
            new HouseComponent(e.getX() - 8, e.getY() - 30);
        frame.setVisible(false);
        frame.add(h);
        frame.setVisible(true);
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public static void main(String[] args)
    {
        new HouseViewer(50,50,500,500);        
    }
    
}