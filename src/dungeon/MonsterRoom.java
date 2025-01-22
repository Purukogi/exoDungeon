package dungeon;

import characters.Adventurer;
import characters.Monster;

public class MonsterRoom extends Room {

    private Monster monster;

    public MonsterRoom(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            String result = "You entered the " + monster.getName() +"'s room! A fight ensues!";
            result += adventurer.startFight(monster);
            this.setAlreadyExplored(true);
            return result;
        }
        return "";
    }

    public Monster getMonster() {
        return monster;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + monster.getName();
    }
}
