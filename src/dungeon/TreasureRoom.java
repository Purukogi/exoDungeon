package dungeon;

import characters.Adventurer;

public class TreasureRoom extends Room{

    private int goldInRoom;

    public TreasureRoom(int goldInRoom) {
        this.goldInRoom = goldInRoom;
    }

    @Override
    public void exploreRoom(Adventurer adventurer){
        if(!this.isAlreadyExplored()){
            System.out.println("You found a treasure room! You manage to scavenge " + goldInRoom + " gold pieces.");
            adventurer.setGoldPieces(adventurer.getGoldPieces() + goldInRoom);
            System.out.println("\tYour gold: " + adventurer.getGoldPieces());
            this.setAlreadyExplored(true);
        }
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
