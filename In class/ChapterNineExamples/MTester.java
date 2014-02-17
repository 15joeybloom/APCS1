/**
 * @author Joey Bloom
 * inclass example for chapter 9
 * instantieates a few Measurables, and populates an array of
 * measureables with there 
 * instances
 * demonstaraes polymorphism using a for-each loop
 */
public class MTester
{
    public static void main(String[] args)
    {
        Measureable[] m = new Measureable[4];
        Measureable m0 = new Coin("Quarter", 0.25);
        Measureable m1 = new Coin("Dime", 0.10);
        Measureable m2 = new Circle(10);
        Measureable m3 = new Purse();
        ((Purse)m3).add((Coin)m0);
        ((Purse)m3).add((Coin)m1);
        
        m[0] = m0;
        m[1] = m1;
        m[2] = m2;
        m[3] = m3;
        
        for(Measureable x : m)
        {
            System.out.println("The measure of this object is: " +
                x.getMeasure());
        }
    }
}
