
/*
 * Joey Bloom
 * Assignment #
 * 
 */
public class Game
{
    private int score;
    private int tries;
    private int level;
    private Equation currentEquation;
    /**
     * Constructs a Game
     */
    public Game()
    {
        score = 0;
        tries = 2;
        level = 1;
        currentEquation = new Equation(getLevel());
    }
    public int getScore(){return score;}
    public int getTries(){return tries;}
    public int getLevel(){return level;}
    public Equation getEquation(){return currentEquation;}
    /**
     * Checks if the given <code>int</code> is a
     * correct answer to <code>currentEquation</code>.
     * If so, the score is incremented, the number
     * of tries is reset, and the level is incremented
     * if applicable.
     * @param ans the answer to be checked
     * @return <code>true</code> if 
     *      <code>ans</code> is an answer
     */
    public boolean evaluateAnswer(int ans)
    {
        if(getEquation().isCorrectAnswer(ans))
        {
            score++;
            tries = 2;
            if(score == 5)
            {
                level++;
                score = 0;
            }
            newEquation();
            return true;
        }
        else
        {
            tries--;
            if(getTries() == 0)
            {
                newEquation();
                tries = 2;
            }
            return false;
        }
    }
    /**
     * Generates a new equation.
     */
    private void newEquation()
    {
        currentEquation = new Equation(getLevel());
    }
}

