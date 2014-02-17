package computer;

import info.gridworld.grid.Location;

/**
 * <p>
 * A MemoryBus is a Bus that accesses memory. It can read from or write to memory
 * or otherwise modify it.
 * </p>
 *
 * @author Joey Bloom
 */
public abstract class MemoryBus extends Bus
{
    protected static final short COL =        0x000F;
    protected static final short ROW =        0x0FF0;

    public static final int MEMORY_C = 16;  //this way the first four bits of the address
                                            //are the column to visit
    public static final int MEMORY_R = (1 << 12) / MEMORY_C;
                                            //this way the middle 8 bits are the row
                                            //to visit
    /**
     * Constructs a MemoryBus to visit a memory address
     * @param a address to visit. Can also include an opcode in the leftmost 4 bits.
     */
    public MemoryBus(short a)
    {
        super(a);
        setDirection(Location.EAST);

    }

    /**
     * Constructs a MemoryBus with a byte to visit a memory address
     * @param a address to visit. Can also include an opcode in the leftmost 4 bits.
     * @param b byte of data (use depends on subclass)
     */
    public MemoryBus(short a, byte b)
    {
        super(a,b);
        setDirection(Location.EAST);
    }

    /**
     * Causes the Bus to step on its quest to visit memory and return to CPU
     * precondition: this Bus began at -1,0 facing Location.EAST and was
     * not modified except through the act method
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
                final int X = c % 10;
                if(X == 0)
                {
                    move();
                }
                else if(X == 9)
                {
                    setDirection(Location.NORTH);
                }
                else
                {
                    processBit(
                        (Bit)getGrid().get(loc.getAdjacentLocation(Location.NORTH)),
                        8-X);
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
}
