package mahjong;

/**
 * @author Joey
 *
 */
public class TileTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Tile t = new Tile();
        printTileInfo(t);

        t = new Tile(Tile.N);
        printTileInfo(t);

        t = new Tile(9,Tile.BAM);
        printTileInfo(t);

        t = new Tile("R");
        printTileInfo(t);

        t = new Tile(t);
        printTileInfo(t);

        t = new Tile("7D");
        printTileInfo(t);

        t = new Tile("e");
        printTileInfo(t);
    }

    private static void printTileInfo(Tile t)
    {
        System.out.println("Tile: " + t);
        System.out.println(t.getName());
        System.out.println("Dragon: " + t.dragon());
        System.out.println("Num: " + t.getNum());
        System.out.println("Suit: " + t.getSuit());
        System.out.println("Suit String: " + t.getSuitString());
        System.out.println("Honor: " + t.honor());
        System.out.println("Joker: " + t.joker());
        System.out.println("Wind: " + t.wind());
        System.out.println();
    }
}