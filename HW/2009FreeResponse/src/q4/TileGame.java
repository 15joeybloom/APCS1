package q4;

import java.util.ArrayList;

/**
 * @author Joey Bloom
 * 2009 Free Response Question 4
 *
 */
public class TileGame
{
    private ArrayList<NumberTile> board;

    public TileGame()
    {
        board = new ArrayList<>();
    }

    //for testing only, hence package-private
    TileGame(ArrayList<NumberTile> tiles)
    {
        board = tiles;
    }
    private int getIndexForFit(NumberTile tile)
    {
        if(board.isEmpty())
        {
            return 0;
        }
        int left = tile.getLeft();
        int right = tile.getRight();
        if(board.get(0).getLeft() == right)
        {
            return 0;
        }
        for(int i = 1; i < board.size(); i++)
        {
            if(board.get(i).getLeft() == right && board.get(i-1).getRight() == left)
            {
                return i;
            }
        }
        if(board.get(board.size()-1).getRight() == left)
        {
            return board.size();
        }
        return -1;
    }

    public boolean insertTile(NumberTile tile)
    {
        for(int i = 0; i < 4; i++, tile.rotate())
        {
            int x = getIndexForFit(tile);
            if(x != -1)
            {
                board.add(x,tile);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder first = new StringBuilder(" | ");
        StringBuilder second = new StringBuilder(" | ");
        StringBuilder third = new StringBuilder(" | ");
        for(int i = 0; i < board.size(); i++)
        {
            NumberTile tile = board.get(i);
            StringBuilder tileTop = new StringBuilder(tile.getTop() + "");
            StringBuilder tileLeft = new StringBuilder(tile.getLeft() + "").append(" ");
            StringBuilder tileRight = new StringBuilder(tile.getRight() + "");
            StringBuilder tileBottom = new StringBuilder(tile.getBottom() + "");

            int biggestrow = tileTop.length();
            int middleLength = tileLeft.length() + tileRight.length();
            if( middleLength > biggestrow ) biggestrow = middleLength;
            if( tileBottom.length() > biggestrow ) biggestrow = tileBottom.length();

            for(boolean x = true; tileTop.length() < biggestrow; x = !x)
            {
                if(x) tileTop.append(" ");
                else tileTop.insert(0, " ");
            }
            while(tileLeft.length() + tileRight.length() < biggestrow)
            {
                tileLeft.append(" ");
            }
            for(boolean x = true; tileBottom.length() < biggestrow; x = !x)
            {
                if(x) tileBottom.append(" ");
                else tileBottom.insert(0, " ");
            }
            first.append(tileTop).append(" | ");
            second.append(tileLeft).append(tileRight).append(" | ");
            third.append(tileBottom).append(" | ");
        }
        return first.append("\n").append(second).append("\n").append(third).toString();
    }
}
