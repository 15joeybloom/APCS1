import info.gridworld.actor.Bug;
/**
 * Write a description of class BoxBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBug extends Bug
{
    private int steps;
    private int sideLength;
    
    public BoxBug(int length)
    {
        sideLength = length;
    }
    public void act()
    {
        if(steps < sideLength & canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
    }
}
