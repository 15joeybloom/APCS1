
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author 151bloomj
 */
public class OpossumCritter extends Critter
{
    private int numStepsDead;
    public OpossumCritter()
    {
         numStepsDead = 0;
         setColor(Color.ORANGE);
    }

    /**
     * Whenever actors contains more foes than friends, this OpossumCritter plays dead.
     * Postcondition: (1) The state of all actors in the grid other than this critter and the
     * elements of actors is unchanged. (2) The location of this critter is unchanged.
     * @param actors a group of actors to be processed
     */
    @Override
    public void processActors(ArrayList<Actor> actors)
    {
        int netFoes = 0;
        for(Actor a : actors)
        {
            if(isFriend(a))
            {
                netFoes--;
            }
            else if(isFoe(a))
            {
                netFoes++;
            }
        }
        if(netFoes < 0)
        {
            numStepsDead = 0;
            setColor(Color.orange);
        }
        else
        {
            numStepsDead++;
            setColor(Color.black);
        }
    }

    /**
     * Selects the location for the next move.
     * Postcondition: (1) The returned location is an element of locs, this critter's current location,
     * or null. (2) The state of all actors is unchanged.
     * @param locs the possible locations for the next move
     * @return the location that was selected for the next move, or null to indicate
     * that this OpossumCritter should be removed from the grid.
     */
    @Override
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        switch(numStepsDead)
        {
            case 1:
            case 2:
                return getLocation();
            case 3:
                return null;
            default:
                return super.selectMoveLocation(locs);

        }
    }

    /**
     * @param other the actor to check
     * @return true if other is a friend; false otherwise
     */
    private boolean isFriend(Actor other)
    {
    /* implementation not shown */
    }

    /**
     * @param other the actor to check
     * @return true if other is a foe; false otherwise
     */
    private boolean isFoe(Actor other)
    {
    /* implementation not shown */
    }
}
