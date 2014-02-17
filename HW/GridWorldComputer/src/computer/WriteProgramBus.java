package computer;

import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * <p>
 * Used by the {@link computer.CPU} to write all of the instructions in a program, in
 * correct order, to memory starting at a specified row.
 * </p>
 *
 * @author Joey Bloom
 */
public class WriteProgramBus extends MemoryBus
{
    private short[] instructions;

    /**
     * Constructs a WriteProgramBus
     * @param a future address of first instruction. Must be first byte in a row.
     *          precondition: a % 16 == 0
     * @param instructions CPU instructions in order of execution.
     *          precondition: instructions.length <=
     *                          MemoryBus.MEMORY_C * MemoryBus.MEMORY_R
     */
    public WriteProgramBus(short a, short[] instructions)
    {
        super(a);
        assert a % 16 == 0;
        this.instructions = instructions;
        setDirection(Location.SOUTH);
        if(getOpcode() == 0) setColor(Color.black);
    }

    /**
     * A WriteProgramBus that is sent out from CPU acts
     * by sending other WriteProgramBuses with subarrays
     * of the instructions to write.
     */
    @Override
    public void act()
    {
        int dir = getDirection();
        Location loc = getLocation();
        int r = loc.getRow();
        int c = loc.getCol();

        if(dir == Location.SOUTH)
        {
            if(r <= (((address & ROW) * 2) >>> 4))
            {
                move();
            }
            else if(r % 2 == 1)//if in a "passing row" (without memory Bits)
            {
                //if past last row, move to first row
                if(r > MEMORY_R * 2)
                {
                    moveTo(new Location(1,c));
                }

                //send WriteProgramBus to right,
                //with this WriteProgramBus's instructions
                WriteProgramBus b = new WriteProgramBus((short)0,instructions);
                b.putSelfInGrid(getGrid(),loc.getAdjacentLocation(Location.EAST));
                b.setDirection(Location.EAST);

                if(instructions.length > 8)
                {
                    //shift the first 8 instructions out
                    short[] temp = new short[Math.max(8,instructions.length-8)];
                    for(int i = 8; i < instructions.length; i++)
                    {
                        temp[i-8] = instructions[i];
                    }
                    instructions = temp;
                }
                else
                {
                    setDirection(Location.NORTH);
                }
                move();
            }
            else
            {
                move();
            }
        }
        else if(dir == Location.NORTH)
        {
            move();
        }
        else if(dir == Location.EAST)
        {
            if(c >= 160)
            {
                removeSelfFromGrid();
            }
            else
            {   //this is where the bit is processed (sorta)
                int x = c % 20;
                if(x % 10 != 9 && x % 10 != 0)
                {
                    x -= x > 10 ? 3 : 1; //eliminate empty spaces
                    x = 15 - x;
                    Bit b = (Bit)getGrid().get(loc.getAdjacentLocation(Location.NORTH));
                    b.set(instructions[c/20] & (1 << x));
                }
                move();
            }
        }
    }

    /**
     *
     * @param b
     * @param p
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        //this method is not used
    }
}
