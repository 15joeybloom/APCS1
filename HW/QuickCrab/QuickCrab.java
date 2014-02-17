import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Joey Bloom
 * Assignment #46
 * Moves two spaces at a time if it can, else behaves like a CrabCritter
 */
public class QuickCrab extends CrabCritter
{
    /**
     * default constructor, sets color to cyan
     */
    public QuickCrab()
    {
        setColor(Color.cyan);
    }
    /**
     * Color constructor
     */
    public QuickCrab(Color c)
    {
        setColor(c);
    }
    /**
     * @return list of empty locations two to the right and two to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = 
            getEmptyTwoAwayLocationsInDirections(
                new int[]{Location.LEFT, Location.RIGHT}
            );
        return locs.size() == 0 ? super.getMoveLocations() : locs;
    }
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are 2 away neighbors of the current
     * location in the given directions
     */
    private ArrayList<Location> getEmptyTwoAwayLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        for (int d : directions)
        {
            int useMe = d + getDirection();
            Location neighborLoc = loc.getAdjacentLocation(useMe);
            if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null)
            {
                Location twoAwayLoc = neighborLoc.getAdjacentLocation(useMe);
                if(gr.isValid(twoAwayLoc) && gr.get(twoAwayLoc) == null)
                    locs.add(twoAwayLoc);
            }
        }
        return locs;
    }
}
