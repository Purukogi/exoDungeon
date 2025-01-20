package biomes;

import characters.Monster;

public enum Forest {

    SLIME(new Monster("Slime", 20, 3)),
    WOLF(new Monster("Wolf", 30, 10)),
    PIXIE(new Monster("Pixie", 20, 5)),
    BEAR(new Monster("Bear", 50, 10)),
    BANDIT(new Monster("Bandit", 30, 5));


    private final Monster monster;

    private Forest(Monster monster){
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }
}
