package test;

import biomes.Biomes;
import characters.Adventurer;
import controller.GameLoop;
import dungeon.Dungeon;
import dungeon.MonsterRoom;

public class TestGameLoop {

    public static void main(String[] args) {


        Adventurer hero = new Adventurer(100, 1000, 50);

        /*
        Dungeon floor = new Dungeon(5, Biomes.FOREST);
        floor.generateDungeon();

        GameLoop loop = new GameLoop(floor, hero);

        loop.startExploration();
        */
        //testing ring drops
        int iterations = 1;
        while (hero.getInventory().getEquipment().get("Ring 1") == null){
            MonsterRoom testRoom = new MonsterRoom(Biomes.MOUNTAINS.getRandomMonster());
            testRoom.exploreRoom(hero);
            iterations++;
        }
        System.out.println(hero.getInventory().toString());
        System.out.println("It took: " + iterations + " tries.");

    }

}
