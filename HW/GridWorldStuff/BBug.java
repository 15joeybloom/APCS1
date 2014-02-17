import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
/**
 * @author Joey Bloom
 * Assignment #41
 * A BBug draws a B over many steps
 */
public class BBug extends Bug
{
    private int steps;
    private Location start;
    private static final int SIZE = 10;
    
    /**
     * Makes a BBug facing East
     */
    public BBug()
    {
        steps = 0;
        setDirection(Location.EAST);
    }
    /**
     * Each step a BBug draws part of a B
     */
    public void act()
    {
        if(steps == 0)
        {
            start = getLocation();
        }
        else if(0 < steps && steps < 4)
        {
            move();
        }
        else if(steps == 4)
        {
            turn();
        }
        else if(steps == 5)
        {
            move();
        }
        else if(steps == 6)
        {
            turn();
        }
        else if(steps == 7)
        {
            move();
        }
        else if(steps == 8)
        {
            turn();
        }
        else if(8 < steps && steps < 11)
        {
            move();
        }
        else if(steps == 11)
        {
            turn();
        }
        //bottom of first hump
        else if(11 < steps && steps < 14)
        {
            move();
        }
        //turn around to start second hump
        else if(14 <= steps && steps <= 17)
        {
            turn();
        }
        //top of second hump
        else if(17 < steps && steps < 22)
        {
            move();
        }
        else if(steps == 22)
        {
            turn();
        }
        else if(22 < steps && steps < 25)
        {
            move();
        }
        //middle of second hump
        else if(steps == 25)
        {
            turn();
        }
        else if(steps == 26)
        {
            move();
        }
        else if(steps == 27)
        {
            turn();
        }
        //bottom right slant
        else if(27 < steps && steps < 30)
        {
            move();
        } 
        else if(steps == 30)
        {
            turn();
        }
        else if(30 < steps && steps < 35)
        {
            move();
        }
        else if(steps == 35 || steps == 36)
        {
            turn();
        }
        else if(36 < steps && steps < 46)
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