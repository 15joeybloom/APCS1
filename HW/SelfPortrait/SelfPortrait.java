/**
 * Joey Bloom
 * Assignment #4
 * Draws a face
 */

import TurtleGraphics.StandardPen;
import java.awt.Color;

public class SelfPortrait
{
    public static void main(String[] args)
    {
        StandardPen pen = new StandardPen();
        pen.setColor(Color.red);
        pen.setDirection(0);        
        double[] turnNum =
            { 2, 4, 4 };
        double[] moveNum =
            { 5, 1, 1 };
        double[] x =
            { 0, 50, -50 };
        double[] y =
            { 0, 200, 200 };
        int i;
        for(int j = 0 ; j <= 2 ; j++ )
        {
            pen.up();
            pen.move(x[j], y[j]);
            pen.down();
            pen.setDirection(0);
            i = 0;
            while ( i <= (360/turnNum[j]))
            {
                i++;
                pen.turn(turnNum[j]);
                pen.move(moveNum[j]);
            }
        }
        
        //nose
        pen.up();
        pen.move(0,150);
        pen.down();
        pen.move(-10,150);
        pen.move(0,170);
        
        //mouth
        pen.up();
        pen.move(0,75);
        pen.down();
        pen.setDirection(0);
        for(i=0 ; i<=45 ; i++ )
        {
            pen.turn(1);
            pen.move(2);
        }
        
        //torso
        pen.home();
        pen.setDirection(-90);
        pen.move(10);
        
        //left leg
        pen.turn(-30);
        pen.move(10);
        pen.move(-10);
        
        //right leg
        pen.turn(60);
        pen.move(10);
        
        //left arm
        pen.up();
        pen.move(0,-5);
        pen.down();
        pen.setDirection(220);
        pen.move(4);
        pen.move(-4);
        
        //right arm
        pen.setDirection(-40);
        pen.move(4);
        //System.out.println(pen.toString());
    }    
}