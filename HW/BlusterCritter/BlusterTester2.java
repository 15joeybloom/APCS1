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
public class BlusterTester2
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid(5,5));
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                Critter c = new Critter();
                c.setColor(Color.red);
                world.add(new Location(i,j),c);
            }
        }
        world.add(new Location(2,2),new BlusterCritter(24));
        
        world.show();
    }
}
