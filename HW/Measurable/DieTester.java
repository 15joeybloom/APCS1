import java.util.Scanner;
/**
 * @author Joey Bloom
 * Assignment #34
 * Tests the DataSet class using Die objects
 */
public class DieTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter sides: ");
        final int SIDES = in.nextInt();
        DataSet dSet = new DataSet();
        Die die = new Die(SIDES);
        for(int i = 0; i < 10; i++)
        {
            die.roll();
            System.out.print((int)die.getMeasure() + " ");
            dSet.add(die);
        }
        System.out.println();
        System.out.println("Average: " + dSet.getAverage());
    }
}
/*
Output 1:
Enter sides: 6
3 5 1 3 2 6 3 2 4 5 
Average: 3.4

Output 2:
Enter sides: 17000
15370 15551 3627 14928 15247 15102 11380 15308 2983 4134 
Average: 11363.0

Output 3:
Enter sides: 1
1 1 1 1 1 1 1 1 1 1 
Average: 1.0


 */