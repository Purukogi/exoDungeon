package dungeon;

import characters.Adventurer;

import java.util.Random;

public class TreasureRoom extends Room{

    private int goldInRoom;

    public TreasureRoom() {}

    @Override
    public String exploreRoom(Adventurer adventurer){
        if(!this.isAlreadyExplored()){
            Random rand = new Random();
            goldInRoom = rand.nextInt(10, 50);
            if( !(adventurer.getInventory().getEquipment().get("Ring 1") == null)
                    && adventurer.getInventory().getEquipment().get("Ring 1").getName().equals("Gold Ring")            ){
                goldInRoom *= 2;
            }
            if( !(adventurer.getInventory().getEquipment().get("Ring 2") == null)
                    && adventurer.getInventory().getEquipment().get("Ring 2").getName().equals("Gold Ring")            ){
                goldInRoom *= 2;
            }
            String result = "You found a treasure room! You manage to scavenge " + goldInRoom + " gold pieces.";
            adventurer.setGoldPieces(adventurer.getGoldPieces() + goldInRoom);
            result += "\n\t Your gold: " + adventurer.getGoldPieces();
            this.setAlreadyExplored(true);
            return result;
        }
        return "";
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getClass().getSimpleName();
    }
}
