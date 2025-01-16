package test;

import characters.Monster;
import dungeon.*;

import java.util.ArrayList;
import java.util.List;

public class TestDungeonBuilder {

    public static void main(String[] args) {

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

        builder.generateDungeon(5);

        System.out.println(builder.getDungeon());
    }

}
