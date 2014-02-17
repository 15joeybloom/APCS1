package rpg;

import rpg.Enemies.Boss;
import rpg.Enemy;
import rpg.Equipment;
import rpg.Player;

/**
 * @author Tom Kirby
 */
public class Battle {

    private boolean over;

    /**
     * has both parties attack each other
     *
     * @param p = the player
     * @param e = the enemy
     */
    public static void attack(Player p, Enemy e) {
        int pAttack = (p.getAttack() / 2) + (int) ((p.getAttack() / 2) * (Math.random() * 2 + .5));
        int eAttack = (e.getAttack() / 2) + (int) ((e.getAttack() / 2) * (Math.random() * 2 + .5));
        if (Math.random() * 10 <= 9) {
            p.takeDamage((eAttack - p.getDefense()) / 5 + (int) (Math.random() * (eAttack / 10)));
        }
        if (Math.random() * 10 <= 9) {
            e.takeDamage((pAttack - e.getDefense()) / 5 + (int) (Math.random() * (pAttack / 10)));
        }
    }

    /**
     * The player tries to run away but there is a chance that they fail
     *
     * @param p = the player
     * @param e = the enemy
     */
    public static boolean runAway(Player p, Enemy e) {
        int eAttack = (e.getAttack() / 2) + (int) ((e.getAttack() / 2) * (Math.random() * 2 + .5));
        if ((Math.random() * 4) > 3) {
            p.takeDamage((eAttack - p.getDefense()) / 5 + (int) (Math.random() * (eAttack / 10)));
            return false;
        }
        return true;
    }
}