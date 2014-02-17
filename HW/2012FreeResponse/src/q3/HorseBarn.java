/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

import java.util.Arrays;

/**
 * @author 151bloomj
 */
public class HorseBarn
{
    /**
     * The spaces in the barn. Each array element holds a reference to the horse
     * that is currently occupying the space. A null value indicates an empty space.
     */
    private Horse[] spaces;

    public HorseBarn(Horse[] horseys)
    {
        spaces = horseys;
    }

    /**
     * Returns the index of the space that contains the horse with the specified name.
     * Precondition: No two horses in the barn have the same name.
     * @param name the name of the horse to find
     * @return the index of the space containing the horse with the specified name;
     * -1 if no horse with the specified name is in the barn.
     */
    public int findHorseSpace(String name)
    {
        for(int i = 0; i < spaces.length; i++)
        {
            if(spaces[i] != null && spaces[i].getName().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Consolidates the barn by moving horses so that the horses are in adjacent spaces,
     * starting at index 0, with no empty space between any two horses.
     * Postcondition: The order of the horses is the same as before the consolidation.
     */
    public void consolidate()
    {
        for(int i = 0; i < spaces.length; i++)
        {
            if(spaces[i] == null)
            {
                inner:
                for(int j = i+1; ;j++)
                {
                    if(j >= spaces.length)
                    {
                        return;
                    }
                    else if(spaces[j] != null)
                    {
                        Horse temp = spaces[i];
                        spaces[i] = spaces[j];
                        spaces[j] = temp;
                        break inner;
                    }
                }
            }
        }
    }

    @Override
    public String toString()
    {
        return Arrays.toString(spaces);
    }
}
