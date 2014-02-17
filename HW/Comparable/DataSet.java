/**
 * @author Joey Bloom
 * Assignment #36
 * analyzes implementations of Measurable
 */
public class DataSet
{
    private Comparable min;
    private Comparable max;
    
    /**
     * adds an item to the DataSet
     * @param x Comparable item
     */
    public void add(Comparable x)
    {
        if(max == null || max.compareTo(x) < 0)
            max = x;
        if(min == null || min.compareTo(x) > 0)
            min = x;
    }
    /**
     * returns the largest item in this DataSet
     * according to the natural ordering of the items
     */
    public Comparable getMaximum()
    {
        return max;
    }
    /**
     * returns the smallest item in this DataSet
     * according to the natural ordering of the items
     */
    public Comparable getMinimum()
    {
        return min;
    }
}