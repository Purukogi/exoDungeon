package test;

import characters.Adventurer;
import dungeon.MerchantRoom;
import items.Armour;
import items.Boots;
import items.Item;
import items.Weapon;

public class TestMerchantRoom {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 1000);
        Armour plate = new Armour("Plate Armour", 300, 10);
        Armour chainmail = new Armour("Chainmail", 150, 5);
        Weapon rapier = new Weapon("Rapier", 200, 10, false);
        Weapon knife = new Weapon("Knife", 100, 5, false);
        Boots leather = new Boots("Leather Boots", 150, 5);

        Item[] merchantInventory = {plate, chainmail, rapier, knife, leather};

        MerchantRoom room = new MerchantRoom(merchantInventory);
        System.out.println(room.exploreRoom(hero));

    }


}
