
/**
 * Joey Bloom
 * In-class Example (for Assignment #9)
 * Creates a few Trapezoids, tests out
 * their methods
 */
public class TrapTester
{
    public static void main(String[] args)
    {
        Trapezoid t1 = new Trapezoid();
        System.out.println(t1);
        Trapezoid t2 = new Trapezoid( 20, 40, 5 );
        System.out.println("\n\n" + t2);
        
        t1.setBase(1,20);
        t1.setBase(2,30);
        t1.setHeight(40);
        
        
        
    }
}
