package q4;

import java.util.Arrays;

/**
 * @author Joey Bloom
 * 2012 Free Response Question 4
 */
public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    private int[][] pixelValues;

    public int countWhitePixels()
    {
        int counter = 0;
        for(int[] xs : pixelValues)
        {
            for(int x : xs)
            {
                if(x == WHITE) counter++;
            }
        }
        return counter;
    }

    public void processImage()
    {
        for(int i = 0; i < pixelValues.length - 2; i++)
        {
            for(int j = 0; j < pixelValues[i].length - 2; j++)
            {
                pixelValues[i][j] -= Math.min(pixelValues[i+2][j+2],pixelValues[i][j]);
            }
        }
    }

    @Override
    public String toString()
    {
        return Arrays.deepToString(pixelValues);
    }

    public GrayImage(int[][] horses)
    {
        pixelValues = horses;
    }
}
