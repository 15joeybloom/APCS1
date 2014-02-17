
/**
 * Joey Bloom
 * In-class Example 5
 * Introduces how to use an API
 * via TurtleGraphics
 * 
 */

import TurtleGraphics.*;
import java.awt.Color;

public class SimpleDrawing
{
    public static void main(String[] args)
    {
        WiggleRainbowPen pen = new WiggleRainbowPen();
        //System.out.println(pen.toString());
        pen.move(50);
        //System.out.println("--------------------------------");
        //System.out.println(pen.toString());
        pen.turn(270);
        pen.move(50);
        //System.out.println("--------------------------------");
        //System.out.println(pen.toString());
        pen.move(200,200);
        pen.up();
        pen.move(200,0);
        pen.down();
        pen.move(100,0);
        
    }
}
