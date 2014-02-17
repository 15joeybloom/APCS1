
/**
 * Joey Bloom
 * In-class Example (for assignment #6)
 * Introduces how to use the Random class
 */

import java.util.Random;

public class RandomTester
{
    public static void main(String[] args)
    {
        Random gen = new Random();
   
        for( int i = 0 ; i < 100 ; i++ )
        {
            int randomValue = gen.nextInt(3) + 1;
   
            System.out.println(randomValue);
        }
    }
}
    


