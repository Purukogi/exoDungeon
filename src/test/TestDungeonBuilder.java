package test;

import biomes.Biomes;
import dungeon.*;

public class TestDungeonBuilder {

    public static void main(String[] args) {

        Dungeon floor = new Dungeon();

        floor.generateDungeon(5, Biomes.FOREST);

        System.out.println(floor);
    }

}
