package dungeon;

import characters.Adventurer;

public class EmptyRoom extends Room {

    @Override
    public void exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            System.out.println("The room is empty... You find nothing of value.");
            this.setAlreadyExplored(true);
        }
    }

}
