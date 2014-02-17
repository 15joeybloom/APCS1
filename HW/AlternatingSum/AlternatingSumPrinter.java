/**
 * @author Joey Bloom
 * Assignment #32a
 * Computes the alternating sum of a data set
 */
import java.util.Arrays;
import java.util.Random;
public class AlternatingSumPrinter
{
    public static void main(String[] args)
    {
        Random gen = new Random();
        int[] one = new int[]{1,4,9,16,9,7,4,9,11};
        int[] two = new int[20];
        for(int i = 0; i < 20; i++) two[i] = gen.nextInt(100);
        int[] three = new int[1]; three[0] = gen.nextInt(100);
        int[] four = new int[0];
        int[][] cases = new int[][]{one,two,three,four};
        for(int[] blech : cases)
            System.out.println(Arrays.toString(blech) + " = " + test(blech));
    }
    private static int test(int[] blah)
    {
        boolean plus = true;
        int sum = 0;
        for(int bleh : blah)
        {
            if(plus) sum += bleh;
            else sum -= bleh;
            plus = !plus;
        }
        return sum;
    }
}
/*
Output:
[1, 4, 9, 16, 9, 7, 4, 9, 11] = -2
[29, 36, 13, 75, 47, 51, 66, 58, 62, 32, 31, 5, 58, 69, 16, 62, 27, 48, 65, 73] = -95
[93] = 93
[] = 0

 */