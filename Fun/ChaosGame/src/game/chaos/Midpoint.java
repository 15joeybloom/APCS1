package game.chaos;
/**
 * Write a description of class Midpoint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.geom.Rectangle2D;

public class Midpoint extends Rectangle2D.Double
{
    /**
     * Constructor for objects of class Midpoint. Sets the
     * coordinates for the top-left corner of the new rectangle
     * somewhere between the top-left corners of the two parameter
     * rectangles, depending on the distance factor. If the
     * distance factor is greater than 1/2, the resulting Midpoint
     * will be closer to pointA; if the distance factor is less
     * than 1/2, the resulting Midpoint will be closer to pointB
     *
     * @param  pointA  The first of the points that the Midpoint is between
     * @param  pointB  The second of the points that the Midpoint is between
     * @param  n  The numerator of the distance factor
     * @param  d  The denominator of the distance factor
     */
    public Midpoint(Rectangle2D.Double pointA, Rectangle2D.Double pointB, int n, int d )
    {
        this.x = ( ( n * pointA.x ) + ( ( d - n ) * pointB.x ) ) / d;
        this.y = ( ( n * pointA.y ) + ( ( d - n ) * pointB.y ) ) / d;
        this.width = 0;
        this.height = 0;
    }
    public Midpoint(Rectangle2D.Double pointA, Rectangle2D.Double pointB, double f)
    {
        this.x = f * pointB.x + (1-f) * pointA.x;
        this.y = f * pointB.y + (1-f) * pointA.y;
        this.width = 0;
        this.height = 0;
    }
}
