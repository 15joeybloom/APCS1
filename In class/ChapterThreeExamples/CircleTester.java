
/**
 * Joey Bloom
 * In-class Example (for Assignment #8)
 * Tests the methods of the Circle class.
 */
public class CircleTester
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();
        //System.out.println(c1.getRadius());
        //System.out.println(c1.getCircumference());
        Circle c2 = new Circle(10);
        
        c1.setRadius(5);
        //System.out.println(c1.getRadius());
        //System.out.println(c1.getCircumference());
        System.out.println(c1);
    }
}
