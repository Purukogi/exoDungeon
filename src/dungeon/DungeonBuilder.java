package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonBuilder {

    private List<MonsterRoom> monsterRoomList = new ArrayList<>();
    private List<Room> niceRoomList = new ArrayList<>();
    private Dungeon dungeon;

    public DungeonBuilder(List<MonsterRoom> monsterRoomList, List<Room> niceRoomList) {
        this.monsterRoomList = monsterRoomList;
        this.niceRoomList = niceRoomList;
    }

    public void generateDungeon(int size){
        Random rand = new Random();
        List<Room> roomList = new ArrayList<>();
        Dungeon dungeon = new Dungeon(size);

        MonsterRoom bossRoom = monsterRoomList.get(rand.nextInt(monsterRoomList.size()));
        bossRoom.getMonster().setBoss(true);
        bossRoom.getMonster().setName("King " + bossRoom.getMonster().getName());
        roomList.add(bossRoom);

        for(int i = 1; i < (size*size)/3; i++){
            roomList.add(monsterRoomList.get(rand.nextInt(monsterRoomList.size())));
            System.out.println("Added monster: " + roomList.getLast());
            roomList.add(niceRoomList.get(rand.nextInt(niceRoomList.size())));
            System.out.println("Added: " + roomList.getLast().getClass().getSimpleName());
            System.out.println("---------------------------------------");
        }
        for(int i = roomList.size(); i < size*size; i++){
            roomList.add(new EmptyRoom());
        }
        System.out.println("Number of rooms: " + roomList.size());
        roomList = this.randomizeRooms(roomList);
        System.out.println("Number of rooms: " + roomList.size());

        for(Room room : roomList){
            dungeon.addRoom(room);
        }

        this.dungeon = dungeon;
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

    public List<MonsterRoom> getMonsterRoomList() {
        return monsterRoomList;
    }

    public void setMonsterRoomList(List<MonsterRoom> monsterRoomList) {
        this.monsterRoomList = monsterRoomList;
    }

    public List<Room> getNiceRoomList() {
        return niceRoomList;
    }

    public void setNiceRoomList(List<Room> niceRoomList) {
        this.niceRoomList = niceRoomList;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
}
