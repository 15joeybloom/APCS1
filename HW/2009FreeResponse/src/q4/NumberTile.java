package q4;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Joey Bloom
 * 2009 Free Response Question 3
 */
public class NumberTile
{
    private int[] dat;
    private static final int LEFT = 0;
    private static final int TOP = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 3;

    public NumberTile(int left, int top, int right, int bottom)
    {
        dat = new int[]{left,top,right,bottom};
    }
    public void rotate()
    {
        Collections.rotate(Arrays.asList(dat), 1);
    }

    public int getLeft()
    {
        return dat[LEFT];
    }

    public int getTop()
    {
        return dat[TOP];
    }

    public int getBottom()
    {
        return dat[BOTTOM];
    }
    public int getRight()
    {
        return dat[RIGHT];
    }
}
