
/*
 * Joey Bloom
 * Assignment #
 * 
 */

import java.util.Random;

public class Equation
{
    private int first;
    private int second;
    private int level;
    /**
     * Constructs a new equation of the given level.
     * 0 is included in these
     * Level 1 - addition, single digits, sum < 10
     * Level 2 - addition, single digits
     * Level 3 - subtraction, single digits, nonnegative
     * @param the level of the equation
     */
    public Equation(int level)
    {
        this.level = level;
        Random rand = new Random();
        first = rand.nextInt(10);
        if(level == 1)
        {
            second = rand.nextInt(10 - first);
        }
        else if (level == 2)
        {
            second = rand.nextInt(10);
        }
        else if (level == 3)
        {
            second = rand.nextInt(first + 1);
        }
        else
        {
            second = 17;
        }
    }
    public int getFirst()
    {
        return first;
    }
    public int getSecond()
    {
        return second;
    }
    public int getLevel()
    {
        return level;
    }
    /**
     * Returns <code>true</code> if a correct answer.
     * @param ans answer to be checked
     * @return <code>true</code> if 
     *      <code>ans</code> is an answer
     */
    public boolean isCorrectAnswer(int ans)
    {
        if(getLevel() == 3)
        {
            if(getFirst() -
               getSecond() == ans)
                return true;
            else
                return false;
        }
        else
        {
            if(getFirst() +
               getSecond() == ans)
                return true;
            else
                return false;
        }
    }
    public String toString()
    {
        return getFirst() + " " + 
              (getLevel() == 3 ? '-' : '+') + " " + 
               getSecond() + 
               " = ?";
    }
}

