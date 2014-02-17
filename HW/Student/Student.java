
/*
 * Joey Bloom
 * Assignment #11
 * A Student has a name, a total score, and
 * a number of quizzes taken. There is a method
 * for computing the student's average.
 */
public class Student
{
    private String name;
    private int numberOfQuizzes;
    private int totalScore;
    
    public Student( String whoDat )
    {
        name = whoDat;
        numberOfQuizzes = 0;
        totalScore = 0;
    }
    
    public void addQuiz( int score )
    {
        totalScore += score;
        numberOfQuizzes++;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getTotalScore()
    {
        return totalScore;
    }
    
    public double getAverageScore()
    {
        
        return (double) totalScore / 
            (double) numberOfQuizzes  ;
    }
    
    public String toString()
    {
        return "Name: " + getName() +
               "\nAverage: " + getAverageScore();
    }
}
