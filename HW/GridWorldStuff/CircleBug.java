import info.gridworld.actor.Bug;
/**
 * @author Joey Bloom
 * Assignment #40
 * A CircleBug moves in an octogonal path
 */
public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;
    
    public CircleBug(int length)
    {
        sideLength = length;
    }
    public void act()
    {
        if(steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}
