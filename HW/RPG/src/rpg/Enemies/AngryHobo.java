package rpg.Enemies;

import rpg.Enemy;

/**
 *
 * @author 151lid
 */
public class AngryHobo extends Enemy {

    private static final String name = "AngryHobo";
    private static final int attack = 25;
    private static final int defense = 5;
    private static final int health = 8;
    private static final int gold = 5;

    public AngryHobo() {
        super(attack, defense, health, gold, gold, name);
    }
}