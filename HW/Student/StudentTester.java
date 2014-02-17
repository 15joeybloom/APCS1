
/**
 * Joey Bloom
 * Assignment #11
 * Tests the Student class.
 */
public class StudentTester
{
    public static void main(String[] args)
    {
        Student jim = new Student("Neutron, James Isaac");
        Student sam = new Student("Am, Sam I.");
        
        jim.addQuiz( 7 );
        jim.addQuiz( 8 );
        jim.addQuiz( 2 );
        jim.addQuiz( 1 );
        jim.addQuiz( -3 );
        
        sam.addQuiz( 4 );
        sam.addQuiz( 4 );
        sam.addQuiz( 4 );
        sam.addQuiz( 6 );
        sam.addQuiz( 6 );
        sam.addQuiz( 6 );
        
        System.out.println(jim);
        System.out.println(sam);
    }
    
    
}

/*
 Output:

Name: Neutron, James Isaac
Average: 3.0
Name: Am, Sam I.
Average: 5.0

 */
