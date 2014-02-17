
/**
 * Joey Bloom
 * Assignment #15
 * An ice cream cone with a radius and a height.
 * Note that the cone does not contain a scoop.
 */

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class IceCreamCone 
{
    private double radius;
    private double height;

    /**
     * No-parameters constructor. Initializes a cone
     * with default value 0 for radius and 0
     * for height. 
     */
    public IceCreamCone()
    {
        this(0,0);    
    }

    /**
     * Parameterized constructor. Initializes a cone
     * with the given radius and height.
     * 
     * @param r The desired radius of the cone.
     * @param h The desired height of the cone.
     */
    public IceCreamCone(double r, double h)
    {
        radius = r;
        height = h;
    }

    /**
     * Returns the radius of the cone.
     * 
     * @return the radius
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * Returns the height of the cone.
     * 
     * @return the height
     */
    public double getHeight()
    {
        return height;    
    }
    
    /**
     * Returns the total surface area of the cone.
     * 
     * @return The surface area of the cone.
     */
    public double getSurfaceArea()
    {
        double slantHeight = Math.sqrt(
            (height * height) + (radius * radius));
        double lateralSurfaceArea = 
            Math.PI * radius * slantHeight;
        return lateralSurfaceArea;
    }

    /**
     * Returns the volume of the cone.
     * 
     * @return The volume of the cone.
     */
    public double getVolume()
    {
        double base = Math.PI * radius * radius;
        return (1.0/3) * base * height;
    }

    /**
     * Returns a String containing the radius,
     * height, surface area, and volume of the cone.
     * 
     * @return The String.
     */
    public String toString()
    {
        return "Radius:\n\t" + radius +
        "\nHeight:\n\t" + height +
        "\nSurface area:\n\t" + getSurfaceArea() +
        "\nVolume:\n\t" + getVolume();
    }
    
    /**
     * Draws a visual representation of this cone using
     * the parameter Graphics2D object.
     * 
     * @param g2 Graphics2D object you would like to draw
     *           the cone with.
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double hole = new Ellipse2D.Double(
            20,20, 2 * radius, 0.25 * radius);
            
        Line2D.Double leftCone = new Line2D.Double(
            hole.getX(), 
            hole.getY() + 0.5 * hole.getHeight(), 
            hole.getX() + 0.5 * hole.getWidth(), 
            hole.getY() + 0.5 * hole.getHeight() + height);
            
        Line2D.Double rightCone = new Line2D.Double(
            hole.getX() + hole.getWidth(),
            hole.getY() + 0.5 * hole.getHeight(), 
            hole.getX() + 0.5 * hole.getWidth(), 
            hole.getY() + 0.5 * hole.getHeight() + height);
        
        g2.draw(hole);
        g2.draw(leftCone);
        g2.draw(rightCone);
    }
}
