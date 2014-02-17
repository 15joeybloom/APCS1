package rpg.Enemies;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import rpg.Enemy;
import rpg.Location;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOMISAWSUM
 */
public class Goblin extends Enemy {
    // he's SOOOO ANGRY

    private static final String name = "Goblin";
    private static final int attack = 40;
    private static final int defense = 45;
    private static final int health = 10;
    private static final int gold = 8;

    public Goblin() {
        super(attack, defense, health, gold, gold, name);
    }
}