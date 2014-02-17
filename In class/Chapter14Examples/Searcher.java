/**
 * @author Joey Bloom
 * In-class Example: Intro to searching/sorting
 * Searches a data structure for first instance of an int;
 * returns the location of that instance or -1 if not found
 */
public class Searcher extends Object
{
    public static void main(String[] args)
    {
        int[] x = {37,22,5,17,10,14,2,32,5,17,17,73,31,8,666,27,8,1538,84,1};
        int location = linearSearch(x,17);
    }
    
    /**
     * Searches for a target int in a list of ints, and returns the first index at which the target
     * is found
     * @param target int to search for
     * @return first index of target, -1 if not found
     */
    public static int linearSearch(int[] list, int target)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    //TRAVERSE A PHONEBOOK LEXICOGRAPHICALLY
}
