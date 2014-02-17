package q3;

/**
 * @author Joey Bloom
 * 2006 Free Response Question 3
 */
public class Company 
{   
    public static void prefexMerge(Customer[] list1, Customer[] list2, Customer[] result)
    {
        int i1 = 0;
        int i2 = 0;
        Customer c1 = list1[i1];
        Customer c2 = list2[i2];
        for(int i = 0; i < result.length; i++)
        {
            int x = c1.compareCustomer(c2);
            if(x < 0)
            {
                result[i] = c1;
                c1 = list1[++i1];
            }
            else if(x > 0)
            {
                result[i] = c2;
                c2 = list2[++i2];
            }
            else
            {
                result[i] = c1;
                c1 = list1[++i1];
                c2 = list2[++i2];
            }
        }
    }
}
