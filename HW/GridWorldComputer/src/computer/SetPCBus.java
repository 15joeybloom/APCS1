package computer;

/**
 * <p>
 * Sets the Program Counter. Used in initializing the
 * CPU and jumping/branching.
 * </p>
 *
 * <p>
 * Image: J
 *        (as in JUMP)
 * </p>
 *
 * @author Joey Bloom
 */
public class SetPCBus extends RegisterBus
{
    private short nextInstructionAddress;

    /**
     * Constructs a SetPCBus.
     * @param toSet memory address to set the PC to. Must be even.
     */
    public SetPCBus(short toSet)
    {
        super(PROGRAM_COUNTER);
        nextInstructionAddress = toSet;
    }

    /**
     * Sets the Bit to the corresponding Bit of the nextAddress
     * @param b {@inheritDoc}
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        b.set((nextInstructionAddress & (1 << ++p)) >>> p);
    }
}
