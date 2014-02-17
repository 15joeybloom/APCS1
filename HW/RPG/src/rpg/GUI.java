package rpg;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rpg.panels.BattlePanel;
import rpg.panels.InventoryPanel;
import rpg.panels.MapPanel;
import rpg.panels.MerchantPanel;

/**
 *
 * @author Nate
 */
public class GUI extends JFrame {

    private MapPanel mp;
    private InventoryPanel ip;
    private MerchantPanel merp;
    private BattlePanel bp;
    private JPanel jp;

    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp = new JPanel();
        this.add(jp);
    }

    public int dispMap(Location[][] m, Point ulc) {
        remove(jp);
        mp = new MapPanel(m, ulc);
        jp = mp;
        add(jp);
        mp.setPreferredSize(new Dimension(480, 480));
        pack();
        mp.paintComponents(mp.getGraphics());
        MapKeys mk = new MapKeys();
        mp.addKeyListener(mk);
        mp.grabFocus();
        return mk.getCode();
    }

    public int updateMap(Point p1, Point p2) {
        mp.update(mp.getGraphics(), p1, p2);
        MapKeys mk = new MapKeys();
        mp.addKeyListener(mk);
        mp.grabFocus();
        return mk.getCode();
    }

    public void dispInventory(Player p) {
        remove(jp);
        ip = new InventoryPanel(p);
        jp = ip;
        ip.setPreferredSize(new Dimension(480, 261));
        add(jp);
        pack();
        ip.waits1();
    }

    public void dispMerchant(Player p, Merchant m) {
        remove(jp);
        merp = new MerchantPanel(m, p);
        jp = merp;
        jp.setPreferredSize(new Dimension(480, 243));
        add(jp);
        pack();
        merp.waits1();
    }

    public void dispBattle(Player p, Enemy e) {
        remove(jp);
        bp = new BattlePanel(p, e);
        jp = bp;
        jp.setPreferredSize(new Dimension(480, 229));
        add(jp);
        pack();
        bp.waits1();
    }
    
    public void dispText(String s){
        JOptionPane.showMessageDialog(this, s);
    }

    private class MapKeys extends KeyAdapter {

        public int x;

        public void keyPressed(KeyEvent e) {
            putCode(e.getKeyCode());
        }

        synchronized void putCode(int n) {
            x = n;
            notifyAll();
        }

        synchronized int getCode() {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
            return x;
        }
    }
}
/**
 * Allons-y
 */
