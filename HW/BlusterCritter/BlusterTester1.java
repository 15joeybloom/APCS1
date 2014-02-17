import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Bug;

import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #45
 * Tests BlusterCritter
 */
public class BlusterTester1
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
        world.add(new Location(3,3),new BlusterCritter(1));
        for(int i = 0; i < 7; i++)
        {
            world.add(new Location(i,0),new Critter());
        }
        world.show();
    }
}
