package dungeon;

import characters.Adventurer;

public class EmptyRoom extends Room {

    @Override
    public String exploreRoom(Adventurer adventurer) {
        if(!this.isAlreadyExplored()){
            this.setAlreadyExplored(true);
            return "The room is empty... You find nothing of value.";
        }
        return "";
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getClass().getSimpleName();
    }

}
