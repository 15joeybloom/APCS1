package computer;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/**
 * <p>
 * A RegisterBus is a Bus that visits one of the CPU's registers.
 * </p>
 *
 * @author Joey Bloom
 */
public abstract class RegisterBus extends Bus
{
    /**
     * Memory addresses are 12 bits in this computer, however the least significant
     * bit of the PC will always be 0 because instructions are always stored
     * in even addresses because they are 2 bytes. Therefore only the 11 most
     * significant bits need to be stored.
     */
    public static final int PROGRAM_COUNTER_SIZE = 11;

    /**
     * this register is used as temporary storage by the CPU. one byte.
     */
    public static final int ACCUMULATOR_SIZE = 8;

    /**
     * This first register is in this row
     */
    public static final int START_ROW = -2;
    /**
     * This is the column in which RegisterBuses turn South.
     * Equal to 1 + largest register size
     */
    public static final int RETURN_COL = -12;

    /**
     * Address of program counter
     */
    public static final short PROGRAM_COUNTER = 0;
    /**
     * Address of accumulator
     */
    public static final short ACCUMULATOR = 1;

    /**
     * Constructs a RegisterBus with an address
     * @param a address
     */
    public RegisterBus(short a)
    {
        super(a);
        setDirection(Location.NORTH);
    }

    /**
     * Constructs a RegisterBus with an address
     * and a byte
     * @param a address
     * @param b byte
     */
    public RegisterBus(short a, byte b)
    {
        super(a,b);
        setDirection(Location.NORTH);
    }

    /**
     * A RegisterBus visits the register indicated by the address
     */
    @Override
    public void act()
    {
        Location loc = getLocation();
        int r = loc.getRow();
        int c = loc.getCol();
        int dir = getDirection();
        if(dir == Location.NORTH)
        {
            if(r - START_ROW + 1 > -2*(address & ADDRESS))
            {
                move();
            }
            else
            {
                setDirection(Location.WEST);
            }
        }
        else if(dir == Location.WEST)
        {
            if(c <= RETURN_COL)
            {
                setDirection(Location.SOUTH);
            }
            else
            {
                Bit b = null;
                Actor a = getGrid().get(loc.getAdjacentLocation(Location.SOUTH));
                if(a instanceof Bit) b = (Bit)a;
                if(b != null)
                {
                    processBit(b,-c-1);
                }
                move();
            }
        }
        else if(dir == Location.SOUTH)
        {
            if(r == -1)
            {
                setDirection(Location.EAST);
            }
            else
            {
                move();
            }
        }
        else if(dir == Location.EAST)
        {
            move();
        }
        else
        {
            System.err.println("yer bus is on an angle bud");
        }
    }
}
