package computer;

/**
 * <p>
 * Takes a numeric value and sets a register to that value
 * </p>
 *
 * <p>
 * Image: S
 * </p>
 *
 * @author Joey Bloom
 */
public class SetRegisterBus extends RegisterBus
{
    /**
     * Constructs a SetRegisterBus to set a register to
     * a value
     * @param a register to set to
     * @param b value to set
     */
    public SetRegisterBus(short a, byte b)
    {
        super(a, b);
    }

    /**
     * Sets the Bit of the accumulator to the value of the dat field
     * @param b accumulator Bit
     * @param p {@inheritDoc }
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        b.set(dat & (1 << p)); //will be a power of two or 0. power of two
                               //means the bit is on, 0 means off.
    }
}
