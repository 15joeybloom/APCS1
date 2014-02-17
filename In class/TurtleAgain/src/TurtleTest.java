
import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;
import java.awt.Color;

/**
 * @author 151bloomj
 */
public class TurtleTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Pen p = new StandardPen();
        p.down();
        for(int i = 0; i < 36 * 7; i++)
        {
            p.move(200);
            p.turn(71);
        }
    }
}
