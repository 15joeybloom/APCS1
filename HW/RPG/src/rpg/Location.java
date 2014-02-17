package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nate
 */
public class Location {

    private Actor c;
    private String name;
    
    public Location(String s){
        name = s;
    }

    public BufferedImage getImage() {
        try {
            BufferedImage img;
            img = ImageIO.read(new File(name+".png"));
            return img;
        } catch (IOException ex) {
            System.out.println("No Loc Image");
            return null;
        }
    }

    public void addCharacter(Actor c) {
        this.c = c;
    }

    public Actor getCharacter() {
        return c;
    }

    public boolean hasUnit() {
        return c != null;
    }

    public void removeCharacter() {
        c = null;
    }
}
/**
 * Allons-y
 */
