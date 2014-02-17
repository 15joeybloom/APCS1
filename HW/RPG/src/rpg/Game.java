package rpg;

import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import rpg.Enemies.AngryHobo;
import rpg.Enemies.Goblin;
import rpg.Enemies.Orc;

/**
 *
 * @author Nate
 */
public class Game implements Runnable {

    private Location[][] map1;
    private Player p;

    public Game() {
        createMaps();
        createMerchants();
        createActors();
    }

    private void createMaps() {
        map1 = new Location[22][22];
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                map1[i][j] = new Location("Grass");
            }
        }
    }

    private void createMerchants() {
        Item[] items1 = new Item[]{new Potion("Small Potion", 10), new Potion("Medium Potion", 20), new Potion("Large Potion", 50),
            new Potion("X-Large Potion", 100), new Potion("XX-Large Potion", 200), new Potion("Ginormous Potion", 500)};
        Item[] items2 = new Item[]{new Equipment("Dagger", 10, 0), new Equipment("Mace", 20, 0), new Equipment("Greatsword", 50, 0),
            new Equipment("Flail", 100, 0), new Equipment("Fire Bow", 200, 0), new Equipment("The One Ring", 500, 0)};
        Item[] items3 = new Item[]{new Equipment("Cloth Armor", 0, 10), new Equipment("Leather Armor", 0, 20), new Equipment("Iron Armor", 0, 50),
            new Equipment("Steel Armor", 0, 100), new Equipment("Mythril Armor", 0, 200), new Equipment("Diamond Armor", 0, 500)};
        Merchant merc1 = new Merchant(items1);
        Merchant merc2 = new Merchant(items2);
        Merchant merc3 = new Merchant(items3);

        map1[2][2].addCharacter(merc1);
        map1[2][5].addCharacter(merc2);
        map1[2][8].addCharacter(merc3);
    }

    private void createActors() {
        p = new Player();
        map1[6][5].addCharacter(p);
        map1[8][2].addCharacter(new Friend("Go kill some hobos to the right"));
        map1[8][5].addCharacter(new Friend("You can buy stuff in those shops up there"));
        map1[8][8].addCharacter(new Friend("Press I to use your inventory"));
        for (int x = 0; x < 8; x++) {
            map1[(int) (Math.random() * 12)][12 + (int) (Math.random() * 10)].addCharacter(new AngryHobo());
            map1[12 + (int) (Math.random() * 10)][(int) (Math.random() * 12)].addCharacter(new Goblin());
            map1[12 + (int) (Math.random() * 10)][12 + (int) (Math.random() * 10)].addCharacter(new Orc());
        }
    }

    public void run() {
        Point pp = new Point(5, 6);
        Point ulc = new Point(0, 0);
        GUI gui = new GUI();
        gui.setVisible(true);
        int n = gui.dispMap(map1, ulc);
        while (true) {
            Point p1 = new Point(pp.x, pp.y);
            if (n == KeyEvent.VK_LEFT && pp.x != 0) {
                pp.x--;
            } else if (n == KeyEvent.VK_UP && pp.y != 0) {
                pp.y--;
            } else if (n == KeyEvent.VK_RIGHT && pp.x != 21) {
                pp.x++;
            } else if (n == KeyEvent.VK_DOWN && pp.y != 21) {
                pp.y++;
            }
            if (n == KeyEvent.VK_I) {
                gui.dispInventory(p);
                n = gui.dispMap(map1, ulc);
            } else if (map1[pp.y][pp.x].hasUnit()) {
                Actor a = map1[pp.y][pp.x].getCharacter();
                if (a instanceof Merchant) {
                    gui.dispMerchant(p, (Merchant) a);
                }
                if (a instanceof Friend){
                    gui.dispText(((Friend)a).getDialogue());
                }
                if (a instanceof Enemy) {
                    gui.dispBattle(p, (Enemy) a);
                    if (p.getCurrentHealth() <= 0) {
                        JOptionPane.showMessageDialog(gui, "You Lose... Restarting");
                        p = new Player();
                        map1[p1.y][p1.x].removeCharacter();
                        map1[5][6].addCharacter(p);
                        pp = new Point(6, 5);
                        p1 = new Point(6, 5);
                        ulc = new Point(0, 0);
                    } else if (((Enemy) a).getHealth() <= 0) {
                        map1[pp.y][pp.x].removeCharacter();
                    }
                }
                pp = new Point(p1.x, p1.y);
                n = gui.dispMap(map1, ulc);
            } else {
                map1[p1.y][p1.x].removeCharacter();
                map1[pp.y][pp.x].addCharacter(p);
                if (p1.x == 10 && pp.x == 11) {
                    ulc = new Point(10, ulc.y);
                    n = gui.dispMap(map1, ulc);
                } else if (p1.x == 11 && pp.x == 10) {
                    ulc = new Point(0, ulc.y);
                    n = gui.dispMap(map1, ulc);
                } else if (p1.y == 10 && pp.y == 11) {
                    ulc = new Point(ulc.x, 10);
                    n = gui.dispMap(map1, ulc);
                } else if (p1.y == 11 && pp.y == 10) {
                    ulc = new Point(ulc.x, 0);
                    n = gui.dispMap(map1, ulc);
                } else {
                    n = gui.updateMap(p1, pp);
                }
            }
        }
    }
}
/**
 * Allons-y
 */
