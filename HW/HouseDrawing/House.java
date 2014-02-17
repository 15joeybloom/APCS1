
/*
 * Joey Bloom
 * In-class Example (for Assignment #13)
 * A car shape that can be positioned
 * anywhere on the screen.
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Polygon;

public class House
{
    private int xLeft;
    private int yTop;
    
    public House(int x , int y )
    {
        xLeft = x;
        yTop = y + 55;
    }
    public House()
    {
        this(0,0);
    }
    
    public void draw(Graphics2D g2)
    {
        //h = house 
        //w = window

        Rectangle h1 =
            new Rectangle(xLeft + 50, yTop + 40, 
                           60, 30);

        Window w1 = new Window(xLeft + 60, yTop + 50, 1);
        Window w2 = new Window(xLeft + 90, yTop + 40, 1);
        Window w3 = new Window(xLeft + 65, yTop + 25, 2);
        
        Line2D.Double roofLeft =
            new Line2D.Double(xLeft + 40, yTop + 40, 
                              xLeft + 70, yTop + 10);                      
        Line2D.Double roofMidLeft =
            new Line2D.Double(xLeft + 70, yTop + 10, 
                              xLeft + 90, yTop + 30);
        Line2D.Double roofMidRight =
            new Line2D.Double(xLeft + 90, yTop + 30, 
                              xLeft + 100, yTop + 20);                      
        Line2D.Double roofRight =
            new Line2D.Double(xLeft + 100, yTop + 20, 
                              xLeft + 120, yTop + 40);                      
        Line2D.Double roofBottom =
            new Line2D.Double(xLeft + 120, yTop + 40, 
                              xLeft + 40, yTop + 40);
                              
        Line2D.Double chimneyLeft =
            new Line2D.Double(xLeft + 50, yTop + 30, 
                              xLeft + 50, yTop + 0);                      
        Line2D.Double chimneyTop =
            new Line2D.Double(xLeft + 50, yTop + 0, 
                              xLeft + 60, yTop + 0);                      
        Line2D.Double chimneyRight =
            new Line2D.Double(xLeft + 60, yTop + 0, 
                              xLeft + 60, yTop + 20);
                              
        Line2D.Double doorBottomLeft =
            new Line2D.Double(xLeft + 90, yTop + 70, 
                              xLeft + 80, yTop + 60);
        Line2D.Double doorTopLeft =
            new Line2D.Double(xLeft + 80, yTop + 60, 
                              xLeft + 90, yTop + 50);
        Line2D.Double doorTopRight =
            new Line2D.Double(xLeft + 90, yTop + 50, 
                              xLeft + 110, yTop + 70);
        Ellipse2D.Double doorknob = new Ellipse2D.Double(
            xLeft + 95, yTop + 60,
            5, 5);
                                 
        Rectangle h2 =
            new Rectangle(xLeft + 10, yTop + 20, 
                          20 , 20);
        Window h2w1 = new Window(xLeft + 15, yTop + 25, 1);
        Window h2w2 = new Window(xLeft + 10, yTop + 10,
                                 5,5,2);
                                 
        Line2D.Double leftArmBottom =
            new Line2D.Double(xLeft + 50, yTop + 60, 
                              xLeft + 20, yTop + 60);
        Line2D.Double leftArmLeft =
            new Line2D.Double(xLeft + 20, yTop + 60, 
                              xLeft + 20, yTop + 40);                      
        Line2D.Double leftArmTop =
            new Line2D.Double(xLeft + 50, yTop + 50, 
                              xLeft + 30, yTop + 50);                      
        Line2D.Double leftArmRight =
            new Line2D.Double(xLeft + 30, yTop + 50, 
                              xLeft + 30, yTop + 40);
                              
        Line2D.Double h2RoofLeft =
            new Line2D.Double(xLeft + 0, yTop + 20, 
                              xLeft + 20, yTop + 0 );                      
        Line2D.Double h2RoofRight =
            new Line2D.Double(xLeft + 20, yTop + 0, 
                              xLeft + 40, yTop + 20 );                      
        Line2D.Double h2RoofBottom =
            new Line2D.Double(xLeft + 40, yTop + 20, 
                              xLeft + 0, yTop + 20 );
                              
                              
        g2.draw(h1);
        w1.draw(g2);
        w2.draw(g2);
        w3.draw(g2);
        g2.draw(roofLeft);
        g2.draw(roofMidLeft);
        g2.draw(roofMidRight);
        g2.draw(roofRight);
        g2.draw(roofBottom);
        g2.draw(doorBottomLeft);
        g2.draw(doorTopLeft);
        g2.draw(doorTopRight);
        g2.draw(doorknob);
        g2.draw(chimneyLeft);
        g2.draw(chimneyTop);
        g2.draw(chimneyRight);
        g2.draw(h2);
        h2w1.draw(g2);
        h2w2.draw(g2);
        g2.draw(leftArmBottom);
        g2.draw(leftArmLeft);
        g2.draw(leftArmTop);
        g2.draw(leftArmRight);
        g2.draw(h2RoofLeft);
        g2.draw(h2RoofRight);
        g2.draw(h2RoofBottom);
        
        int[] rightArmX =
            { xLeft + 110, xLeft + 130, xLeft + 130, xLeft + 140, 
              xLeft + 140, xLeft + 150, xLeft + 150, xLeft + 110};
        int[] rightArmY =
            { yTop + 50, yTop + 50, yTop + 40, yTop + 40, 
              yTop + 30, yTop + 30, yTop + 60, yTop + 60};
        Polygon rightArm = new Polygon(rightArmX,rightArmY,8);
        Rectangle h3 =
            new Rectangle(xLeft + 130, yTop - 30,
                          30, 60);
        int[] h3RoofX = 
            {xLeft + 120, 
             xLeft + 145, 
             xLeft + 170};
        int[] h3RoofY = {yTop - 30,
                         yTop - 55,
                         yTop - 30};
        Polygon h3Roof = new Polygon( h3RoofX, h3RoofY, 3);
        Ellipse2D.Double clock = new Ellipse2D.Double(
            xLeft + 135, yTop - 25, 20, 20);
        Line2D.Double minuteHand = new Line2D.Double(
            xLeft + 145, yTop - 15,
            xLeft + 150, yTop - 20);
        Line2D.Double hourHand = new Line2D.Double(
            xLeft + 145, yTop - 15,
            xLeft + 145, yTop - 10);
        
        g2.draw(rightArm);
        g2.draw(h3);
        g2.draw(h3Roof);
        g2.draw(clock);
        g2.draw(minuteHand);
        g2.draw(hourHand);
    }
    
    public void setCorner(int x, int y)
    {
        xLeft = x;
        yTop = y;
    }
}
