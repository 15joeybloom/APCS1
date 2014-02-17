package q3;

/**
 * @author Joey Bloom
 * 2006 Free Response Question 3
 * Customer has name and ID
 */
public class Customer
{
    private String name;
    private int id;

    /**
     * Constructs a Customer with given name and ID
     */
    public Customer(String name, int idNum)
    {
        this.name = name;
        id = idNum;
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Returns 0 when this customer is equal to other,
     * a positive integer when this customer is greater than other,
     * a negative integer when this customer is less than other
     */
    public int compareCustomer(Customer other)
    {
        int comp = getName().compareTo(other.getName());
        if(comp == 0)
        {
            return getID() - other.getID();
        }
        return comp;
    }
    
    /**
     * Returns a String representing this Customer
     * @return a String
     */
    @Override
    public String toString()
    {
        return getName() + getID();
    }
}
