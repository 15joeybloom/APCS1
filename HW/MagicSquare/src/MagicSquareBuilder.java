/**
 * @author Joey Bloom
 *
 */
import java.util.Scanner;
public class MagicSquareBuilder
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an odd number: ");
        final int N = in.nextInt();
        if(N%2==0)
        {
            System.out.println("FAIL");
            main(args);
        }
        int[][] sq = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                sq[i][j] = -1;
            }
        }
        int x = N/2;
        int y = N - 1;
        sq[y][x] = 1;
        for(int i = 2; i <= N*N; i++)
        {
            int nextX = x+1;
            int nextY = y+1;
            if(nextX == N)
                nextX = 0;
            if(nextY == N)
                nextY = 0;
            if(sq[nextY][nextX] == -1 && (x != N-1 || y != N-1))
            {
                x = nextX;
                y = nextY;
                sq[y][x] = i;
            }
            else
            {
                nextX = x;
                nextY = y-1;
                if(nextY == -1)
                    nextY = N-1;
                x = nextX;
                y = nextY;
                sq[y][x] = i;
            }
        }
        for(int[] row : sq)
        {
            for(int column : row)
            {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
