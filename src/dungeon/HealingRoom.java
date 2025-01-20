package dungeon;

import characters.Adventurer;

public class HealingRoom extends Room {

    private static int hpRestored = 20;

    @Override
    public String exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            String result = "You find a healing bassin. Your health is restored by " + hpRestored +".";
            adventurer.setHealthPoints(adventurer.getHealthPoints() + hpRestored);
            result += "\n\tYour health: " + adventurer.getHealthPoints();
            this.setAlreadyExplored(true);
            return result;
        }
        return "";
    }

    public static int getHpRestored() {
        return hpRestored;
    }

    public static void setHpRestored(int hpRestored) {
        HealingRoom.hpRestored = hpRestored;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getClass().getSimpleName();
    }
}

