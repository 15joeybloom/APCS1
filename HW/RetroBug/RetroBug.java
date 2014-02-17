import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
//import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.Stack;
import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #43
 * A RetroBug is just like a Bug, but it has a restore 
 * method that returns it to the state it was before its last move.
 */
public class RetroBug extends Bug
{
    //Location or Integer (indicating direction)
    private Stack<Object> path = new Stack<>();
    
    /**
     * Constructs a red RetroBug
     */
    public RetroBug(){super();}
    /**
     * Constructs a colored RetroBug
     * @param c color
     */
    public RetroBug(Color c){super(c);}
    /**
     * Stores the Location or direction, then acts as normal.
     */
    @Override
    public void act()
    {
        if(canMove())
        {
            path.push(getLocation());
            move();
        }
        else
        {
            path.push(getDirection());
            turn();
        }
    }
    /**
     * puts the RetroBug back to its previous Location and direction,
     * unless there is a Rock in that space.
     */
    public void restore()
    {
        if(path.empty()) return;
        Object lastAct = path.pop();
        if(lastAct instanceof Integer)
        {
            setDirection( (Integer)lastAct );
        }
        else if(lastAct instanceof Location)
        {
            Location lastLocation = (Location)lastAct;
            Grid<Actor> gr = getGrid();
            if(gr == null) return;
            Actor neighbor = gr.get(lastLocation);
            if(gr.isValid(lastLocation) && 
              (neighbor == null || neighbor instanceof Flower))
            {
               moveTo(lastLocation);
            }
            else
            {
                path.push(lastLocation);
            }
        }
        else
        {
            System.err.println("error in restore method. help me!");
        }
    }
}
