package computer;

/**
 * <p>
 * Reads a byte from memory. Returns to the CPU with that byte.
 * The CPU usually uses that byte to modify a register or
 * another part of memory.
 * </p>
 *
 * <p>
 * Image: R
 * </p>
 *
 * @author Joey Bloom
 */
public class ReadBus extends MemoryBus
{
    /**
     * Constructs a ReadBus to read from the specified address
     * @param a address to read from
     */
    public ReadBus(short a)
    {
        super(a);
    }

    /**
     * Reads a Bit of memory and stores it in the Bus
     * @param b {@inheritDoc}
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        dat |= b.getInt() << p;
    }

    /**
     * Returns the byte read by this ReadBus
     * @return byte read from address
     */
    public byte get()
    {
        return dat;
    }
}
