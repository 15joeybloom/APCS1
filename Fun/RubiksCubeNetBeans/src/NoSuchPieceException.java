/**
 * @author Joey Bloom
 * Assignment #
 * 
 */

import java.awt.Color;

public class NoSuchPieceException extends RuntimeException
{
    public NoSuchPieceException(){}
    public NoSuchPieceException(String message)
    {
        super(message);
    }
    public NoSuchPieceException(Color c0, Color c1, Color c2)
    {
        super(
            "Error: No " + 
            Piece.letterColors.getByValue(c0) +
            Piece.letterColors.getByValue(c1) +
            Piece.letterColors.getByValue(c2) +
            " Corner Piece");
    }
}

