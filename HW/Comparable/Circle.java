/**
 * Joey Bloom
 * Assignment #36
 * Introduces how to write a class
 * definition, using a circle as an
 * example.
 */

public class Circle implements Comparable<Circle>
{
    private double radius;
    
    /**
     * constructs a Circle with radius 1
     */
    public Circle()
    {
        radius = 1;
    }
    
    /**
     * Constructs a Circle with radius
     * @param r radius
     */
    public Circle(double r)
    {
        radius = r;
    }
    /**
     * sets the radius
     * @param r radius
     */
    public void setRadius(double r)
    {
        radius = r;
    }
    public double getRadius()
    {
        return radius;
    }
    /**
     * returns circumference
     * @return circumference
     */
    public double getCircumference()
    {
        //circumference = 2 * Pi * r
        double circ = 2 * Math.PI * radius;
        return circ;
    }
    /**
     * calculates area
     * @return area
     */
    public double getArea()
    {
        double area = Math.PI * radius * radius;
        return area;
    }
    /**
     * returns -1, 0, or 1 as this Circle's radius is less than, equal to, or greater than c
     * @param c Circle to compare to
     * @return -1, 0, or 1
     */
    public int compareTo(Circle c)
    {
        if(getRadius() < c.getRadius())
            return -1;
        else if(getRadius() > c.getRadius())
            return 1;
        else
            return 0;
    }
    /**
     * returns a String representation of this Circle
     * @return String
     */
    public String toString()
    {
        String str = "The radius of your Circle: " + this.getRadius() +
                     "\nThe area of your Circle: " + this.getArea() +
                     "\nThe circumference of your Circle: " + 
                     this.getCircumference();
        return str;
        
    }
}