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
 * Assignment #41
 * Tests BBug and JBug
 */
public class JBugBBugTester
{
    public static void main(String[] args)
    {
        UnboundedGrid<Actor> grid = new UnboundedGrid<>();
        ActorWorld world = new ActorWorld(grid);
        JBug jonah = new JBug();
        BBug jonahh = new BBug();
        world.add(new Location(0,0),jonah);
        world.add(new Location(0,12),jonahh);
        world.show();
    }
}
