package computer;

import java.awt.Color;

/**
 * <p>
 * Leaves the CPU, increments the Program Counter, and returns to the CPU
 * with the address of the next instruction. The address of this next instruction
 * can be accessed by the CPU via nextInstructionAddress().
 * </p>
 *
 * <p>
 * Image: PC++
 * </p>
 *
 * @author Joey Bloom
 */
public class IncrementPCBus extends RegisterBus
{
    private boolean flipNext;
    private short nextInstructionAddress;

    /**
     * Constructs an IncrementPCBus set to visit the
     * Program Counter.
     */
    public IncrementPCBus()
    {
        this(PROGRAM_COUNTER);
    }

    /**
     * Constructs an IncrementPCBus with an opcode. This is
     * really only used when skipping an instruction.
     * @param a address, possibly with an opcode
     */
    public IncrementPCBus(short a)
    {
        super((short)((a&OPCODE)|PROGRAM_COUNTER));
        flipNext = true;
        if(getOpcode() == 0) setColor(Color.black);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        nextInstructionAddress |= b.getInt() << p;
        if(flipNext)
        {
            if(b.flip())//if after flipping b is 1, then do not flip the following bits
            {
                flipNext = false;
            }
        }
    }

    /**
     * Called by the CPU to get the address of the next instruction
     * @return a 12-bit value indicating a memory location.
     */
    public short getNextInstructionAddress()
    {
        return (short)(nextInstructionAddress << 1);
    }


}
