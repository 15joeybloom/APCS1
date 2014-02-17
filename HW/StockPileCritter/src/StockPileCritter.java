
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * @author 151bloomj
 * Assignment #18
 * StockPileCritter
 */
public class StockPileCritter extends Critter
{
    private int pilee = 0;

    @Override
    public void processActors(ArrayList<Actor> actors)
    {
        for(Actor a : actors)
        {
            pilee++;
            a.removeSelfFromGrid();
        }
    }

    @Override
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        pilee--;
        if(pilee < 0)
        {
            return null;
        }
        else
        {
            return super.selectMoveLocation(locs);
        }
    }

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new Rock());
        world.add(new StockPileCritter());

        world.show();
    }
}
