
/*
 * Joey Bloom
 * Assignment #
 * 
 */

import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;

public class Window
{
    private Rectangle2D.Double borderR;
    private Ellipse2D.Double borderE;
    private int s;
    //vc = vertical crossbar
    //hc = horizontal crossbar
    private Line2D.Double vc, hc;
    
    public Window( double x, double y , 
                   int s)
    {
        this(x,y,10,10,s);
    }
    public Window( double x, double y,
                   double w, double h,
                   int s )
    {
        this.s = s;
        //rectangular window
        if (s == 1)
        {
            borderR = 
                new Rectangle2D.Double( x, y, w, h );
        }
        //elliptical window
        if (s == 2)
        {
            borderE =
                new Ellipse2D.Double(x,y, w, h);
        }
        vc =
            new Line2D.Double( x + ( w / 2.0), y,
                               x + ( w / 2.0), y + h );
        hc =
            new Line2D.Double( x, y + ( h / 2.0),
                               x + w , y + ( h / 2.0));
        
    }
    
    public void draw(Graphics2D g2)
    {
        if(s == 1)
        {
            g2.draw(borderR);
        }
        if(s == 2)
        {
            g2.draw(borderE);
        }
        g2.draw(vc);
        g2.draw(hc);
    }
}

