package computer;

/**
 * <p>
 * Subtracts its dat field from a register. Does not
 * check for underflow.
 * </p>
 *
 * <p>
 * Image: -
 * </p>
 *
 * @author Joey Bloom
 */
public class SubtractFromRegisterBus extends RegisterBus
{
    private boolean carry;

    /**
     * Constructs a SubtractFromRegisterBus to add the argument to
     * a register.
     *
     * @param a the register to subtract from
     * @param b byte to subtract
     */
    public SubtractFromRegisterBus(short a, byte b)
    {
        super(a, b);
        carry = false;
    }

    /**
     * Subtracts, from the argument Bit, the corresponding bit in the dat field as
     * indicated by the position argument. Adjusts the private carry field if
     * there should be a carry on the next bit.
     *
     * @param b {@inheritDoc}
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        //subtract carry from previous
        if(carry && !b.flip()) carry = false;
        //subtract bit from dat
        if((dat & (1<<p)) != 0 && b.flip()) carry = true;
    }
}
