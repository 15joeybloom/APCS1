/**
 * @author Joey Bloom
 * Assignment #34
 * analyzes implementations of Measurable
 */
public class DataSet
{
    private double sum;
    private Measurable maximum;
    private int count;
    
    public void add(Measurable x)
    {
        sum += x.getMeasure();
        if(count == 0 || maximum.getMeasure() < x.getMeasure())
            maximum = x;
        count++;
    }
    public Measurable getMaximum()
    {
        return maximum;
    }
    public double getAverage()
    {
        if(count == 0)
            return 0;
        return sum / count;
    }
}