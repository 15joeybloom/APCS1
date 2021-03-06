package computer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * <p>
 * The Bus is a sort of worker that communicates between CPU and memory.
 * It has a short representing its instruction. The short
 * contains the 12-bit memory address and a 4-bit instruction
 * of what to do at that address.
 * </p>
 *
 * <p>
 * This is the superclass for all Actors generated by the CPU that access
 * Bits.
 * </p>
 *
 * <p>
 * Image: School Bus
 * </p>
 * 
 * @author Joey Bloom
 */
public abstract class Bus extends Bug
{
    protected final short address;
    protected byte dat;

    //bit masks
    protected static final short OPCODE = -4096;//same CPU.OPCODE
    protected static final short ADDRESS = 0x0fff;

    private static final Color[] OPCODE_COLORS =
    {
        Color.blue,
        Color.gray,
        Color.magenta,
        Color.green,
        Color.red,
        Color.orange,
        new Color(0xfbf400),//yellowish
        null,
    };

    /**
     * Constructs a Bus set to visit the specified memory address
     * @param a address to visit
     */
    public Bus(short a)
    {
        super();
        address = a;
        dat = 0;
        setColor(OPCODE_COLORS[getOpcode() >>> 12]);
    }

    /**
     * Constructs a Bus set to visit the specified memory address
     * with the specified byte to use at that address
     * @param a address to visit
     * @param b byte to use
     */
    public Bus(short a, byte b)
    {
        this(a);
        dat = b;
    }

    /**
     * This part of the Bus class is where the operation specific
     * to the subtype of Bus takes place.
     * @param b a reference to the Bit being visited
     * @param p the number of the Bit being visited. 7 is the most significant
     *          bit or furthest left, 0 is the least significant or furthest right.
     */
    protected abstract void processBit(Bit b, int p);

    /**
     * Moves the bug forward
     */
    @Override
    public final void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    /**
     * CPU uses this to figure out what opcode this Bus is a part of
     * @return opcode for this Bus
     */
    public short getOpcode()
    {
        return (short)(address & OPCODE);
    }

}
