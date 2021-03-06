import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;

import java.awt.Color;

/**
 * @author Joey Bloom <br/>
 * Assignment #40
 */
public class GridTester
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug andy = new CircleBug(5);
        andy.setColor(Color.magenta);
        world.add(andy);

        //         world.add(new Rock());
        //         world.add(new Critter());

        Flower tim = new Flower();
        tim.setColor(Color.pink); //tim is blooming
        world.add(new Location(4,4),tim);

        Rock alexis = new Rock();
        world.add(new Location(9,9),alexis);

        world.add(new Location(5,0),new SpiralBug(3));
        world.show();
    }
}
