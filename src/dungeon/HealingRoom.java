package dungeon;

import characters.Adventurer;

import java.util.Random;

public class HealingRoom extends Room {

    private static int hpRestored;

    @Override
    public String exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            Random rand = new Random();
            hpRestored = rand.nextInt(10, 30);
            if( !(adventurer.getInventory().getEquipment().get("Ring 1") == null)
                    && adventurer.getInventory().getEquipment().get("Ring 1").getName().equals("Ring of Healing")            ){
                hpRestored *= 2;
            }
            if( !(adventurer.getInventory().getEquipment().get("Ring 2") == null)
                    && adventurer.getInventory().getEquipment().get("Ring 2").getName().equals("Ring of Healing")            ){
                hpRestored *= 2;
            }
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

