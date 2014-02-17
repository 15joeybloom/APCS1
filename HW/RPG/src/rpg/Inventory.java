package rpg;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 * @author Deanli The inventory of the player
 */
public class Inventory {

    public final int inventorysize = 10;
    private Item[] inventory;
    private Equipment[] equipment;
    private ArrayList<Potion> potions;

    /**
     * Constructs an inventory of size inventorysize
     */
    public Inventory() {
        inventory = new Item[inventorysize];
        equipment = new Equipment[2];
        potions = new ArrayList<>();
    }

    public Item[] getInventory() {
        return inventory;
    }

    public boolean removeItem(Item i) {
        for (int a = 0; a < 10; a++) {
            if (inventory[a] == i) {
                inventory[a] = null;
                return true;
            }
        }
        return false;
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    /**
     * The equipment to be added to the inventory
     *
     * @param equip
     */
    public boolean addItem(Item item) {
        for (int i = 0; i < inventorysize; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            }
        }

        // this will likely be replaced in the GUI
        System.out.println("You have no space");
        return false;
    }

    public void equipItem(Equipment equip) {
        if (equip.getAttackBoost() < equip.getDefenseBoost()) {
            if (equipment[0] != null) {
                addItem(equipment[0]);
            }
            equipment[0] = equip;
        } else {
            if (equipment[1] != null) {
                addItem(equipment[1]);
            }
            equipment[1] = equip;
        }
    }
}
