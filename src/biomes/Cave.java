package biomes;

import characters.Monster;

public enum Cave {

    BAT(new Monster("Bat", 20, 3)),
    GOBLIN(new Monster("Goblin", 20, 5)),
    ORC(new Monster("Orc", 30, 10)),
    CAVE_SLIME(new Monster("Cave Slime", 50, 3)),
    SKELETON(new Monster("Skeleton", 30, 5));


    private final Monster monster;

    private Cave(Monster monster){
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }
}
