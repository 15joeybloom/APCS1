
/**
 * Write a description of class TriangleComponent here.
 * 
 * @author Joey Bloom 
 * @version 6.25.2012
 */

import java.awt.Polygon;
import java.awt.geom.Rectangle2D.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

public class TriangleComponent extends JComponent
{
    Random rand = new Random();
    private int s;
    private int numerator;
    private int denominator;
    
    /**
     * Constructs a TriangleComponent with the given polygon, and distance factor.
     *
     * @param  s  The number of sides on the polygon
     * @param  numerator  The numerator of the distance factor
     * @param  denominator  The denominator of the distance factor
     **/
    public TriangleComponent( int s, int numerator, int denominator )
    {
        this.s = s - 3;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Draws a Sierpinski Triangle on the Component
     * 
     * @param  g   Graphics object
     */
    public void paintComponent(Graphics g)
    {
        // recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        
        // Plot the verticies of the polygon
        int[][] xPoints = { { 0, 250, 500, 0, 0, 0, 0, 0 }, 
                            { 0, 0, 500, 500, 0, 0, 0, 0 },
                            { 250, 500, 367, 133, 0, 0, 0, 0 },
                            { 133, 366, 500, 366, 133, 0, 0, 0 }, 
                            { 250, 417, 500, 334, 166, 0, 83, 0 }, 
                            { 146, 354, 500, 500, 354, 146, 0, 0 } };
        int[][] yPoints = { { 500, 0, 500, 0, 0, 0, 0, 0 },
                            { 0, 500, 0, 500, 0, 0, 0, 0 },
                            { 0, 200, 500, 500, 200, 0, 0, 0 },
                            { 0, 0, 250, 500, 500, 250, 0, 0 }, 
                            { 0, 83, 334, 500, 500, 334, 83, 0 }, 
                            { 0, 0, 146, 354, 500, 500, 354, 146 } };        
        Double vertexZero = new Double( xPoints[s][0], yPoints[s][0], 0, 0);
        Double vertexOne = new Double( xPoints[s][1], yPoints[s][1], 0, 0);
        Double vertexTwo = new Double( xPoints[s][2], yPoints[s][2], 0, 0);
        Double vertexThree = new Double( xPoints[s][3], yPoints[s][3], 0, 0);
        Double vertexFour = new Double( xPoints[s][4], yPoints[s][4], 0, 0);
        Double vertexFive = new Double( xPoints[s][5], yPoints[s][5], 0, 0);
        Double vertexSix = new Double( xPoints[s][6], yPoints[s][6], 0, 0);
        Double vertexSeven = new Double( xPoints[s][7], yPoints[s][7], 0, 0);
        
                        
        //Construct a starter point
        Double oldPoint = new Double( rand.nextDouble() * 500, rand.nextDouble() * 500, 0, 0 );
        
        //Beginning Chaos Game Loop
        for( int i = 1; i < 500000; i++ )
        {            
            Double vertexPoint = new Double();
            int whichVertex = rand.nextInt( s + 3 );
            switch (whichVertex)
            {
                case 0: vertexPoint.setRect( vertexZero );
                        break;
                case 1: vertexPoint.setRect( vertexOne );
                        break;
                case 2: vertexPoint.setRect( vertexTwo );
                        break; 
                case 3: vertexPoint.setRect( vertexThree );
                        break;
                case 4: vertexPoint.setRect( vertexFour );
                        break;
                case 5: vertexPoint.setRect( vertexFive );
                        break;
                case 6: vertexPoint.setRect( vertexSix );
                        break;
                case 7: vertexPoint.setRect( vertexSeven );
                        break;
            }
            
            Midpoint newPoint = new Midpoint( vertexPoint, oldPoint, numerator, denominator );
            if (i>5)
            {
                g2.draw(newPoint);
            }
            oldPoint.setRect( newPoint );
        }
    }
}
