
/**
 * Joey Bloom
 * Homework Assignment #6
 * Prints 6 lottery numbers 1-49 with no repeats
 */

import java.util.Random;
import java.util.ArrayList;

public class LotteryPrinter
{
    public static void main(String[] args)
    {
        Random gen = new Random();
    
        
    
        //initializing array of lottery numbers
        ArrayList<Integer> lotteryNumbers =        
            new ArrayList<>(5);
        
        for( int i = 0; i <=5; i++)
        {
            lotteryNumbers.add(0, 0);
        
        } 
        
        for( int i = 0 ; i <= 5 ; i++ )
        {
                
            lotteryNumbers.set(
            i,gen.nextInt(49) + 1);
            
              
            for( int j = 0 ; j < i ; j++ )
            {
                if (lotteryNumbers.get(i) 
                    == lotteryNumbers.get(j))
                { 
                    i--;
                }
            }
            
            
                
                    
        }
        System.out.println("Your winning numbers are: ");
        System.out.println(
        lotteryNumbers.toString());
        
    }
}
    
/*

About 46 runs of output:
[47, 48, 11, 29, 22, 40]
[10, 7, 4, 9, 18, 28]
[46, 21, 13, 27, 47, 19]
[26, 37, 25, 6, 46, 47]
[37, 23, 7, 34, 29, 31]
[33, 47, 45, 48, 24, 31]
[6, 23, 11, 4, 9, 31]
[27, 24, 47, 20, 1, 32]
[29, 38, 19, 23, 11, 4]
[7, 37, 15, 32, 8, 23]
[1, 35, 20, 45, 44, 15]
[39, 40, 9, 8, 11, 7]
[48, 45, 37, 17, 2, 12]
[31, 37, 23, 1, 7, 13]
[12, 47, 19, 36, 30, 48]
[47, 38, 43, 10, 1, 36]
[37, 20, 1, 48, 41, 44]
[6, 45, 24, 14, 47, 33]
[5, 40, 8, 47, 48, 43]
[9, 20, 16, 25, 48, 17]
[43, 41, 33, 20, 5, 8]
[23, 15, 18, 41, 5, 26]
[26, 45, 46, 3, 40, 14]
[45, 20, 14, 37, 18, 13]
[9, 27, 42, 16, 29, 12]
[29, 24, 7, 17, 41, 20]
[36, 35, 4, 30, 25, 9]
[48, 45, 29, 4, 25, 21]
[48, 29, 27, 42, 8, 39]
[32, 28, 38, 4, 42, 1]
[3, 20, 41, 33, 44, 23]
[26, 11, 39, 4, 13, 20]
[33, 18, 31, 22, 3, 46]
[40, 44, 17, 46, 43, 29]
[16, 40, 34, 15, 36, 43]
[43, 33, 27, 20, 39, 4]
[26, 44, 31, 20, 22, 33]
[2, 1, 9, 48, 25, 46]
[21, 27, 20, 12, 28, 5]
[29, 22, 32, 10, 35, 36]
[30, 8, 39, 18, 15, 3]
[14, 36, 6, 29, 46, 25]
[13, 18, 48, 14, 40, 28]
[22, 33, 47, 26, 42, 5]
[33, 30, 11, 43, 38, 10]
[29, 26, 12, 6, 7, 37]
[2, 24, 47, 46, 32, 40]

*/

