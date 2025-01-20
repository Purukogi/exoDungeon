package test;

import biomes.Biomes;
import characters.Adventurer;
import controller.GameLoop;
import dungeon.Dungeon;

public class TestGameLoop {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 50);

        Dungeon floor = new Dungeon(5, Biomes.FOREST);
        floor.generateDungeon();

        GameLoop loop = new GameLoop(floor, hero);

        loop.startExploration();

    }

}
