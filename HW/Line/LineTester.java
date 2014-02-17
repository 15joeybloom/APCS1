/**
 * @author Joey Bloom
 * Extra Credit Assignment
 * Tests the Line class
 */
public class LineTester
{
    public static void main(String[] args)
    {
        Line twoxPlus1 = new Line("y = 2x + 1");
        Line twoxMinus1 = new Line(3,5,2);
        Line yEquals0 = new Line("y=0x+0");
        Line yEquals3 = new Line(0,3,Math.PI,3);
        Line xEquals0 = new Line(0);
        Line xEqualsNegative3 = new Line(-3);
        
        System.out.println(twoxPlus1);
        System.out.println(twoxMinus1);
        System.out.println(yEquals0);
        System.out.println(yEquals3);
        System.out.println(xEquals0);
        System.out.println(xEqualsNegative3);
        
        System.out.println("These are all true: ");
        System.out.println(twoxPlus1.isParallel(twoxMinus1));
        System.out.println(twoxMinus1.intersects(yEquals3));
        System.out.println(xEquals0.equals(xEquals0));
        System.out.println(xEquals0.intersects(yEquals0));
        System.out.println(twoxPlus1.intersects(twoxPlus1));
        System.out.println(
            xEqualsNegative3.intersects(xEqualsNegative3));
            
        System.out.println("These are all false: ");
        System.out.println(
            xEqualsNegative3.isParallel(yEquals0));
        System.out.println(yEquals0.equals(yEquals3));
        System.out.println(yEquals3.intersects(yEquals0));
        System.out.println(
            xEqualsNegative3.isParallel(twoxMinus1));
    }
}
/*
Output:
y= 2.0x + 1.0
y= 2.0x - 1.0
y= 0.0
y= 3.0
x= 0.0
x= -3.0
These are all true: 
true
true
true
true
true
true
These are all false: 
false
false
false
false

 */