package blackjack;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Joey Bloom
 *
 */
public class ImageCropTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        File file = new File("cards.png");
        assert file.canRead();
        BufferedImage cards = ImageIO.read(file);
        BufferedImage aceOfClubs = cards.getSubimage(0,0,79,123);
        ImageIO.write(aceOfClubs,"png",new File("aceClubs.png"));
        Image img = (Image) aceOfClubs;
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel label = new JLabel(imgIcon);
    }

}