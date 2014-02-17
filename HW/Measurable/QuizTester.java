/**
 * @author Joey Bloom
 * Assignment #35
 * tests the dataset class using quiz objects
 */
public class QuizTester
{
    public static void main(String[] args)
    {
        DataSet dSet = new DataSet();
        Quiz[] quizzes = new Quiz[5];
        quizzes[0] = new Quiz(90, "A-");
        quizzes[1] = new Quiz(70, "D");
        quizzes[2] = new Quiz(3, "G");
        quizzes[3] = new Quiz(500, "A+++++++");
        quizzes[4] = new Quiz(85, "B");
        for(Quiz beep : quizzes)
        {
            dSet.add(beep);
        }
        System.out.println("Average: " + dSet.getAverage());
        Quiz max = (Quiz)dSet.getMaximum();
        System.out.println("Maximum: " + max.getScore() + " " + max.getGrade());
    }
}
/*
Output:
Average: 149.6
Maximum: 500.0 A+++++++

 */