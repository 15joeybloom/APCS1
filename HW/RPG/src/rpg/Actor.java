package rpg;

import java.awt.image.BufferedImage;

/**
 * Abstract class Actor
 *
 * @authors Dean Li and Nathan Weiskirch A actor abstract class that will be
 * easier for the map to call certain methods on, displaying the correct image
 * at the correct location;
 */
public abstract class Actor {

    /**
     * Returns an image for the map to display
     */
    public abstract BufferedImage getImage();
}
