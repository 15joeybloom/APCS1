import TurtleGraphics.Pen;
/**
 * @author Joey Bloom
 * Assignment #37
 * This is a Shape. It has an area and an xpos and a ypos
 * and can be drawn and moved stretched
 */
public interface Shape 
{
   public double area();
   public void   draw (Pen p);
   public double getXPos();
   public double getYPos();
   public void   move (double xLoc, double yLoc);
   public void   stretchBy (double factor);
   public String toString();
}

