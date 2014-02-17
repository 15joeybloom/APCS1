/**
 * @author Joey Bloom
 * Assignment #35
 * a quiz has a score and a grade
 */
public class Quiz implements Measurable
{
    private double score;
    private String grade;
    
    /**
     * creates a new Quiz
     * @param s score
     * @param g grade
     */
    public Quiz(double s, String g)
    {
        score = s;
        grade = g;
    }
    /**
     * returns the score
     * @return the score
     */
    public double getScore()
    {
        return score;
    }
    /**
     * returns the grade
     * @return the grade
     */
    public String getGrade()
    {
        return grade;
    }
    public double getMeasure()
    {
        return getScore();
    }
}
