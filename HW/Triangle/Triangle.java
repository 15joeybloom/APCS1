/**
 * Joey Bloom
 * Assignment #8
 * A Triangle has a base, a height, and a color,
 * with methods supplied for calculating the area
 * and drawing the triangle using TurtleGraphics
 */

import TurtleGraphics.*;
import java.awt.Color;

public class Triangle
{
    //when defining classes, no main() method...
    
    //PART I: INSTANCE VARIABLES
    private double base, height;
    Color color;
    
    //PART II: CONSTRUCTORS
    //no-parameters constructor
    public Triangle()
    {
        base = 100;
        height = 100;
    }
    
    public Triangle(double b, double h)
    {
        this.base = b;
        this.height = h;
    }
    
    //PART III: MUTATORS (A.K.A. "SET" METHODS)
    
    public void setBase(double b)
    {
        base = b;
    }
    
    public void setHeight(double h)
    {
        height = h;
    }
    
    public void setColor(Color c)
    {
        this.color = c;
    }
    
    //PART IV: ACCESSORS (A.K.A. "GET" METHODS)
    
    public double getBase()
    {
        return base;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    //PART V: OTHER MISCELLANEOUS METHODS
    //(USUALLY THEY DO SOME SORT OF CALCULATION ON A VARIABLE
    // OR SOME OTHER ACTION ON A VARIABLE)
        
    public double getArea()
    {
        return Math.abs(base * height * 0.5);
    }
    
    /**
     * Returns the length of the hypotenuse of the
     * Triangle using the Pythagorean Theorem.
     * 
     * @return The length of the hypotenuse
     */
    public double getHypotenuse()
    {
        return Math.sqrt((base * base) + (height * height));
    }
    
    public void drawTriangle(Pen p)
    {
        p.setColor(color);
        p.down();
        p.move(base, 0);
        p.move(base,height);
        p.move(0,0);
    }
    
    //PART VI: toString()
    //prepares all the relevant information about an instance
    //in the form of a String
    public String toString()
    {
        String str = "The base of your Triangle: " + this.getBase() +
                     "\nThe height of your Triangle: " + this.getHeight() +
                     "\nThe area of your Triangle: " + this.getArea() +
                     "\nThe length of the hypotenuse of your Triangle: " +
                     this.getHypotenuse();
                     
        return str;
        
    }
}