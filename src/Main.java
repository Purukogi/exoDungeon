import biomes.Biomes;
import characters.Adventurer;
import controller.GUI;
import controller.GameLoop;
import dungeon.Dungeon;

public class Main {

    public static void main(String[] args) {

        Adventurer hero = new Adventurer(100, 10, 400);
        Dungeon floor = new Dungeon(5, Biomes.FOREST, 0);

        floor.generateDungeon();

        GameLoop instance = new GameLoop(floor, hero);
        GUI window = new GUI(instance);

        window.openGameWindow();

    }

}
