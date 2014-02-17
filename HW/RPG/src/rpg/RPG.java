package rpg;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import rpg.Enemies.AngryHobo;

/**
 * @author Nate
 */
public class RPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game g = new Game();
        g.run();
//        Location[][] locs = new Location[12][12];
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                locs[i][j] = new Location("Grass");
//            }
//        }
//        Map m = new Map(locs);
//        Player p = new Player();
//        Item[] items = new Item[]{new Potion("Small Potion", 10), new Potion("Medium Potion", 20), new Potion("Large Potion", 50),
//            new Potion("X-Large Potion", 100), new Potion("XX-Large Potion", 200), new Potion("Ginormous Potion", 500)};
//        Merchant merc = new Merchant(items);
//        m.getMap()[5][5].addCharacter(p);
//        m.getMap()[2][7].addCharacter(merc);
//        m.getMap()[9][4].addCharacter(new AngryHobo());
//        m.getMap()[6][8].addCharacter(new AngryHobo());
//        m.getMap()[1][11].addCharacter(new AngryHobo());
//        Point pp = new Point(5, 5);
//        GUI gui = new GUI();
//        gui.setVisible(true);
//        int n = gui.dispMap(m.getMap(), new Point(0, 0));
//        while (true) {
//            ArrayList<Point> points = new ArrayList<>();
//            m.getMap()[pp.y][pp.x].removeCharacter();
//            points.add(new Point(pp.x, pp.y));
//            if (n == KeyEvent.VK_LEFT && pp.x != 0) {
//                pp.x--;
//            }
//            if (n == 38 && pp.y != 0) {
//                pp.y--;
//            }
//            if (n == 39 && pp.x != 11) {
//                pp.x++;
//            }
//            if (n == 40 && pp.y != 11) {
//                pp.y++;
//            }
//            if (n == KeyEvent.VK_I) {
//                gui.dispInventory(p);
//                pp = points.get(0);
//                m.getMap()[pp.y][pp.x].addCharacter(p);
//                n = gui.dispMap(m.getMap(), new Point(0, 0));
//            } else if (m.getMap()[pp.y][pp.x].hasUnit()) {
//                Actor a = m.getMap()[pp.y][pp.x].getCharacter();
//                if (a instanceof Merchant) {
//                    gui.dispMerchant(p, (Merchant) a);
//                }
//                if (a instanceof Enemy) {
//                    gui.dispBattle(p, (Enemy) a);
//                    if (p.getCurrentHealth() <= 0) {
//                        p = new Player();
//                        pp = new Point(5,5);
//                    } else if (((Enemy) a).getHealth() <= 0) {
//                        m.getMap()[pp.y][pp.x].removeCharacter();
//                    }
//                }
//                pp = points.get(0);
//                m.getMap()[pp.y][pp.x].addCharacter(p);
//                n = gui.dispMap(m.getMap(), new Point(0, 0));
//            } else {
//                points.add(new Point(pp.x, pp.y));
//                m.getMap()[pp.y][pp.x].addCharacter(p);
//                n = gui.updateMap(points.get(0), points.get(1));
//            }
//        }
    }
}
