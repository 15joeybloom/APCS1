import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
/**
 * @author Joey Bloom
 * Assignment #41
 * a JBug draws a J over many steps
 */
public class JBug extends Bug
{
    private int steps;
    private Location start;
    private static final int SIZE = 10;
    
    /**
     * Makes a new JBug facing south
     */
    public JBug()
    {
        steps = 0;
        setDirection(Location.SOUTH);
    }
    /**
     * Each step a JBug draws part of a J 
     */
    public void act()
    {
        if(steps == 0)
        {
            start = getLocation();
            moveTo(new Location(start.getRow(), start.getCol() + 9));
        }
        else if(0 < steps && steps < 7)
        {
            move();
        }
        else if(steps == 7)
        {
            turn();
        }
        else if(7 < steps && steps < 11)
        {
            move();
        }
        else if(steps == 11)
        {
            turn();
        }
        else if(11 < steps && steps < 15)
        {
            move();
        }
        else if(steps == 15)
        {
            turn();
        }
        else if(15 < steps && steps < 19)
        {
            move();
        }
        else
        {
            turn();
        }
        steps++;
    }
}
