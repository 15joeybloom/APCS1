
import java.util.Scanner;
import static java.lang.System.currentTimeMillis;

/**
 * @author Joey Bloom
 * Assignment #
 * See the README file
 */
public class Runner
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome.");
        System.out.println("Press Enter to begin:");
        in.nextLine();
        DataSet d = new DataSet();
        UnitCircleExpression[] exps = new UnitCircleExpression[10];
        boolean[] correct = new boolean[10];
        for(int i = 0; i < 10; i++)
        {
            exps[i] = new UnitCircleExpression();
            System.out.println(exps[i] + "?");

            long start = currentTimeMillis();
            String ans = in.nextLine();
            int time = (int) (currentTimeMillis() - start);

            d.add(time);
            correct[i] = exps[i].isCorrect(ans);
        }
        System.out.println(correct);
        System.out.println("Total time: " + d.getSum() / 1000d);
        System.out.println("Slowest: " + d.getMaximum() / 1000d);
        System.out.println("Fastest: " + d.getMinimum() / 1000d);
        System.out.println("Average: " + d.getAverage() / 1000d);
    }
}
