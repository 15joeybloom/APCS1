package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Dean Li Extends the character class: can't fight them, but can open
 * dialogue
 */
public class Friend extends Actor {

    private String dialogue;

    public Friend(String c) {
        dialogue = c;
    }

    public String getDialogue() {
        return dialogue;
    }

    /**
     * Returns an image for the map to display
     */
    public BufferedImage getImage() {
        try {
            return (BufferedImage) (ImageIO.read(new File("Friend.png")));
        } catch (IOException a) {
            System.out.println("Error");
        }

        return null;
    }
}