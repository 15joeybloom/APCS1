package computer;

/**
 * <p>
 * Adds its dat field to a register. Does not
 * check for overflow.
 * </p>
 *
 * <p>
 * Image: +
 * </p>
 *
 * @author Joey Bloom
 */
public class AddToRegisterBus extends RegisterBus
{
    private boolean carry;

    /**
     * Constructs an AddToRegisterBus to add the argument to
     * a register.
     *
     * @param a the register to add to
     * @param b byte to add
     */
    public AddToRegisterBus(short a, byte b)
    {
        super(a, b);
        carry = false;
    }

    /**
     * Adds, to the argument Bit, the corresponding bit in the dat field as
     * indicated by the position argument. Adjusts the private carry field if
     * there should be a carry on the next bit.
     * @param b {@inheritDoc}
     * @param p {@inheritDoc}
     */
    @Override
    protected void processBit(Bit b, int p)
    {
        //add carry from previous
        if(carry && b.flip()) carry = false;
        //add bit from dat
        if((dat & (1<<p)) != 0 && !b.flip()) carry = true;
    }
}
