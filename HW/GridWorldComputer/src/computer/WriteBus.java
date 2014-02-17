package computer;

/**
 * <p>
 * A WriteBus writes a byte to memory at a specified address.
 * </p>
 *
 * <p>
 * Image: W
 * </p>
 *
 * @author Joey Bloom
 */
public class WriteBus extends MemoryBus
{
    /**
     * Constructs a WriteBus with an address and a byte to write
     * @param a address
     * @param b byte to write
     */
    public WriteBus(short a, byte b)
    {
        super(a,b);
    }

    /**
     * Sets the Bit of memory to the corresponding bit of this WriteBus's field
     * @param b Bit to set
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        b.set(dat & (1 << p));//will be a power of two or 0. power of two
                              //means the bit is on, 0 means off.
    }
}
