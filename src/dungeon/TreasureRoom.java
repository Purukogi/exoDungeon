package dungeon;

import characters.Adventurer;

public class TreasureRoom extends Room{

    private int goldInRoom;

    public TreasureRoom(int goldInRoom) {
        this.goldInRoom = goldInRoom;
    }

    @Override
    public String exploreRoom(Adventurer adventurer){
        if(!this.isAlreadyExplored()){
            String result = "You found a treasure room! You manage to scavenge " + goldInRoom + " gold pieces.";
            adventurer.setGoldPieces(adventurer.getGoldPieces() + goldInRoom);
            result += "\n\t Your gold: " + adventurer.getGoldPieces();
            this.setAlreadyExplored(true);
            return result;
        }
        return "";
    }

    public int getGoldInRoom() {
        return goldInRoom;
    }

    public void setGoldInRoom(int goldInRoom) {
        this.goldInRoom = goldInRoom;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getClass().getSimpleName();
    }
}
