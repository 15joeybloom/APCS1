package reviewforq3test;

/**
 * @author 151bloomj
 */
public class RecursionPractice
{
    public static void main(String[] args)
    {
        int x = product(8);
        System.out.println(x);
    }

    private static int product(int n)
    {
        if(n <= 1)
            return 1;
        else
            return n * product(n-3);
    }
}
