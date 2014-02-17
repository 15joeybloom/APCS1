
/**
 * @author Joey Bloom
 * Assignment #19
 * Tests the Grade class
 */

import java.util.Scanner;

public class GradeTester
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a letter grade: ");
        String input = reader.nextLine();
        System.out.println("\n" + new Grade(input));
    }
}

/*
Output 1:
Enter a letter grade: A+

Letter Grade: A+ 
Numeric Grade: 4.0

Output 2:
Enter a letter grade: B+

Letter Grade: B+ 
Numeric Grade: 3.3

Output 3:
Enter a letter grade: C

Letter Grade: C 
Numeric Grade: 2.0

Output 4:
Enter a letter grade: D-

Letter Grade: D- 
Numeric Grade: 0.7

Output 5:
Enter a letter grade: F

Letter Grade: F 
Numeric Grade: 0.0

Output 6:
Enter a letter grade: i am not a grade

Letter Grade: i am not a grade 
Numeric Grade: -1.0

Output 7:
Enter a letter grade: F-

Letter Grade: F- 
Numeric Grade: -1.0

Output 8:
Enter a letter grade: A this part doesn't matter

Letter Grade: A this part doesn't matter 
Numeric Grade: 4.0

 */
