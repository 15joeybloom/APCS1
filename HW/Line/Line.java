
/**
 * @author Joey Bloom
 * Extra Credit Assignment
 * A line in a plane.
 */
public class Line
{
    private double slope;
    private double intercept;
    private boolean isVertical;
    /**
     * Constructs a new Line that goes through point (x,y)
     * and has slope m
     * 
     * @param x x coordinate of point
     * @param y y coordinate of point
     * @param m slope
     */
    public Line(double x, double y, double m)
    {
        isVertical = false;
        slope = m;
        intercept = y - m * x;
    }
    /**
     * Constructs a new Line that goes through
     * points (x1,y1) and (x2,y2)
     * 
     * @param x1 first x coordinate
     * @param y1 first y coordinate
     * @param x2 second x coordinate
     * @param y2 second y coordinate
     */
    public Line(double x1, double y1, 
                double x2, double y2)
    {
        if(x1 == x2)
        {
            isVertical = true;
            intercept = x1;
        }
        else
        {
            slope = (y2 - y1)/(x2 - x1);
            intercept = y1 - slope * x1;
        }
    }
    /**
     * Constructs a new Line with the equation
     * y = mx + b, where m is the slope and
     *  (0, b) is the y intercept.
     * 
     * @param equation equation of the line in
     *      slope intercept form
     */
    public Line(String equation)
    {
        String noSpaces = equation.replaceAll(" ","");
        int sign;
        if(noSpaces.indexOf("+") != -1) 
            sign = noSpaces.indexOf("+") + 1;
        else 
            sign = noSpaces.lastIndexOf("-");
        String m = noSpaces.substring(
            noSpaces.indexOf("=") + 1,
            noSpaces.indexOf("x"));
        String b = noSpaces.substring(
            sign,
            noSpaces.length());
        slope = Double.parseDouble(m);
        intercept = Double.parseDouble(b);
    }
    /**
     * Constructs a new vertical Line at a.
     * 
     * @param a the x coordinate of the Line
     */
    public Line(double a)
    {
        isVertical = true;
        intercept = a;
    }
    
    /**
     * Returns the slope of the line
     * @return the slope
     */
    public double getSlope()
    {
        return slope;
    }
    /**
     * Returns the y intercept of the line
     * @return the y intercept
     */
    public double getIntercept()
    {
        return intercept;
    }
    /**
     * Returns true iff the line is vertical
     * @return true iff the line is vertical
     */
    public boolean isVertical()
    {
        return isVertical;
    }
    /**
     * Tests if the line intersects Line <code>other</code>
     * in one or infinitely many places
     * @param other line to be tested
     */
    public boolean intersects(Line other)
    {
        //if slopes are not equal, they intersect
        if(this.getSlope() != other.getSlope())
            return true;
        //from this point on, slopes all slopes are equal.
        //if both vertical or both not vertical...
        else if(this.isVertical() == other.isVertical())
        {
            //and they have the same 
            //intercept, they intersect
            if(this.getIntercept() == other.getIntercept())
                return true;
            //and they have different intercepts,
            //they don't intersect
            else
                return false;
        }
        //if one is vertical and one is
        //horizontal, they intersect
        else
            return true;
    }
    /**
     * Tests if the line is parallel to
     * <code>other</code>
     * @param other line to tested
     */
    public boolean isParallel(Line other)
    {
        return !intersects(other);
    }
    /**
     * Tests if two lines are the same line
     * @param other line to be tested
     */
    public boolean equals(Line other)
    {
        return (this.getSlope() == other.getSlope() &&
                this.getIntercept() == other.getIntercept() &&
                this.isVertical() == other.isVertical());
    }
    /**
     * Returns a the equation of the line
     * @return the equation of the line
     */
    public String toString()
    {
        if(isVertical())return "x= " + getIntercept();
        if(getIntercept() == 0)
        {
            if(getSlope() == 0) return "y= 0.0";
            return "y= " + getSlope() + "x";
        }
        if(getSlope() == 0)return "y= " + getIntercept();
        String sign;
        if(getIntercept() > 0)sign = "+ ";
        else                  sign = "- ";
        return "y= " + getSlope() + "x " + 
               sign + Math.abs(getIntercept());
    }
}

