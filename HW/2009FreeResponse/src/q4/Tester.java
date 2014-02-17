package q4;

import java.util.ArrayList;

/**
 * @author Joey Bloom
 * 2009 Free Response Question 4
 *
 */
public class Tester
{
    public static void main(String[] args)
    {
        ArrayList<NumberTile> tiles = new ArrayList<>();
        tiles.add(new NumberTile(4,4,3,7));
        tiles.add(new NumberTile(3,6,4,3));
        tiles.add(new NumberTile(4,1,2,3));
        tiles.add(new NumberTile(2,3,2,5));
        tiles.add(new NumberTile(2,5,9,2));

        TileGame game = new TileGame(tiles);
        System.out.println("Before: ");
        System.out.println(game);

        game.insertTile(new NumberTile(2,4,2,9));

        System.out.println("After: ");
        System.out.println(game);
    }
}
