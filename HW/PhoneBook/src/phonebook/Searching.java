package phonebook;

import java.util.List;

/**
 * @author Joey Bloom
 * Assignment #15
 * Utility methods for searching
 */
public class Searching
{
    /**
     * Searches for the target element in the list
     * @param <T> Comparable type to search
     * @param list list to search
     * precondition: list is sorted
     * @param target element to search for
     * @return returns the index of an arbitrary instance of target in list, -1 if not found
     */
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target)
    {
        int min = 0;
        int max = list.size();
        int toSearch;
        while(true)
        {
            if(min + 1 == max)
            {
                return -1;
            }
            toSearch = (max + min) / 2;
            int c = target.compareTo(list.get(toSearch));
            if(c == 0)
            {
                return toSearch;
            }
            else if(c < 0)
            {
                max = toSearch;
            }
            else
            {
                min = toSearch;
            }
        }
    }
}
