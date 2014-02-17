import java.awt.geom.Point2D;
import TurtleGraphics.*;
/**
 * @author Joey Bloom
 * Assignment #37
 * A Triangle has three verticies anywhere in 2space.
 * It can be drawn, and the area, perimeter, and x
 * and y positions can be calculated. It can be moved
 * and stretched.
 */
public class Triangle implements Shape
{
    private double x1,y1,x2,y2,x3,y3;
    
    /**
     * Constructs a stupid Triange with all three verticies at (0,0)
     */
    public Triangle()
    {
        this(0,0,0,0,0,0);
    }
    /**
     * Constructs a Triangle with verticies (x1,y1),(x2,y2),(x3,y3)
     * @param x1 first x coord
     * @param y1 first y coord
     * @param x2 second x coord
     * @param y2 second y coord
     * @param x3 third x coord
     * @param y3 third y coord
     */
    public Triangle(double x1,double y1,
                    double x2,double y2,
                    double x3,double y3)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    /**
     * Constructs a Triangle with verticies p1,p2,p3
     * @param p1 first vertex
     * @param p2 second vertex
     * @param p3 third vertex
     */
    public Triangle(Point2D.Double p1,Point2D.Double p2,Point2D.Double p3)
    {
        this(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y);
    }
    
    /**
     * Translates the Triangle
     * @param x horizontal translation
     * @param y vertical translation
     */
    public void move(double x, double y)
    {
        x1 += x;
        x2 += x;
        x3 += x;
        y1 += y;
        y2 += y;
        y3 += y;
    }
    /**
     * returns the x coord of the first vertex
     * @return first vertex x
     */
    public double getXPos()
    {
        return x1;
    }
    /**
     * returns the y coord of the first vertex
     * @return first vertex y
     */
    public double getYPos()
    {
        return y1;
    }
    /**
     * Returns the area of this triangle
     * @return area
     */
    public double area()
    {
        return 0.5 * Math.abs(x1 * y2 - x2 * y1 + x2 * y3 - x3 * y2 + x3 * y1 - x1 * y3);
    }
    /**
     * Stretches the Triangle by a factor
     * @param factor factor
     */
    public void stretchBy(double factor)
    {
        x2 = x1 + (x2 - x1) * factor;
        y2 = y1 + (y2 - y1) * factor;
        x3 = x1 + (x3 - x1) * factor;
        y3 = y1 + (y3 - y1) * factor;
    }
    /**
     * Draws the triangle
     * @param p Pen to be used to draw
     */
    public void draw(Pen p)
    {
        p.up();
        p.move(x1,y1);
        p.down();
        p.move(x2,y2);
        p.move(x3,y3);
        p.move(x1,y1);
    }
    /**
     * returns a String representation of the Triangle
     * @return String
     */
    public String toString()
    {
        return "(" + getXPos() + ", " + getYPos() + ")\n" +
               "(" + x2 + ", " + y2 + ")\n" +
               "(" + x3 + ", " + y3 + ")\n" +
               "Area: " + area() +
               "\nPerimeter: " + getPerimeter() + "\n";
    }
    /**
     * returns the perimeter of the Triangle
     * @return perimeter
     */
    public double getPerimeter()
    {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) +
               Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2)) +
               Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
    }
}
