package rpg.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import rpg.Location;

/**
 *
 * @author Nate W
 */
public class MapPanel extends JPanel {

    private Location[][] m;
    private Point ulc;

    public MapPanel(Location[][] m, Point ulc) {
        super();
        this.m = m;
        this.ulc = ulc;
    }

    public void move(Point p) {
        ulc = p;
    }

    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = ulc.x; i < ulc.x + 12; i++) {
            for (int j = ulc.y; j < ulc.y + 12; j++) {
                Location loc = m[j][i];
                g2.drawImage(loc.getImage(), (i-ulc.x) * 40, (j-ulc.y) * 40, null);
            }
        }
        for (int i = ulc.x; i < ulc.x + 12; i++) {
            for (int j = ulc.y; j < ulc.y + 12; j++) {
                if (m[j][i].hasUnit()) 
                    g2.drawImage(m[j][i].getCharacter().getImage(), (i - ulc.x) * 40, (j - ulc.y) * 40, null);
            }
        }
    }

    public void update(Graphics g, Point p1, Point p2) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(m[p1.y][p1.x].getImage(), (p1.x - ulc.x) * 40, (p1.y - ulc.y) * 40, null);
        g2.drawImage(m[p2.y][p2.x].getImage(), (p2.x - ulc.x) * 40, (p2.y - ulc.y) * 40, null);
        if (m[p1.y][p1.x].hasUnit()) 
            g2.drawImage(m[p1.y][p1.x].getCharacter().getImage(), (p1.x - ulc.x) * 40, (p1.y - ulc.y) * 40, null);
        if (m[p2.y][p2.x].hasUnit()) 
            g2.drawImage(m[p2.y][p2.x].getCharacter().getImage(), (p2.x - ulc.x) * 40, (p2.y - ulc.y) * 40, null);
    }
}
/**
 * Allons-y
 */
