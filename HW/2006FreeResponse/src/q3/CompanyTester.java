package q3;

/**
 * @author Joey Bloom
 */
public class CompanyTester 
{
    public static void main(String[] args) 
    {
        Customer[] list1 = 
        {
            new Customer("Arthur",4920),
            new Customer("Burton",3911),
            new Customer("Burton",4944),
            new Customer("Franz",1692),
            new Customer("Horton",9221),
            new Customer("Jones",5554),
            new Customer("Miller",9360),
            new Customer("Nguyen",4339),
        };
        Customer[] list2 =
        {
            new Customer("Aaron",1729),
            new Customer("Baker",2921),
            new Customer("Burton",3911),
            new Customer("Dillard",6552),
            new Customer("Jones",5554),
            new Customer("Miller",9360),
            new Customer("Noble",3335),
        };
        Customer[] result = new Customer[6];
        Company.prefexMerge(list1, list2, result);
        for(Customer c : result)
        {
            System.out.println(c);
        }
    }
}
