import java.awt.geom.Point2D;
import TurtleGraphics.*;
import java.awt.Color;
/**
 * @author Joey Bloom
 * Assignment #37
 * Tests the Triangle class
 */
public class TriangleTester
{
    public static void main(String[] args)
    {
        Shape s1 = new Triangle(0,0,0,30,40,0);
        Shape s2 = new Triangle(
                        new Point2D.Double(100,50),
                        new Point2D.Double(180,50),
                        new Point2D.Double(180,200));
        Shape s3 = new Triangle(-100,-100,-50,-50,-100,-50);
        Shape[] s = {s1,s2,s3};
        for(Shape name : s)
        {
            System.out.println("Original: " );
            System.out.println(name);
            Pen p = new StandardPen();
            p.setColor(Color.blue);
            name.draw(p);
            
            name.stretchBy(2);
            p.setColor(Color.green);
            name.draw(p);
            System.out.println("After stretch by 2: ");
            System.out.println(name);
            
            name.move(50,-30);
            p.setColor(Color.red);
            name.draw(p);
            System.out.println("After shift: ");
            System.out.println(name);
            System.out.println();
        }
    }
}
/*
Output:
Original: 
(0.0, 0.0)
(0.0, 30.0)
(40.0, 0.0)
Area: 600.0
Perimeter: 120.0

After stretch by 2: 
(0.0, 0.0)
(0.0, 60.0)
(80.0, 0.0)
Area: 2400.0
Perimeter: 240.0

After shift: 
(50.0, -30.0)
(50.0, 30.0)
(130.0, -30.0)
Area: 2400.0
Perimeter: 240.0


Original: 
(100.0, 50.0)
(180.0, 50.0)
(180.0, 200.0)
Area: 6000.0
Perimeter: 400.0

After stretch by 2: 
(100.0, 50.0)
(260.0, 50.0)
(260.0, 350.0)
Area: 24000.0
Perimeter: 800.0

After shift: 
(150.0, 20.0)
(310.0, 20.0)
(310.0, 320.0)
Area: 24000.0
Perimeter: 800.0


Original: 
(-100.0, -100.0)
(-50.0, -50.0)
(-100.0, -50.0)
Area: 1250.0
Perimeter: 170.71067811865476

After stretch by 2: 
(-100.0, -100.0)
(0.0, 0.0)
(-100.0, 0.0)
Area: 5000.0
Perimeter: 341.4213562373095

After shift: 
(-50.0, -130.0)
(50.0, -30.0)
(-50.0, -30.0)
Area: 5000.0
Perimeter: 341.4213562373095
 */