package biomes;

import characters.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Biomes {

    FOREST(Arrays.asList(
            new Monster("Slime", 20, 3),
            new Monster("Wolf", 30, 10),
            new Monster("Pixie", 20, 5),
            new Monster("Bear", 50, 10),
            new Monster("Bandit", 30, 5))),
    MOUNTAINS(Arrays.asList(
            new Monster("Eagle", 20, 5),
            new Monster("Harpy", 30, 10),
            new Monster("Mountains Wolf", 20, 10),
            new Monster("Giant", 50, 10),
            new Monster("Lynx", 30, 5))),
    CAVE(Arrays.asList(
            new Monster("Bat", 20, 3),
            new Monster("Goblin", 20, 5),
            new Monster("Orc", 30, 10),
            new Monster("Cave Spider", 50, 3),
            new Monster("Skeleton", 30, 5))),
    BEACH(Arrays.asList(
            new Monster("Drowned", 15, 5),
            new Monster("Shark", 25, 6),
            new Monster("Pirate", 20, 8),
            new Monster("Jellyfish", 15, 3),
            new Monster("Kraken", 40, 10)
    )),
    DESERT(Arrays.asList(
            new Monster("Mummy", 20, 10),
            new Monster("Coyote", 15, 5),
            new Monster("Scorpion", 20, 8),
            new Monster("Vulture", 15, 4),
            new Monster("Giant Antlion", 40, 10)
    )),
    SWAMP(Arrays.asList(
            new Monster("Carnivorous Plant", 20, 5),
            new Monster("Leech", 15, 3),
            new Monster("Ogre", 30, 8),
            new Monster("Alligator", 20, 7),
            new Monster("Rodent of Unusual Size", 40, 6)
    ));

    private final List<Monster> bestiary;

    public Monster getRandomMonster(){
        Random rand = new Random();
        int randInt = rand.nextInt(bestiary.size());
        return getBestiary().get(randInt);
    }

    private Biomes(List<Monster> bestiary){
        this.bestiary = bestiary;
    }

    public List<Monster> getBestiary() {
        return bestiary;
    }
}
