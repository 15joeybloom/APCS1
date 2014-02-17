package q3;

/**
 * @author 151bloomj
 */
public class CustomerTester
{
    public static void main(String[] args)
    {
        Customer c1 = new Customer("Smith", 1001);
        Customer c2 = new Customer("Anderson", 1002);
        Customer c3 = new Customer("Smith", 1003);

        System.out.println(c1.compareCustomer(c1));
        System.out.println(c1.compareCustomer(c2));
        System.out.println(c1.compareCustomer(c3));        
    }
}
