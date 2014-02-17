/**
 * @author 151bloomj
 */
public class Customer
{
    private String name;
    private String order;

    public Customer(String n, String o)
    {
        name = n;
        order = o;
    }

    public String getName()
    {
        return name;
    }

    public String getOrder()
    {
        return order;
    }

    @Override
    public String toString()
    {
        return name + " wants to order " + order;
    }

}
