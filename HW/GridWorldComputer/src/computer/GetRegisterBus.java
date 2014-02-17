package computer;

/**
 * <p>
 * Retrieves the value of a register and returns to CPU.
 * </p>
 *
 * <p>
 * Image: G
 * </p>
 *
 * @author Joey Bloom
 */
public class GetRegisterBus extends RegisterBus
{
    /**
     * Constructs a GetRegisterBus to visit a register
     * @param a register to get
     */
    public GetRegisterBus(short a)
    {
        super(a);
    }

    /**
     * Reads a Bit of the accumulator and stores it in the Bus
     * @param b {@inheritDoc}
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        dat |= b.getInt() << p;
    }

    /**
     * Returns the value of the register
     * @return byte read
     */
    public byte get()
    {
        return dat;
    }
}
