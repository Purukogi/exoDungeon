package test;

import characters.Monster;
import dungeon.*;

import java.util.ArrayList;
import java.util.List;

public class TestDungeonBuilder {

    public static void main(String[] args) {
        Monster slime = new Monster("Slime", 20, 3);
        Monster orc = new Monster("Orc", 50, 10);
        Monster goblin = new Monster("Goblin", 30, 5);
        Monster wolf = new Monster("Wolf", 20, 10);

        HealingRoom room2 = new HealingRoom();
        TreasureRoom room5 = new TreasureRoom(200);
        MonsterRoom roomSlime = new MonsterRoom(slime);
        MonsterRoom roomOrc = new MonsterRoom(orc);
        MonsterRoom roomGoblin = new MonsterRoom(goblin);
        MonsterRoom roomWolf = new MonsterRoom(wolf);

        List<Room> niceRoomList = new ArrayList<>();
        List<MonsterRoom> monsterRoomList = new ArrayList<>();

        niceRoomList.add(room2);
        niceRoomList.add(room2);
        niceRoomList.add(room5);

        monsterRoomList.add(roomSlime);
        monsterRoomList.add(roomSlime);
        monsterRoomList.add(roomOrc);
        monsterRoomList.add(roomGoblin);
        monsterRoomList.add(roomWolf);

        DungeonBuilder builder = new DungeonBuilder(monsterRoomList, niceRoomList);

        builder.generateDungeon(5);

        System.out.println(builder.getDungeon());
    }

}
