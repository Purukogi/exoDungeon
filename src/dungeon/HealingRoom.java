package dungeon;

import characters.Adventurer;

public class HealingRoom extends Room {

    private static int hpRestored = 20;

    @Override
    public void exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            System.out.println("You find a healing bassin. Your health is restored by " + hpRestored +".");
            adventurer.setHealthPoints(adventurer.getHealthPoints() + hpRestored);
            System.out.println("\tYour health: " + adventurer.getHealthPoints());
            this.setAlreadyExplored(true);
        }
    }

    public static int getHpRestored() {
        return hpRestored;
    }

    public static void setHpRestored(int hpRestored) {
        HealingRoom.hpRestored = hpRestored;
    }
}

