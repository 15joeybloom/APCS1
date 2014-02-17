/**
 * Joey Bloom
 * Colors:
 * BR = 0
 * BY = 1
 * BO = 2
 * BW = 3
 * RW = 4
 * RY = 5
 * OY = 6
 * OW = 7
 * GR = 8
 * GY = 9
 * GO = 10
 * GW = 11
 * 
 * Orientation:
 * If piece can be put into place without turning F or B face,
 * then it is oriented.
 */

import java.util.ArrayList;
import java.awt.Color;

public class EdgePiece extends Piece
{
    private final static ArrayList<String> locations = initializeLocations();
    public static final int ORIENTED = 0;
    public static final int UNORIENTED = 1;
    private static ArrayList<String> initializeLocations()
    {
        ArrayList<String> returnMe = new ArrayList<>(12);
        String[] useMe =
            {"BR","BY","BO","BW",
             "RW","RY","OY","OW",
             "GR","GY","GO","GW"}   ;
        for(int i = 0; i < 12; i++)
        {
            returnMe.add(useMe[i]);
        }
        return returnMe;
    }
    private static final ArrayList<String> colors = initializeColors();
    private static ArrayList<String> initializeColors()
    {
        ArrayList<String> returnMe = new ArrayList<>(12);
        String[] useMe =
            {"BR", "BY", "BO", "BW", 
             "RW", "RY", "OY", "OW", 
             "GR", "GY", "GO", "GW"}; 
        for(int i = 0; i < 12; i++)
        {
            returnMe.add(useMe[i]);
        }
        return returnMe;
    }
    /**
     * Creates a new EdgePiece of the two specified colors. c0
     * is in the oriented position.
     * @param c0 Color in the oriented position
     * @param c1 Color in the unoriented position
     */
    public EdgePiece(Color c0, Color c1) throws NoSuchPieceException
    {
        if(c0.equals(c1))
            throw new NoSuchPieceException(
                "Error: Edge Piece cannot have two of the same colors");
        if(c0.equals(Color.blue) || c0.equals(Color.green))
        {
            if(c1.equals(Color.blue) || c1.equals(Color.green))
                throw new NoSuchPieceException(
                    "Error: No BG Edge Piece");
            else
            {    
                String colorString =
                    letterColors.getByValue(c0) +
                    letterColors.getByValue(c1);
                color = colors.indexOf(colorString);
                orientation = 0;
            }
        }
        else if(c1.equals(Color.blue) || c1.equals(Color.green))
        {
            String colorString =
                letterColors.getByValue(c1) +
                letterColors.getByValue(c0);
            color = colors.indexOf(colorString);
            orientation = 1;
        }
        else if(c0.equals(Color.red) || c0.equals(Color.orange))
        {
            if(c1.equals(Color.red) || c1.equals(Color.orange))
                throw new NoSuchPieceException(
                    "Error: No RO EdgePiece");
            else
            {
                String colorString =
                    letterColors.getByValue(c0) +
                    letterColors.getByValue(c1);
                color = colors.indexOf(colorString);
                orientation = 0;
            }
        }
        else if(c1.equals(Color.red) || c1.equals(Color.orange))
        {
            String colorString =
                letterColors.getByValue(c1) +
                letterColors.getByValue(c0);
            color = colors.indexOf(colorString);
            orientation = 1;
        }
        else if((c0.equals(Color.white) || c0.equals(Color.yellow)) &&
                (c1.equals(Color.white) || c1.equals(Color.yellow)))
            throw new NoSuchPieceException(
                "Error: No WY EdgePiece");
    }
    /**
     * Creates a new EdgePiece with the given location
     * String, the given orientation, and the given color String.
     */
    public EdgePiece(String c, int o) throws NoSuchPieceException
    {
        this(colors.indexOf(c),o);
        if(color == -1)
        {
            throw new NoSuchPieceException(
                "Error: No " + c + " Edge Piece");
        }
    }
    /**
     * Creates a new EdgePiece with the given location integer,
     * the given orientation, and the given color integer.
     */
    public EdgePiece(int c, int o)
    {
        super(c,o);
    }
    /**
     * @return the color String
     */
    public String getColorString()
    {
        return colors.get(color);
    }
    /**
     * Toggles the orientation
     */
    public void toggleOrientation()
    {
        if(orientation == 1)
            orientation = 0;
        else
            orientation = 1;
    }
    /**
     * If <code>o == 0</code>
     * Returns the color that is on the U face, D face, or on the FL, FR, BL, or BR tile
     * If <code>o == 1</code>
     * Returns the color that is on the L face, R face, or on the LL, LR, RL, or RR tile
     */
    public String getColorLetter(int o)
    {
        assert o == 0 || o == 1;
        if(o == 0)
            return getColorString().charAt(getOrientation()) + "";
        else
            return getColorString().charAt(getOrientation() == 0 ? 1 : 0) + "";
    }
    public Color getColor(int o)
    {
        return letterColors.getByKey(getColorLetter(o));
    }
}