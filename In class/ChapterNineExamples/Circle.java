/**
 * Joey Bloom
 * In-class Example (for Assignment #8)
 * Introduces how to write a class
 * definition, using a circle as an
 * example.
 */

public class Circle implements Measureable
{
    //when defining classes, no main() method...
    
    //PART I: INSTANCE VARIABLES
    private double radius;
    
    //PART II: CONSTRUCTORS
    //no-parameters constructor
    public Circle()
    {
        radius = 1;
    }
    
    public Circle(double r)
    {
        radius = r;
    }
    
    //PART III: MUTATORS (A.K.A. "SET" METHODS)
    
    public void setRadius(double r)
    {
        radius = r;
    }
    
    //PART IV: ACCESSORS (A.K.A. "GET" METHODS)
    
    public double getRadius()
    {
        return radius;
    }
    
    //PART V: OTHER MISCELLANEOUS METHODS
    //(USUALLY THEY DO SOME SORT OF CALCULATION ON A VARIABLE
    // OR SOME OTHER ACTION ON A VARIABLE)
    
    public double getCircumference()
    {
        //circumference = 2 * Pi * r
        double circ = 2 * Math.PI * radius;
        return circ;
    }
    
    public double getArea()
    {
        double area = Math.PI * radius * radius;
        return area;
    }
    public double getMeasure()
    {
        return radius;
    }
    //PART VI: toString()
    //prepares all the relevant information about an instance
    //in the form of a String
    public String toString()
    {
        String str = "The radius of your Circle: " + this.getRadius() +
                     "\nThe area of your Circle: " + this.getArea() +
                     "\nThe circumference of your Circle: " + 
                     this.getCircumference();
        return str;
        
    }
}