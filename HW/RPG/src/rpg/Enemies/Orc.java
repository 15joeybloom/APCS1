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
public class Orc extends Enemy {
    // he's SOOOO ANGRY

    private static final String name = "Orc";
    private static final int attack = 55;
    private static final int defense = 65;
    private static final int health = 40;
    private static final int gold = 20;

    public Orc() {
        super(attack, defense, health, gold, gold, name);
    }
}