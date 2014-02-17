/**
 * @author Joey Bloom
 * Contains the commonalities between edges and corners
 */

import java.util.ArrayList;
import java.awt.Color;

public abstract class Piece
{
    protected int orientation;
    protected int color;
    protected static final TwoWayHashMap<String,Color> letterColors =
        initializeLetterColors();
    private static TwoWayHashMap<String,Color> initializeLetterColors()
    {
        TwoWayHashMap<String,Color> returnMe = 
            new TwoWayHashMap<String,Color>();
        returnMe.put("B",Color.blue);
        returnMe.put("R",Color.red);
        returnMe.put("Y",Color.yellow);
        returnMe.put("G",Color.green);
        returnMe.put("O",Color.orange);
        returnMe.put("W",Color.white);
        return returnMe;
    }
    public Piece(){}
    public Piece(int c, int o)
    {
        color = c;
        orientation = o;
    }
    /**
     * @return the orientation
     */
    public int getOrientation()
    {
        return orientation;
    }
    /**
     * sets the orientation
     */
    public void setOrientation(int o)
    {
        orientation = o;
    }
    /**
     * @return the color integer
     */
    public int getColor()
    {
        return color;
    }
}
