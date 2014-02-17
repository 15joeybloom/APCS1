package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Dean Li The main character of the game
 */
public class Player extends Actor {

    private int health;
    private int currenthealth;
    private int attack;
    private int defense;
    private int exp;
    private int level;
    private int gold;
    private Inventory inventory;

    public Player() {
        this.health = 10;
        this.attack = 10;
        this.defense = 10;
        this.exp = 0;
        this.level = 1;
        this.gold = 50;
        inventory = new Inventory();
        inventory.equipItem(new Equipment("Armor", 0, 10));
        inventory.equipItem(new Equipment("Sword", 10, 0));
        inventory.addItem(new Potion("Small Potion", 10));
        inventory.addItem(new Potion("Small Potion", 10));
        currenthealth = health;
    }

    public void LevelUp() {
        level++;
        health += 10 + level / 2;
        attack += 5 + level;
        defense += 5 + level;
        currenthealth = health;
    }

    /**
     * Returns an image for the map to display
     *
     * @Image the image of the main character
     */
    public BufferedImage getImage() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Player.png"));
        } catch (IOException ex) {
        }
        return img;
    }

    /**
     * Buys equipment
     *
     * @param a the equipment that is bought
     */
    public boolean buyItem(Item a) {
        if (a.buyValue() <= gold) {
            if (inventory.addItem(a)) {
                gold -= a.buyValue();
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean sellItem(Item a) {
        if (inventory.removeItem(a)) {
            gold += a.sellValue();
            return true;
        }
        return false;
    }

    public void addGold(int n) {
        gold += n;
    }

    /**
     * The attack of the player
     *
     * @return attack value
     */
    public int getAttack() {
        int a = attack;
        a += inventory.getEquipment()[0].getAttackBoost();
        a += inventory.getEquipment()[1].getAttackBoost();
        return a;
    }

    /**
     * The defense of the player
     *
     * @return defense value
     */
    public int getDefense() {
        int d = defense;
        d += inventory.getEquipment()[0].getDefenseBoost();
        d += inventory.getEquipment()[1].getDefenseBoost();
        return d;
    }

    /**
     * The exp of the player
     *
     * @return exp value
     */
    public int getExp() {
        return exp;
    }

    /**
     * The gold of the player
     *
     * @return gold value
     */
    public int getGold() {
        return gold;
    }

    /**
     * The health of the player
     *
     * @return health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * The level of the player
     *
     * @return level value
     */
    public int getLevel() {
        return attack;
    }

    /**
     * Gets current health of the player
     */
    public int getCurrentHealth() {
        return currenthealth;
    }

    /**
     * The attack of the player
     *
     * @return attack value
     */
    public Inventory getInventory() {
        return inventory;
    }

    public void heal(int n) {
        currenthealth += n;
        if (currenthealth > health) {
            currenthealth = health;
        }
    }

    /**
     * Player takes damage
     */
    public void takeDamage(int a) {
        if (a < 0) {
            return;
        }
        if (currenthealth - a <= 0) {
            currenthealth = 0;
            return;
        }

        currenthealth -= a;
    }
}
