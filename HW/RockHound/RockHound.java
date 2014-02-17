import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import java.util.ArrayList;
/**
 * @author Joey Bloom
 * Assignment #44
 * Same as a Critter, but eats Rock too
 */
public class RockHound extends Critter
{
    public void processActors(ArrayList<Actor> actors)
    {
        for(Actor a : actors)
        {
            if(a instanceof Rock)
            {
                a.removeSelfFromGrid();
            }
        }
    }
}
