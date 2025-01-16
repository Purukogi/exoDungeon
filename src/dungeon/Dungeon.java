package dungeon;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private int size;
    private List<List<Room>> roomsGrid = new ArrayList<List<Room>>();

    public Dungeon(int size) {
        this.size = size;
    }

    public void addRoom(Room room){

        if (roomsGrid.size() <= size){

            if (roomsGrid.isEmpty()){
                roomsGrid.add(new ArrayList<>());
            }

            if (roomsGrid.getLast().size() < size){
                this.setDoors(room);
                roomsGrid.getLast().add(room);
            }else{

                if(roomsGrid.size() == size){
                    System.out.println("You can't add rooms the dungeon is full!");
                }else{
                    roomsGrid.add(new ArrayList<>());
                    this.setDoors(room);
                    roomsGrid.getLast().add(room);
                }

            }
        }else{
            System.out.println("You can't add rooms the dungeon is full!");
        }
    }

    public void setDoors(Room room){
        if(roomsGrid.size() == 1){
            room.setNorthDoor(false);
        }
        if(roomsGrid.size() == size){
            room.setSouthDoor(false);
        }
        if(roomsGrid.getLast().isEmpty()){
            room.setWestDoor(false);
        }
        if(roomsGrid.getLast().size() == size-1){
            room.setEastDoor(false);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Room>> getRoomsGrid() {
        return roomsGrid;
    }

    @Override
    public String toString(){
        String result = "Dungeon size: " + size + "*" + size + " rooms\n";
        for(List<Room> row : roomsGrid){
            for(Room room : row){
                result += room.getClass().getSimpleName() + " ";
                System.out.println(room);
            }
            result += "\n";
        }
        return result;
    }
}
