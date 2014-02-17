
import TurtleGraphics.*;
import java.awt.Color;

/**
 *
 * @author Joey Bloom
 */
public class Turtles
{
    public static void main(String[] args)
    {
        SketchPad pad = new SketchPad();
        SketchPadWindow window = new SketchPadWindow(500,500,pad);

//        Pen p = new WiggleRainbowPen(pad,5,60);
        Pen p = new StandardPen(pad);

//        //triangle
//        p.down();
//        p.move(200);
//        p.turn(90);
//        p.move(200);
//        p.turn(135);
//        p.move(200 * Math.sqrt(2));
//        p.up();

//        //dodecagon
//        p.down();
//        for(int i = 0; i < 2200; i++)
//        {
//            p.move(3);
//            p.turn(i * i);
//        }
//        p.up();

//        //barber pole
//        p.down();
//        for(int i = 0; i < 1000; i++)
//        {
//            p.move(10);
//            p.turn(Math.pow(i, 3));
//        }
//        p.up();
//        //for curvy barber pole, add .05 to turn angle

//        //dinner plate
//        p.down();
//        for(int i = 0; i < 12000; i++)
//        {
//            p.move(5);
//            p.turn(Math.pow(i, 4));
//        }
//        p.up();

//        //spiral
//        p.down();
//        for(int i = 200; i < 5000; i++)
//        {
//            p.move(1);
//            p.turn(1000.0 / i);
//        }
//        p.up();

//        //flower hairnet?
//        pad.setBackground(Color.BLACK);
//        p.down();
//        for(double i = 0.0; i < 6 * Math.PI; i += Math.PI / 32)
//        {
//            p.move(50 * Math.sin(i));
//            p.turn(15);
//        }


    }
}