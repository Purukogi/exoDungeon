package test;

import characters.Adventurer;
import characters.Monster;
import controller.GameLoop;
import dungeon.Dungeon;
import dungeon.DungeonBuilder;

import java.util.ArrayList;
import java.util.List;

public class TestGameLoop {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 50);

        Monster slime = new Monster("Slime", 20, 3);
        Monster orc = new Monster("Orc", 50, 10);
        Monster goblin = new Monster("Goblin", 30, 5);
        Monster wolf = new Monster("Wolf", 20, 10);
        List<Monster> bestiary = new ArrayList<>();
        bestiary.add(slime);
        bestiary.add(orc);
        bestiary.add(goblin);
        bestiary.add(wolf);

        DungeonBuilder builder = new DungeonBuilder(bestiary);
        Dungeon floor = builder.generateDungeon(5);

        GameLoop loop = new GameLoop(floor, hero);

        loop.startExploration();

    }

}
