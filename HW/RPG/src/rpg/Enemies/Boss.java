package rpg.Enemies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import rpg.Enemy;
import rpg.Equipment;
import rpg.Location;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jasonli
 */
public class Boss extends Enemy {

    private Equipment[] loot;

    public Boss(String n,
            int attack, int defense, int health, int gold, int exp, Equipment[] loot) {
        super(attack, defense, health, gold, exp, n);
        this.loot = loot;
    }

    /**
     * Returns additional loot that you win from bosses
     */
    public Equipment[] getLoot() {
        return loot;
    }
}
