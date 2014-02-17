/**
 * @author Joey Bloom
 * Colors:
 * BWR = 0
 * BRY = 1
 * BYO = 2
 * BOW = 3
 * GRW = 4
 * GYR = 5
 * GOY = 6
 * GWO = 7
 *
 * Orientation:
 * blue/green color is on BG face = 0
 * blue/green color is clockwise of BG face = 1
 *  (i.e if you turned the corner piece 120 degrees
 *   counterclockwise, it would be oriented)
 * blue/green color is counterclockwise of BG face = 2
 */

import java.awt.Color;
import java.util.ArrayList;

public class CornerPiece extends Piece
{
    private static final ArrayList<String> locations = initializeLocations();
    public static final int ORIENTED = 0;
    public static final int CCW = 1;
    public static final int CW = 2;
    private static ArrayList<String> initializeLocations()
    {
        ArrayList<String> returnMe = new ArrayList<>(8);
        String[] useMe =
            {"UFL", "UFR", "UBR", "UBL",
             "DFL", "DFR", "DBR", "DBL"};
        for(int i = 0; i < 8; i++)
        {
            returnMe.add(useMe[i]);
        }
        return returnMe;
    }
    private static final ArrayList<String> colors = initializeColors();
    private static ArrayList<String> initializeColors()
    {
        ArrayList<String> returnMe = new ArrayList<>(8);
        String[] useMe =
            {"BWR","BRY","BYO","BOW",
             "GRW","GYR","GOY","GWO"};
        for(int i = 0; i < 8; i++)
        {
            returnMe.add(useMe[i]);
        }
        return returnMe;
    }
    /**
     * Creates a new CornerPiece of the three specified colors.
     * @param c0 Color on the U or D face
     * @param c1 Color clockwise of the U or D face
     * @param c2 Color counterclockwise of the U or D face
     * @throws NoSuchPieceException if the three colors
     *      are not one of the eight corner pieces
     */
    public CornerPiece(Color c0, Color c1, Color c2) throws NoSuchPieceException
    {
        if(c0.equals(c1) || c0.equals(c2) || c1.equals(c2))
            throw new NoSuchPieceException(
                "Error: Corner Piece cannot have two of the same color");
        if(c0.equals(Color.blue) || c0.equals(Color.green))
        {
            String colorString =
                letterColors.getByValue(c0) +
                letterColors.getByValue(c1) +
                letterColors.getByValue(c2);
            color = colors.indexOf(colorString);
            orientation = 0;
            if(color == -1)
            {
                throw new NoSuchPieceException(
                    "Error: No " + colorString + " Corner Piece");
            }
        }
        else if(c1.equals(Color.blue) || c1.equals(Color.green))
        {
            String colorString =
                letterColors.getByValue(c1) +
                letterColors.getByValue(c2) +
                letterColors.getByValue(c0);
            color = colors.indexOf(colorString);
            orientation = 1;
            if(color == -1)
            {
                throw new NoSuchPieceException(
                    "Error: No " + colorString + " Corner Piece");
            }
        }
        else if(c2.equals(Color.blue) || c2.equals(Color.green))
        {
            String colorString =
                letterColors.getByValue(c2) +
                letterColors.getByValue(c0) +
                letterColors.getByValue(c1);
            color = colors.indexOf(colorString);
            orientation = 2;
            if(color == -1)
            {
                throw new NoSuchPieceException(
                    "Error: No " + colorString + " Corner Piece");
            }
        }
        else
        {
            throw new NoSuchPieceException(
                "Error: No " +
                letterColors.getByValue(c0) +
                letterColors.getByValue(c1) +
                letterColors.getByValue(c2) +
                " Corner Piece");
        }
    }
    /**
     * Creates a new CornerPiece with the given location
     * String, the given orientation, and the given color String.
     * @param c the color of the corner piece
     * @param o orientation
     * @throws NoSuchPieceException if c is not one of
     *      the eight color Strings
     */
    public CornerPiece(String c, int o) throws NoSuchPieceException
    {
        this(colors.indexOf(c),o);
        if(color == -1)
        {
            throw new NoSuchPieceException(
                "Error: No " + c + " Corner Piece");
        }
    }
    /**
     * Creates a new CornerPiece with
     * the given orientation, and the given color integer.
     * @param c color integer
     * @param o orientation integer
     *      ORIENTED, CW, or CCW
     */
    public CornerPiece(int c, int o)
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
     * Turns the piece counterclockwise
     */
    public void turnCCW()
    {
        orientation++;
        if(orientation == 3)
            orientation = 0;
    }
    /**
     * Turns the piece clockwise
     */
    public void turnCW()
    {
        orientation--;
        if(orientation == -1)
            orientation = 2;
    }
    /**
     * if ORIENTED
     * Returns the color on the U or D face
     * if CW
     * Returns the color that is CW of the color on the U or D face.
     * if CCW
     * Returns the color that is CCW of the color on the U or D face.
     */
    public String getColorLetter(int o)
    {
        int index = 3;
        if(getOrientation() == ORIENTED)
            index = o;
        else if(getOrientation() == CW)
            index = o == 2 ? 0 : o + 1;
        else if(getOrientation() == CCW)
            index = o == 0 ? 2 : o - 1;
        else
            return "poop";
        return getColorString().charAt(index) + "";
    }
    public Color getColor(int o)
    {
        return letterColors.getByKey(getColorLetter(o));
    }
}