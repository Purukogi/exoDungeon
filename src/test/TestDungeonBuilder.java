package test;

import biomes.Biomes;
import dungeon.*;

import java.util.Arrays;

public class TestDungeonBuilder {

    public static void main(String[] args) {
         /*
        Dungeon floor = new Dungeon(5, Biomes.CAVE);

        floor.generateDungeon();

        System.out.println(floor);

          */

        System.out.println(Arrays.toString(Biomes.values()));
        System.out.println(Biomes.values().length);
        System.out.println(Biomes.values()[2]);
    }

}
