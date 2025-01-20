package test;

import biomes.Biomes;
import characters.Adventurer;
import controller.GUI;
import controller.GameLoop;
import dungeon.Dungeon;

public class TestGUI {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 50);

        Dungeon floor = new Dungeon();

        floor.generateDungeon(5, Biomes.FOREST);

        GameLoop instance = new GameLoop(floor, hero);
        GUI window = new GUI(instance);

        window.openGameWindow();

    }

}
