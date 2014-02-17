package reviewforq3test;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * @author 151bloomj
 * inclass example prep for Q3 test 3/19/13
 */
public class GridWorldPractice
{
    public static void main(String[] args)
    {
        Location loc1 = new Location(3,8);
        Location loc2 = new Location(2,2);
        System.out.println(loc1);

//        ActorWorld world = new ActorWorld();
//        Bug jack = new Bug(Color.green);
//        world.add(jack);
//
//        Location loc3 = loc2.getAdjacentLocation(Location.SOUTH);
//        Bug dudette = new Bug();
//        world.add(loc3,dudette);

        Grid<Actor> grid = new BoundedGrid<Actor>(10,10);
        Bug ladybug = new Bug();
        ladybug.putSelfInGrid(grid, new Location(2,8));
        ladybug.setDirection(Location.WEST);
        ActorWorld world = new ActorWorld(grid);

        world.show();
    }
}
