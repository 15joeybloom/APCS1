import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #45
 * A Bluster Critter is slightly claustrophobic
 */
public class BlusterCritter extends Critter
{
    private byte c;
    private static final double DARKENING_FACTOR = 0.05;
    
    /**
     * Constructs a BlusterCritter with c value 6
     */
    public BlusterCritter()
    {
        this(6);
    }
    /**
     * Constructs a BlusterCritter with c value.
     * precondition: 0 <= c <= 24
     * @param c c
     */
    public BlusterCritter(byte c)
    {
        this.c = c;
    }
    /**
     * Constructs a BlusterCritter with c value as an int
     * precondition: 0 <= c <= 24
     * @param c c
     */
    public BlusterCritter(int c)
    {
        this((byte)c);
    }
    
    /**
     * Returns all the Critters within a 2 square radius
     * @return Critters within 2 squares
     */
    @Override
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> returnMe = new ArrayList<>();
        Grid g = getGrid();
        Location myLoc = getLocation();
        final int[] nums = {-2,-1,0,1,2};
        for(int r : nums)
        {
            for(int c : nums)
            {
                Location loc = new Location(myLoc.getRow() + r, myLoc.getCol() + c);
                if(g.isValid(loc) && !loc.equals(myLoc))
                {
                    Actor a = (Actor) g.get(loc);
                    if(a != null)
                    {
                        returnMe.add(a);
                    }
                }
            }
        }
        return returnMe;
    }
    /**
     * If the number of actors < c brighten the color because
     * the BlusterCritter is not feeling squished. Else darken
     * because the BlusterCritter is feeling squished.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        ArrayList<Critter> critters = new ArrayList<>();
        for(Actor a : actors)
        {
            if(a instanceof Critter)
            {
                critters.add((Critter)a);
            }
        }
        if(critters.size() < c)
            brighten();
        else
            darken();
    }
    /**
     * Brightens the BlusterCritter like the opposite of a Flower
     */
    private void brighten()
    {
        Color c = getColor();
        int red = 255 - (int) ((255 - c.getRed()) * (1 - DARKENING_FACTOR));
        int green = 255 - (int) ((255 - c.getGreen()) * (1 - DARKENING_FACTOR));
        int blue = 255 - (int) ((255 - c.getBlue()) * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }
    /**
     * Darkens the BlusterCritter like a Flower
     */
    private void darken()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }
}
