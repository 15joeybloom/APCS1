package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nate
 */
public class Merchant extends Actor {

    private Item[] items;

    public Merchant(Item[] items) {
        this.items = items;
    }

    public BufferedImage getImage() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Merchant.png"));
        } catch (IOException ex) {
            System.out.println("No Merchant Pic");
        }
        return img;
    }

    public Item[] getItems() {
        return items;
    }
}
/**
 * Allons-y
 */
