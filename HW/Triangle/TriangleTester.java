
/**
 * Joey Bloom
 * Assignment #8
 * Tests the methods of the Triangle class.
 */

import TurtleGraphics.*;
import java.awt.Color;
public class TriangleTester
{
    public static void main(String[] args)
    {
        StandardPen pen1 = new StandardPen();
        StandardPen pen2 = new StandardPen();
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(-60,80);
        
        System.out.println("t1\n" + t1);
        System.out.println("t2\n" + t2);
        t1.drawTriangle(pen1);
        t2.drawTriangle(pen1);
        
        t1.setBase(3.0);
        t1.setHeight(3.0);
        t1.setColor(Color.RED);
        t2.setColor(Color.GREEN);
        
        System.out.println(
            "\n\nt1 after transformation and color change\n" + t1);
        System.out.println(
            "t2 after color change\n" + t2);
        t1.drawTriangle(pen2);
        t2.drawTriangle(pen2);
        
        
    }       
}

/*

t1
The base of your Triangle: 100.0
The height of your Triangle: 100.0
The area of your Triangle: 5000.0
The length of the hypotenuse of your Triangle: 141.4213562373095
t2
The base of your Triangle: -60.0
The height of your Triangle: 80.0
The area of your Triangle: 2400.0
The length of the hypotenuse of your Triangle: 100.0


t1 after transformation and color change
The base of your Triangle: 3.0
The height of your Triangle: 3.0
The area of your Triangle: 4.5
The length of the hypotenuse of your Triangle: 4.242640687119285
t2 after color change
The base of your Triangle: -60.0
The height of your Triangle: 80.0
The area of your Triangle: 2400.0
The length of the hypotenuse of your Triangle: 100.0

 */
