 
/**
 * Write a description of class TriangleComponent here.
 *
 * @author Joey Bloom
 * @version 6.25.2012
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class TriangleComponent extends JPanel
{
    private Random rand = new Random();
    private double f;
    private ArrayList<Point2D.Double> verticies = new ArrayList<Point2D.Double>(10);
    private ArrayList<Color> colors = new ArrayList<Color>(10);

    private static int[][] xPoints =
        { { 0, 250, 500, 0, 0, 0, 0, 0 },
          { 0, 0, 500, 500, 0, 0, 0, 0 },
          { 250, 500, 367, 133, 0, 0, 0, 0 },
          { 133, 366, 500, 366, 133, 0, 0, 0 },
          { 250, 417, 500, 334, 166, 0, 83, 0 },
          { 146, 354, 500, 500, 354, 146, 0, 0 } };
    private static int[][] yPoints =
        { { 500, 0, 500, 0, 0, 0, 0, 0 },
          { 0, 500, 0, 500, 0, 0, 0, 0 },
          { 0, 200, 500, 500, 200, 0, 0, 0 },
          { 0, 0, 250, 500, 500, 250, 0, 0 },
          { 0, 83, 334, 500, 500, 334, 83, 0 },
          { 0, 0, 146, 354, 500, 500, 354, 146 } };

    /**
     * Constructs a TriangleComponent
     **/
    public TriangleComponent(){}

    /**
     * adds a vertex to the list
     */
    public void addVertex(Point2D.Double v, Color c)
    {
        verticies.add(v);
        colors.add(c);
    }
    /**
     * clears the vertex list
     */
    public void clearVerticies()
    {
        verticies.clear();
        colors.clear();
    }
    /**
     * sets the distance factor
     * @param f distance factor
     */
    public void setF(double f)
    {
        this.f = f;
    }
    /**
     * Draws a Sierpinski Triangle on the Component
     *
     * @param  g   Graphics object
     */
    @Override
    public void paintComponent(Graphics g)
    {
        // recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        //clear the component
//        clearScreen();
        g2.clearRect(0,0,getWidth(),getHeight());

        // Plot the verticies of the polygon
        Rectangle2D.Double[] corners = new Rectangle2D.Double[verticies.size()];
        for(int i = 0; i < verticies.size(); i++)
        {
            corners[i] = new Rectangle2D.Double(verticies.get(i).x,verticies.get(i).y,0,0);
        }
//        g2.setColor(Color.black);

        //Construct a starter point
        Rectangle2D.Double oldPoint = new Rectangle2D.Double( rand.nextDouble() * 500, rand.nextDouble() * 500, 0, 0 );

        //Beginning Chaos Game Loop
        Color oneBack = Color.white;
        Color twoBack = Color.white;
        for( int i = 0; i < 500000; i++ )
        {
            Rectangle2D.Double vertexPoint = new Rectangle2D.Double();
            int whichVertex = rand.nextInt(corners.length);
            vertexPoint.setRect(corners[whichVertex]);
//            g2.setColor(colors.get(whichVertex));
            Color thisColor = colors.get(whichVertex);
            int newBlue = (twoBack.getBlue() + oneBack.getBlue() + thisColor.getBlue()) / 3;
            int newGreen = (twoBack.getGreen() + oneBack.getGreen() + thisColor.getGreen()) / 3;
            int newRed = (twoBack.getRed() + oneBack.getRed() + thisColor.getRed()) / 3;
            g2.setColor(new Color(newRed,newGreen,newBlue));
            twoBack = oneBack;
            oneBack = thisColor;


            Midpoint newPoint = new Midpoint( vertexPoint, oldPoint, f );
            if (i>5)
            {
                g2.draw(newPoint);
            }
            oldPoint.setRect( newPoint );
        }

        drawVerticies();
//        //draw verticies
//        for(int i = 0; i < corners.length; i++)
//        {
//            Rectangle2D.Double temp = new Rectangle2D.Double();
//            temp.setRect(corners[i].x-2,corners[i].y-2,4,4);
//            g2.setColor(colors.get(i));
//            g2.fill(temp);
//        }
    }
    public void clearScreen()
    {
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.setBackground(Color.white);
        g2.clearRect(0,0,getWidth(),getHeight());
    }
    public void drawVerticies()
    {
        Graphics2D g2 = (Graphics2D) getGraphics();
        for(int i = 0; i < verticies.size(); i++)
        {
            Ellipse2D.Double temp =
                new Ellipse2D.Double(verticies.get(i).x-3,verticies.get(i).y-3,6,6);
            g2.setColor(colors.get(i));
            g2.fill(temp);
        }
    }
}