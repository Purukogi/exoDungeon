package dungeon;

import biomes.Biomes;
import characters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

    private int size;
    private List<List<Room>> roomsGrid = new ArrayList<List<Room>>();
    private Biomes biome;
    int localDifficulty;

    public Dungeon(int size) {
        this.size = size;
    }

    public Dungeon(int size, Biomes biome) {
        this.size = size;
        this.biome = biome;
    }

    public Dungeon(int size, Biomes biome, int localDifficulty) {
        this.size = size;
        this.biome = biome;
        this.localDifficulty = localDifficulty;
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

    public void generateDungeon(){

        Random rand = new Random();
        List<Room> roomList = new ArrayList<>();
        Monster randMonster;

        randMonster = biome.getRandomMonster();
        roomList.add(new MonsterRoom( new Monster("King " + randMonster.getName(), randMonster.getHealthPoints() + 30, randMonster.getDamageValue() + 5, true), localDifficulty));

        roomList.add(new MerchantRoom());

        for(int i = 1; i < (size*size)/3; i ++){
            randMonster = biome.getRandomMonster();
            roomList.add(new MonsterRoom( new Monster(randMonster.getName(), randMonster.getHealthPoints(), randMonster.getDamageValue()), localDifficulty));
            int randInt = rand.nextInt(3);
            if(randInt == 2){
                roomList.add(new TreasureRoom());
            }else{
                roomList.add(new HealingRoom());
            }
        }

        for(int i = roomList.size(); i < size*size; i++){
            roomList.add(new EmptyRoom());
        }

        roomList = this.randomizeRooms(roomList);

        for(Room room : roomList){
            addRoom(room);
        }

    }

    public List<Room> randomizeRooms(List<Room> roomList){
        List<Room> listToReturn = new ArrayList<>();
        int listSize = roomList.size();
        Random rand = new Random();

        for(int i = 0; i < listSize; i++){
            int randInt = rand.nextInt(roomList.size());
            listToReturn.add(roomList.get(randInt));
            roomList.remove(randInt);
        }

        return listToReturn;
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

    public int getLocalDifficulty() {
        return localDifficulty;
    }

    public void setLocalDifficulty(int localDifficulty) {
        this.localDifficulty = localDifficulty;
    }

    @Override
    public String toString(){
        String result = "Dungeon size: " + size + "*" + size + " rooms\n";
        for(List<Room> row : roomsGrid){
            for(Room room : row){
                result += room.getClass().getSimpleName() + " ";
            }
            result += "\n";
        }
        return result;
    }
}
