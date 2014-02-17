package blackjack;

import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Joey Bloom
 *
 */
public class GamePanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        //draw table
        try
        {
            g.drawImage(ImageIO.read(getClass().getResource("table3.png")),0,0,null);
        }
        catch(Exception e)
        {
            System.err.println("Failed to load table3.png");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
