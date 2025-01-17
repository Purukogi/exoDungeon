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

    public boolean isNorthDoor() {
        return northDoor;
    }

    public void setNorthDoor(boolean northDoor) {
        this.northDoor = northDoor;
    }

    public boolean isEastDoor() {
        return eastDoor;
    }

    public void setEastDoor(boolean eastDoor) {
        this.eastDoor = eastDoor;
    }

    public boolean isSouthDoor() {
        return southDoor;
    }

    public void setSouthDoor(boolean southDoor) {
        this.southDoor = southDoor;
    }

    public boolean isWestDoor() {
        return westDoor;
    }

    public void setWestDoor(boolean westDoor) {
        this.westDoor = westDoor;
    }

    @Override
    public String toString(){
        String result = "";
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
