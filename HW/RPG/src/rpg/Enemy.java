package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Dean Li Extends the character class: can fight them, no opening of
 * dialogue
 */
public abstract class Enemy extends Actor {

    private int attack;
    private int defense;
    private int health;
    private int gold;
    private int exp;
    private String name;

    ;

    /**
     * Constructs the BASICS of the enemy Location and Image
     *
     * @param a The location of the enemy
     * @param b The image of the enemy
     */
    public Enemy(int attack, int defense, int health, int gold, int exp, String name) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.gold = gold;
        this.exp = exp;
        this.name = name;
    }

    /**
     * /**
     * Begins the battle sequence Will call Tom's method. Preferably will be a
     * static method
     */
    /**
     * Returns the attack of the enemy
     *
     * @return the attack of the enemy
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the defense of the enemy
     *
     * @return the defense number
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the health of the enemy
     *
     * @return the health of the enemy
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the amount of gold of the enemy
     *
     * @return gold # cash money
     */
    public int getGold() {
        return (int) (gold * (.75 + (Math.random() / 2)));
    }

    /**
     * Returns the exp awarded by the
     *
     * @return the experience
     */
    public int getExp() {
        return exp;
    }

    /**
     * Has the enemy take damage
     */
    public void takeDamage(int a) {
        if (a < 0) {
            return;
        }
        if (health - a <= 0) {
            health = 0;
            return;
        }

        health -= a;
    }

    public BufferedImage getImage() {
        try {
            return (BufferedImage) (ImageIO.read(new File(name + ".png")));
        } catch (IOException a) {
            System.out.println("Error");
        }

        return null;
    }
}
