import info.gridworld.actor.Bug;
/**
 * @author Joey Bloom
 * Assignment #40
 * A SpiralBug moves in a spiral path
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;
    
    public SpiralBug(int length)
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
            turn();
            steps = 0;
            sideLength++;
        }
    }
}

