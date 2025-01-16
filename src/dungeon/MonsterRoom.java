package dungeon;

import characters.Adventurer;
import characters.Monster;

public class MonsterRoom extends Room {

    private Monster monster;

    public MonsterRoom(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            System.out.println("You entered the " + monster.getName() +"'s room! A fight ensues!");
            adventurer.startFight(monster);
            this.setAlreadyExplored(true);
        }
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
