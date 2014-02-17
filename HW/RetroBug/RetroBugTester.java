import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
// import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;

import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #43
 * Tests the RetroBug class
 */
public class RetroBugTester
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        //straight around grid
        world.add(new Location(2,0),new RetroBug(Color.blue));

        //rocks in front
        world.add(new Location(5,4),new RetroBug(Color.green));
        world.add(new Location(3,4),new Rock(Color.green));
        world.add(new Location(3,5),new Rock(Color.green));
        
        //rock behind
        RetroBug joey = new RetroBug(Color.red);
        world.add(new Location(7,7),joey);
        joey.act(); joey.act(); joey.act();
        world.add(new Location(5,7),new Rock(Color.red));
        
        world.show();
    }
}

