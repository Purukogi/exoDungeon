package test;

import biomes.Biomes;
import characters.Adventurer;
import controller.GUI;
import controller.GameLoop;
import dungeon.Dungeon;
import items.Ring;

public class TestGUI {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 500);
        hero.getInventory().getEquipment().put("Ring 1", new Ring("Ring of Clarity", 200));

        Dungeon floor = new Dungeon(5, Biomes.CAVE);

        floor.generateDungeon();

        GameLoop instance = new GameLoop(floor, hero);
        GUI window = new GUI(instance);

        window.openGameWindow();

    }

}
