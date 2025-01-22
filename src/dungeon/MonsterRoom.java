package dungeon;

import characters.Adventurer;
import characters.Monster;

public class MonsterRoom extends Room {

    private Monster monster;
    int localDifficulty;

    public MonsterRoom(Monster monster, int localDifficulty) {
        this.monster = monster;
        this.localDifficulty = localDifficulty;
        this.monster.setHealthPoints(this.monster.getHealthPoints() + 15*localDifficulty);
        this.monster.setDamageValue(this.monster.getDamageValue() + 5*localDifficulty);
        if(localDifficulty == 3){
            this.monster.setName("Rabid" + this.monster.getName());
        }
        if(localDifficulty == 6){
            this.monster.setName("Giant" + this.monster.getName());
        }
        if(localDifficulty == 10){
            this.monster.setName(this.monster.getName() + "of Doom");
        }
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
