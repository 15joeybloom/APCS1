/**
 * Joey Bloom
 * Assignment #4
 * Prompts User for which of three faces
 * he would like to see, then displays
 * selected face.
 */

import TurtleGraphics.StandardPen;
import java.awt.Color;
import java.util.*;

public class SelfPortraitUserPrompt
{
    public static void main(String[] args)
    {
        StandardPen pen = new StandardPen();
        Scanner in = new Scanner(System.in);
        System.out.println("Hello.");
        System.out.println("Who would you like to meet?");
        System.out.println("A: HerpDerp");
        System.out.println("B: BoxMan a.k.a. SirFancyHat " +
            "a.k.a. LongLegJones");
        System.out.println("C: Chompy");
        System.out.println("Type a letter here!");
        String whichFace =
            in.nextLine();
        
        switch (whichFace)
        {
        case "A":
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
            break;
        case "B":
            pen.setColor(Color.blue);
            //head
            pen.move(100,0);
            pen.move(100,200);
            pen.move(-100,200);
            pen.move(-100,0);
            pen.move(0,0);
            //torso and limbs
            pen.move(0,-50);
            pen.move(-150,-50);
            pen.move(150,-50);
            pen.move(0,-50);
            pen.move(0,-100);
            pen.setDirection(-120);
            pen.move(200);
            pen.move(-200);
            pen.setDirection(-60);
            pen.move(200);
            //hat
            pen.up();
            pen.move(90,210);
            pen.down();
            pen.move(110,190);
            pen.move(105,195);
            pen.move(115,205);
            pen.move(105,215);
            pen.move(95,205);
            
            break;
        case "C":
            pen.setColor(Color.green);
            for ( int k=0; k<=360 ; k = k + 5 )
            {
                pen.move(3);
                pen.turn(5);
                
                if (k==150)
                {
                    pen.up();
                }
                if (k==210)
                {
                    pen.down();
                }
            }
            pen.up();
            pen.move(-64,17);
            pen.down();
            pen.move(-35,0);
            pen.move(-64,-17);
            pen.up();
            pen.move(-40,10);
            pen.down();
            pen.setDirection(10);
            for(int k=0; k<=360 ; k = k + 10)
            {
                pen.move(1);
                pen.turn(10);
            }
            break;
        default:
            System.out.println("You have entered " + 
                "incorrectly. Try again!");
            break;
        }
    }    
}