package recursivepolygon;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author 151bloomj
 */
public class PolygonTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Point> p = new ArrayList<>();
        p.add(new Point(0,0));
        p.add(new Point(2,0));
        p.add(new Point(1,1));
        p.add(new Point(0,2));
        Polygon poly = new Polygon(p);
        System.out.println(poly.getArea());
        System.out.println("Expected: 2.0");

        ArrayList<Point> p2 = new ArrayList<>();
        p2.add(new Point(1,0));
        p2.add(new Point(2,0));
        p2.add(new Point(3,1));
        p2.add(new Point(3,2));
        p2.add(new Point(2,3));
        p2.add(new Point(1,3));
        p2.add(new Point(0,2));
        p2.add(new Point(0,1));
        Polygon poly2 = new Polygon(p2);
        System.out.println(poly2.getArea());
        System.out.println("Expected: 7.0");
    }
}
