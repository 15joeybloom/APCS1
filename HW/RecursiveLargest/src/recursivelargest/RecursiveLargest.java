package recursivelargest;

/**
 * @author 151bloomj
 * Assignment #10a
 * Returns the largest int in an array
 */
public class RecursiveLargest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] dumb = {7,3,17,4,5,6,7,8,9};
        int[] dumb2 = {4};
        System.out.println(largest(dumb));
        System.out.println(largest(dumb2));
    }

    /**
     * @param ns array to search
     * @return largest int
     */
    private static int largest(int[] ns)
    {
        if(ns.length == 1)
        {
            return ns[0];
        }
        int[] stupid = new int[ns.length-1];
        for(int i = 1; i < ns.length; i++)
        {
            stupid[i-1] = ns[i];
        }
        return Math.max(ns[0], largest(stupid));
    }
}
/*
Output:
17
4
 */