package q3;

import java.util.List;

/**
 * @author Joey Bloom
 * 2011 Free Response Question 3
 */
public class FuelDepot
{
    private FuelRobot filler;

    private List<FuelTank> tanks;

    public int nextTankTFill(int threshold)
    {
        for(int i = 0; i < tanks.size(); i++)
        {
            if(tanks.get(i).getFuelLevel() <= threshold)
            {
                return i;
            }
        }
        return filler.getCurrentIndex();
    }

    public void moveToLocation(int locIndex)
    {
        int current = filler.getCurrentIndex();
        if(locIndex == current) return;
        else if(locIndex > current)
        {
            if(!filler.isFacingRight()) filler.changeDirection();
            filler.moveForward(locIndex - current);
        }
        else
        {
            if(filler.isFacingRight()) filler.changeDirection();
            filler.moveForward(current - locIndex);
        }
    }
}
