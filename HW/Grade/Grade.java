
/**
 * @author Joey Bloom
 * Assignment #19
 * translates a letter grade into a number grade
 */
public class Grade
{
    private String letterGrade;
    
    /**
     * initializes the grade using a String
     * 
     * @param grade the grade
     */
    public Grade( String grade )
    {
        letterGrade = grade + " ";
    }
    
    /**
     * returns a numeric representation of 
     * the letter grade. Returns
     * -1.0 if the String is not a grade.
     * 
     * 
     * @return the number grade
     */
    public double getNumericGrade()
    {
        double numberGrade;
        char letter = letterGrade.charAt(0);
        char sign = letterGrade.charAt(1);
        if (letter == 'A')
        {
            numberGrade = 4.0;
        }
        else if (letter == 'B')
        {
            numberGrade = 3.0;
        }
        else if (letter == 'C')
        {
            numberGrade = 2.0;
        }
        else if (letter == 'D')
        {
            numberGrade = 1.0;
        }
        else if (letter == 'F')
        {
            if (sign != ' ')
            {
                return -1.0;
            }
            else
            {
                return 0.0;
            }
        }
        else
        {
            return -1.0;
        }
        
        if (sign == '+')
        {
            if (letter == 'A')
            {
                return numberGrade;
            }
            numberGrade += 0.3;
        }
        else if (sign == '-')
        {
            numberGrade -= 0.3;
        }
        else if (sign != ' ')
        {
            return -1.0;
        }
        
        return numberGrade;
    }
    
    /**
     * Returns a String representation of this grade
     * 
     * @return a String
     */
    public String toString()
    {
        return "Letter Grade: " + letterGrade +
               "\nNumeric Grade: " + getNumericGrade();
    }
}
