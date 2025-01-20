package test;

import items.Armour;
import items.Inventory;
import items.Weapon;

public class TestInventory {

    public static void main(String[] args) {

        Inventory backpack1 = new Inventory();
        Armour armour1 = new Armour("Iron Armour", 100, 10);
        Armour armour2 = new Armour("Plate Armour", 100, 25);
        Weapon rapier = new Weapon("Rapier", 100, 10, false);
        Weapon knife = new Weapon("knife", 100, 5, false);
        Weapon maul = new Weapon("Maul", 100, 20, true);

        backpack1.addItem(armour1);
        backpack1.addItem(armour2);
        backpack1.addItem(rapier);
        backpack1.addItem(knife);

        System.out.println(backpack1);

        backpack1.addItem(maul);
        System.out.println(backpack1);

        backpack1.addItem(rapier);
        System.out.println(backpack1);

    }

}
