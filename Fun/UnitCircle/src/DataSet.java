/**
 * @author Joey Bloom
 * Assignment #34
 * analyzes ints
 */
public class DataSet
{
    private int sum;
    private int maximum;
    private int minimum;
    private int count;

    public void add(int x)
    {
        sum += x;
        if(count == 0 || maximum < x)
            maximum = x;
        if(count == 0 || minimum > x)
            minimum = x;
        count++;
    }
    public int getMaximum()
    {
        return maximum;
    }
    public int getMinimum()
    {
        return minimum;
    }
    public int getSum()
    {
        return sum;
    }
    public int getAverage()
    {
        if(count == 0)
            return 0;
        return (int) sum / count;
    }
}