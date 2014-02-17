package q2;

/**
 * @author Joey Bloom
 * 2006 Free Response Question 2
 * A Vehicle has a dealer cost and a markup.
 */
public class Vehicle extends TaxableItem
{
    private double dealerCost;
    private double dealerMarkup;

    public double getDealerCost()
    {
        return dealerCost;
    }

    public double getDealerMarkup()
    {
        return dealerMarkup;
    }

    /**
     * Constructs a Vehicle
     * @param cost
     * @param markup
     * @param taxRate
     */
    public Vehicle(double cost, double markup, double taxRate)
    {
        super(taxRate);
        dealerCost = cost;
        dealerMarkup = markup;
    }

    /**
     * returns the list price of the Vehicle
     * @return cost + markup
     */
    @Override
    public double getListPrice()
    {
        return dealerCost + dealerMarkup;
    }

    /**
     * Sets the Markup
     * @param newMark new markup
     */
    public void changeMarkup(double newMark)
    {
        dealerMarkup = newMark;
    }

    /**
     * Returns information about the Vehicle
     */
    @Override
    public String toString()
    {
        String returnMe = "";
        returnMe += "Cost: " + getDealerCost();
        returnMe += "\nMarkup: " + getDealerMarkup();
        returnMe += "\nList price: " + getListPrice();
        returnMe += "\nPurchase Price: " + (double)(int)purchasePrice();
        return returnMe;
    }
}
