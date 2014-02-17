package computer;

import info.gridworld.actor.Rock;
import java.awt.Color;

/**
 * <p>
 * A Bit is an Actor that represents a bit of memory. It is read
 * and written to by a Bus. 0 represents the off state or false, 1 represents
 * the on state or true.
 * </p>
 *
 * @author Joey Bloom
 */
public class Bit extends Rock
{
    private boolean val;

    /**
     * Constructs a new Bit, which will be in the
     * off state iff !v
     * @param v
     */
    public Bit(boolean v)
    {
        this.val = v;
        updateColor();
    }

    /**
     * Constructs a new Bit, which will be in the
     * off state iff v == 0
     * @param v
     */
    public Bit(int v)
    {
        val = v != 0;
        updateColor();
    }

    /**
     * Updates the Color of the Bit. Green iff val, Red iff !val.
     * Called each time val may have changed.
     */
    private void updateColor()
    {
        setColor(val ? Color.GREEN : Color.RED);
    }

    /**
     * Flips the Bit. If the Bit is currently on, then sets it to off.
     * If the Bit is currently off, then sets it to on.
     * @return the value after flipping
     */
    public boolean flip()
    {
        val = !val;
        updateColor();
        return val;
    }

    /**
     * Sets the Bit to on iff v, else sets the Bit to off.
     * @param v desired state
     */
    public void set(boolean v)
    {
        val = v;
        updateColor();
    }

    /**
     * Sets the Bit to off iff v == 0, else sets the Bit to on.
     * @param v 0 iff desired state is false
     */
    public void set(int v)
    {
        val = v != 0;
        updateColor();
    }

    /**
     * @return the current state of the Bit
     */
    public boolean get()
    {
        return val;
    }

//    /**
//     * For silly tests only
//     */
//    public void act()
//    {
//        flip();
//    }

    /**
     * Returns 1 if this Bit is on or 0 if this Bit is off
     * @return 1 or 0
     */
    public int getInt()
    {
        return val ? 1 : 0;
    }
}
