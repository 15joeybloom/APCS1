import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;

import java.awt.Color;
/**
 * @author Joey Bloom
 * Inclass example for chapter 10
 * tests critters
 */
public class CritterTester
{
    public static void main(String[] args)
    {
        UnboundedGrid<Actor> grid = new UnboundedGrid<>();
        ActorWorld world = new ActorWorld(grid);
        
        world.add(new Location(7,8),new Rock());
        world.add(new Location(3,3),new Rock());
        world.add(new Location(2,8),new Flower(Color.blue));
        world.add(new Location(5,5),new Flower(Color.pink));
        world.add(new Location(1,5),new Flower(Color.red));
        world.add(new Location(7,2),new Flower(Color.yellow));
        world.add(new Location(0,0),new Critter());
        world.show();
    }
}
