
/**
Joey Bloom
Calculates the minimum final grade needed 
to earn the specified grade in a class given 
the Q1/Q3 and Q2/Q4 grades. User can 
input percentages for weighting among
Q1/Q3, Q2/Q4 and the final exam.

 */

import javax.swing.JOptionPane;


public class FinalGradeCalculator
{
    public static void main(String[] args)
    {
        Double firstQuarterGrade = new Double(
            JOptionPane.showInputDialog(null,
            "Please enter your Q1/Q3 grade. \n (Omit the percent sign)",
            "Q1/Q3",JOptionPane.PLAIN_MESSAGE));
        
        Double secondQuarterGrade = new Double(
            JOptionPane.showInputDialog(null,
            "Please enter your Q2/Q4 grade. \n (Omit the percent sign)",
            "Q2/Q4",JOptionPane.PLAIN_MESSAGE));
        
        Object[] options =
            { "A", "A-",
              "B+","B","B-",
              "C+","C","C-",
              "D+","D","D-" };
        int desiredGradeInt = JOptionPane.showOptionDialog(null,
            "What grade would you like to" +
            " get in the class?", "Desired Grade",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            "A");
        double[] gradeArray =
            { 92.5, 89.5,
              86.5, 82.5, 79.5,
              76.5, 72.5, 69.5,
              66.5, 62.5, 59.5 };
        String desiredGradeString = (String) options[desiredGradeInt];
        double desiredGradeDouble = gradeArray[desiredGradeInt];
        
        int willSetWeights = JOptionPane.showConfirmDialog(null,
            "Would you like to set custom weighting among the" +
            " quarter grades and the final? \n (Default is" +
            " 40-40-20)",
            "",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
            );
        double firstQuarterWeight = 40;
        double secondQuarterWeight = 40;
        double examWeight = 20;
        if (willSetWeights == JOptionPane.YES_OPTION)
        {
            firstQuarterWeight = new Double(JOptionPane.showInputDialog(
                null,
                "Enter Q1/Q3 Weight",
                "Q1/Q3 Weight",
                JOptionPane.PLAIN_MESSAGE));
            secondQuarterWeight = new Double(JOptionPane.showInputDialog(
                null,
                "Enter Q2/Q4 Weight",
                "Q2/Q4 Weight",
                JOptionPane.PLAIN_MESSAGE));
            examWeight = new Double(JOptionPane.showInputDialog(
                null,
                "Enter Exam Weight",
                "Exam Weight",
                JOptionPane.PLAIN_MESSAGE));
        }
        double weightedTotalQuarterGrades = ((firstQuarterWeight / 100) * firstQuarterGrade) + ((secondQuarterWeight / 100) * secondQuarterGrade);
        double examGrade = Math.ceil(((desiredGradeDouble - weightedTotalQuarterGrades) / (examWeight / 100)) * 100) / 100;
        
        JOptionPane.showMessageDialog(
            null,
            "To get a grade of \n" +
            desiredGradeString +
            "\n in the class, you need at least a \n" + examGrade +
            "%\n on the exam.",
            "Minimum Grade Calculated!",
            JOptionPane.INFORMATION_MESSAGE,
            null);
       
        System.exit(0);
            
    }
}
