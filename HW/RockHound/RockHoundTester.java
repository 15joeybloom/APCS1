import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Bug;

import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #44
 * Tests RockHound
 */
public class RockHoundTester
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid(7,7));
        
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                world.add(new Location(i,j),new Rock());
            }
        }
        world.add(new Location(4,3),new Bug());
        world.add(new Location(5,5),new RockHound());
        
        world.show();
    }
}
