package biomes;

import characters.Monster;

public enum Mountains {

    EAGLE(new Monster("Eagle", 20, 5)),
    HARPY(new Monster("Harpy", 30, 10)),
    MOUNTAINS_WOLF(new Monster("Mountains Wolf", 20, 10)),
    GIANT(new Monster("Giant", 50, 10)),
    LYNX(new Monster("Lynx", 30, 5));


    private final Monster monster;

    private Mountains(Monster monster){
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }
}
