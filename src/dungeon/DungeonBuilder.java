package dungeon;

import characters.Adventurer;
import characters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonBuilder {

    private List<Monster> bestiary = new ArrayList<>();
    private Dungeon dungeon;

    public DungeonBuilder(List<Monster> bestiary) {
        this.bestiary = bestiary;
    }

    public Dungeon generateDungeon(int size){
        Random rand = new Random();
        List<Room> roomList = new ArrayList<>();
        Dungeon dungeon = new Dungeon(size);
        Monster randMonster;

        randMonster = bestiary.get(rand.nextInt(bestiary.size()));
        roomList.add(new MonsterRoom( new Monster("King " + randMonster.getName(), randMonster.getHealthPoints() * 2, randMonster.getDamageValue() + 10, true)));

        for(int i = 1; i < (size*size)/3; i ++){
            randMonster = bestiary.get(rand.nextInt(bestiary.size()));
            roomList.add(new MonsterRoom( new Monster(randMonster.getName(), randMonster.getHealthPoints(), randMonster.getDamageValue())));
            int randInt = rand.nextInt(3);
            if(randInt == 2){
                roomList.add(new TreasureRoom(rand.nextInt(200)));
            }else{
                roomList.add(new HealingRoom());
            }
        }

        for(int i = roomList.size(); i < size*size; i++){
            roomList.add(new EmptyRoom());
        }

        roomList = this.randomizeRooms(roomList);

        for(Room room : roomList){
            dungeon.addRoom(room);
        }

        return dungeon;
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


    public List<Monster> getBestiary() {
        return bestiary;
    }

    public void setBestiary(List<Monster> bestiary) {
        this.bestiary = bestiary;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
}
