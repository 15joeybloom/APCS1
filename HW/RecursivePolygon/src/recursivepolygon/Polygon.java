package recursivepolygon;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author 151bloomj
 */
public class Polygon
{
    private ArrayList<Point> points;

    /**
     * Constructs a Polygon
     */
    public Polygon()
    {
        points = new ArrayList<>();
    }

    /**
     * Constructs a Polygon with the given Points
     * @param p points
     */
    public Polygon(ArrayList<Point> p)
    {
        this();
        points = p;
    }

    /**
     * Sets the points of a Polygon
     * @param p ArrayList<Point> to replace the current points
     */
    public void setPoints(ArrayList<Point> p)
    {
        points = p;
    }

    /**
     * Returns the area of the Polygon
     * @return area by recursive triangulation
     */
    public double getArea()
    {
        return getArea(0);
    }

    /**
     * Gets the area of the Polygon starting at the given vertex and excluding the previous verticies.
     * @param index to start at
     * @return area
     */
    public double getArea(int start)
    {
        if(start + 2 >= points.size())
        {
            return 0;
        }
        int last = points.size() -1;
        double returnMe =
            Math.abs(points.get(last).x * points.get(start).y
                + points.get(start + 1).x * points.get(last).y
                + points.get(start).x * points.get(start + 1).y
                - points.get(last).y * points.get(start).x
                - points.get(start + 1).y * points.get(last).x
                - points.get(start).y * points.get(start + 1).x)
                / 2.0;
        return returnMe
                + getArea(start+1);

    }
}
