
/**
 * Joey Bloom
 * In-class Example (for Assignment #9)
 * A Blueprint for building instances of
 * the Trapezoid class.
 */
public class Trapezoid
{
    private double baseOne,baseTwo,height;
    
    /**
     * Default constructor. Default values are base one is 10, base 2 is 20, and height is 10.
     */
   
    public Trapezoid()
    {
        baseOne = 10;
        baseTwo = 20;
        height = 10;
    }
   
    /**
     * Constructs a trapezoid with base one b1, base two b2, and height h.
     * 
     * @param b1 base one
     * @param b2 base two
     * @param h height
     */
   
    public Trapezoid( double b1, double b2, double h)
    {
        baseOne = b1;
        baseTwo = b2;
        height = h;
    }
   
    /**
     * Sets the length of base 1 to b1.
     * 
     * @param b1 the new length of base1
     */
   
    public void setBaseOne(double b1)
    {
       baseOne = b1;
    }
    
    public void setBaseTwo(double b2)
    {
        baseTwo = b2;
    }
    
    //or...
    
    public void setBase( int baseNumber, double value )
    {
        if (baseNumber == 1)
        {
            baseOne = value;            
        }
        else if (baseNumber == 2)
        {
            baseTwo = value;
        }
    }
    
    public void setHeight(double h)
    {
        height = h;
    }
    
    public double getBaseOne()
    {
        return baseOne;
    }
    
    public double getBaseTwo()
    {
        return baseTwo;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    public double getArea()
    {
        //the average of the bases times the height
        double area = ( ( baseOne + baseTwo ) / 2.0 ) * height;
        return area;
    }
    
    public String toString()
    {
        return       "Base one value is: " + getBaseOne() +
                     "\nBase two value is: " + getBaseTwo() +
                     "\nHeight value is: " + getHeight() +
                     "\nArea value is: " + getArea();
        
    }
}
