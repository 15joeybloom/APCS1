package computer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import java.awt.Color;

/**
 * <p>
 * Fetches an instruction from memory using the address passed to it. Since
 * CPU instructions are 2 bytes, this Bus behaves slightly differently
 * than MemoryBuses, accessing 2 bytes from memory rather than just one.
 * </p>
 *
 * <p>
 * Image: F
 * </p>
 *
 * @author Joey Bloom
 */
public class FetchInstructionBus extends MemoryBus
{
    private short nextInstruction;

    /**
     * Constructs a FetchInstructionBus to visit the address a.
     * @param a address of next instruction.
     *          precondition: a % 2 == 0
     */
    public FetchInstructionBus(short a)
    {
        super(a);
        nextInstruction = 0;
        if(getOpcode() == 0) setColor(Color.black);
    }

    /**
     * A FetchInstructionBus acts similarly to a MemoryBus.
     * However, when it reaches the end of the first desired byte it continues
     * and reads a second byte.
     */
    @Override
    public void act()
    {
        int direction = getDirection();
        Location loc = getLocation();
        int r = loc.getRow();
        int c = loc.getCol();
        if(direction == Location.EAST)
        {
            //if traversing correct memory location
            if(r > 0)
            {
                final int X = c % 20;
                if(X == 0)
                {
                    move();
                }
                else if(X == 19)
                {
                    setDirection(Location.NORTH);
                }
                else
                {
                    int p = X > 10 ? 18 - X : 16 - X;
                    processBit(
                        (Bit)getGrid().get(loc.getAdjacentLocation(Location.NORTH)),
                        p);
                    move();
                }
            }
            //if has not reached correct col yet
            else if(c < (address & COL) * 10)
            {
                move();
            }
            else //if at correct col
            {
                setDirection(Location.SOUTH);
            }
        }
        else if(direction == Location.SOUTH)
        {
            //if not yet at correct row
            if(r < ((address & ROW) >>> 4) * 2 + 1)
            {
                move();
            }
            else //if at correct row
            {
                setDirection(Location.EAST);
            }
        }
        else if(direction == Location.NORTH)
        {
            //if not yet at row -1
            if(r > -1)
            {
                move();
            }
            else // if at row -1
            {
                setDirection(Location.WEST);
            }
        }
        else if(direction == Location.WEST)
        {
            move();
        }
        else
        {
            System.err.println("yer bus is on an angle bud");
        }
    }

    /**
     * Sets the bit of nextInstuction.
     * @param b value to set
     * @param p which bit of nextInstuction to set
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        if(b != null) nextInstruction |= b.getInt() << p;
    }

    /**
     * Returns the next instruction for the CPU to execute
     * @return next instruction. 2 bytes.
     */
    public short getNextInstruction()
    {
        return nextInstruction;
    }

//    /**
//     * For testing only
//     */
//    public static void main(String[] args)
//    {
//        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>());
//
//        //set up memory
//        for(int r = 0; r < MemoryBus.MEMORY_R; r++)
//        {
//            for(int c = 0; c < 8 * MemoryBus.MEMORY_C; c++)
//            {
//                world.add(new Location(2*r,(c+1) + c / 8 * 2), new Bit(false));
//            }
//        }
//
//        //set up registers
//        //set up program counter
//        for(int i = 0; i < RegisterBus.PROGRAM_COUNTER_SIZE; i++)
//        {
//            world.add(new Location(-2*RegisterBus.PROGRAM_COUNTER + RegisterBus.START_ROW, -i - 1), new Bit(false));
//        }
//        //set up accumulator
//        for(int i = 0; i < RegisterBus.ACCUMULATOR_SIZE; i++)
//        {
//            world.add(new Location(-2*RegisterBus.ACCUMULATOR + RegisterBus.START_ROW, -i - 1), new Bit(false));
//        }
//
//        world.add(new Location(-2,0),new WriteBus((short)0x0020,(byte)-86));
//        world.add(new Location(-1,0),new FetchInstructionBus((short)0x0020));
//        world.show();
//    }
}
