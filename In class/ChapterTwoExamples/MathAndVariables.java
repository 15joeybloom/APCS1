
/**
 * Joey Bloom
 * In-cass Example (for Assignment #6)
 * Introduces smoe basic rules for
 * variables and accessing the Math methods
 */
public class MathAndVariables
{
    public static void main(String[] args)
    {
        double valueOfPi = Math.PI;
        double circumference = valueOfPi * 6;
        
        System.out.println(valueOfPi);
        System.out.println(
            "Circumference of circle w/ diameter 6: " +
            circumference);
        System.out.println(Math.abs(-10));
        System.out.println(Math.pow(2,3));
    }
}
