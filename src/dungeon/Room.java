package dungeon;

import characters.Adventurer;

public abstract class Room {

    protected boolean alreadyExplored = false, northDoor = true, eastDoor = true, southDoor = true, westDoor = true;

    public abstract void exploreRoom(Adventurer adventurer);

    public boolean isAlreadyExplored() {
        return alreadyExplored;
    }

    public void setAlreadyExplored(boolean alreadyExplored) {
        this.alreadyExplored = alreadyExplored;
    }

    public void setNorthDoor(boolean northDoor) {
        this.northDoor = northDoor;
    }

    public void setEastDoor(boolean eastDoor) {
        this.eastDoor = eastDoor;
    }

    public void setSouthDoor(boolean southDoor) {
        this.southDoor = southDoor;
    }

    public void setWestDoor(boolean westDoor) {
        this.westDoor = westDoor;
    }

    @Override
    public String toString(){
        String result = "Room visited: " + alreadyExplored + "\n";
        if(northDoor){
            result += " O ";
        }else{
            result += " X ";
        }
        result += "\n";
        if(westDoor){
            result += "O ";
        }else {
            result += "X ";
        }if(eastDoor){
            result += "O";
        }else {
            result += "X";
        }
        result += "\n";
        if(southDoor){
            result += " O ";
        }else{
            result += " X ";
        }
        return result;
    }
}
