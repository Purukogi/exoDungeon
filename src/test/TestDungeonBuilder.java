package test;

import biomes.Biomes;
import dungeon.*;

public class TestDungeonBuilder {

    public static void main(String[] args) {

        Dungeon floor = new Dungeon(5, Biomes.CAVE);

        floor.generateDungeon();

        System.out.println(floor);
    }

}
