import java.util.ArrayList;

/**
 * @author Joey Bloom
 * Assignment #32b
 * Insert arbitrary description here
 */
public class Square
{
    ArrayList<Integer> sq;

    /**
     * Constructs an empty square
     */
    public Square()
    {
        sq = new ArrayList<Integer>();
    }
    /**
     * Constructs a square with the given
     * values
     * @param values numbers of the square
     */
    public Square(int... values)
    {
        this();
        for(int bluh : values)
        {
            sq.add(bluh);
        }
    }
    /**
     * appends a number to the square
     * @param i number to be appended
     */
    public void add(int i)
    {
        sq.add(i);
    }
    /**
     * @return true if the square is magic
     */
    public boolean isMagic()
    {
        if(Math.pow((int)Math.sqrt(sq.size()), 2) != sq.size())
        {
            return false;
        }
        for(int i = 1; i <= sq.size(); i++)
        {
            if(!sq.contains(i))
                return false;
        }
        int[][] sq2D =
            new int
            [(int)Math.sqrt(sq.size())]
            [(int)Math.sqrt(sq.size())];
        for(int i = 0; i < sq2D.length; i++)
        {
            for(int j = 0; j < sq2D.length; j++)
            {
                sq2D[i][j] = sq.get(sq2D.length * i + j);
            }
        }
        int[] hSums = new int[sq2D.length];
        int[] vSums = new int[sq2D.length];
        int topLeftDiagSum = 0;
        int bottomLeftDiagSum = 0;
        for(int i = 0; i < sq2D.length; i++)
        {
            hSums[i] = 0;
            vSums[i] = 0;
            for(int bleh : sq2D[i])
            {
                hSums[i] += bleh;
            }
            for(int[] blah : sq2D)
            {
                vSums[i] += blah[i];
            }
            topLeftDiagSum += sq2D[i][i];
            bottomLeftDiagSum += sq2D[i][sq2D.length - 1 - i];
        }
        //check rows
        for(int blih : hSums)
        {
            if(blih != hSums[0])
                return false;
        }
        //check columns
        for(int bloh : vSums)
        {
            if(bloh != hSums[0])
                return false;
        }
        //check diags
        if(topLeftDiagSum != hSums[0] ||
           bottomLeftDiagSum != hSums[0])
            return false;
        return true;

    }
}
