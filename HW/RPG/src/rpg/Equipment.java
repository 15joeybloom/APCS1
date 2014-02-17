package rpg;

import java.awt.image.BufferedImage;

/**
 * @author Dean Li The equipment that you can buy
 */
public class Equipment implements Item {

    private String name;
    private int attackboost;
    private int defenseboost;

    /**
     * If the equipment is a weapon, it will be attack boost only, if it's
     * armor, attack boost and defense boost.
     *
     * @param image the image
     * @param name the name
     * @param a the attackboost
     * @param d the defense boost of t
     * @param g the gold value of the equipment
     */
    public Equipment(String name,
            int a, int d) {
        this.name = name;
        attackboost = a;
        defenseboost = d;
    }

    /**
     * The name of the weapon
     *
     * @return the name of the weapon
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns how much attack is boosted by
     *
     * @return attackboost
     */
    public int getAttackBoost() {
        return attackboost;
    }

    /**
     * Returns how much defense is boosted by
     *
     * @return defenseboost
     */
    public int getDefenseBoost() {
        return defenseboost;
    }

    /**
     * The sell value of the items
     */
    public int sellValue() {
        return 2*(attackboost + defenseboost);
    }

    public int buyValue() {
        return (int) (sellValue() * 1.25);
    }

    public String toString() {
        return name + ", att: " + attackboost + ", def: " + defenseboost;
    }
}
