package q2;

/**
 * @author 151bloomj
 */
public abstract class TaxableItem implements Item
{
    private double taxRate;

    public abstract double getListPrice();

    public TaxableItem(double rate)
    {
        taxRate = rate;
    }

    /**
     * @return the price of the Item including the tax
     */
    @Override
    public double purchasePrice()
    {
        return getListPrice() * (1 + taxRate);
    }
}
