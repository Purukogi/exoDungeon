package controller;

import characters.Adventurer;
import dungeon.Dungeon;
import dungeon.Room;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLoop {

    private Dungeon floor;
    private Adventurer hero;

    public GameLoop(Dungeon floor, Adventurer hero) {
        this.floor = floor;
        this.hero = hero;
    }

    public void startExploration(){

        placeHero();
        System.out.println("You find yourself in an empty room, deep in a dungeon.");
        printMap();

        /*
        System.out.println("You start at x: " + hero.getxCoord() + ", y: " + hero.getyCoord());
        System.out.println(floor);
         */

        JFrame ghostFrame = new JFrame();
        ghostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ghostFrame.setVisible(true);
        ghostFrame.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    move("up");
                    printMap();
                    System.out.println("Where do you want to go?");
                }
                else if (keyCode == KeyEvent.VK_DOWN) {
                    move("down");
                    printMap();
                    System.out.println("Where do you want to go?");
                }
                else if (keyCode == KeyEvent.VK_LEFT) {
                    move("left");
                    printMap();
                    System.out.println("Where do you want to go?");
                }
                else if (keyCode == KeyEvent.VK_RIGHT) {
                    move("right");
                    printMap();
                    System.out.println("Where do you want to go?");
                }
            }
        });


    }

    public void placeHero(){
        Random rand = new Random();
        int xPos = 0, yPos = 0;
        List<List<Room>> listOfRooms = floor.getRoomsGrid();

        do{
            int randomRow = rand.nextInt(floor.getSize());
            for (Room room : listOfRooms.get(randomRow)){
                if (room.getClass().getSimpleName().equals("EmptyRoom")){
                    yPos = randomRow;
                    xPos = listOfRooms.get(randomRow).indexOf(room);
                    room.setAlreadyExplored(true);
                    break;
                }
            }
        }while(xPos == 0 && yPos == 0);

        hero.setxCoord(xPos);
        hero.setyCoord(yPos);
    }

    public void move(String direction){
        switch (direction){
            case "up" -> {
                if(!floor.getRoomsGrid()
                        .get(hero.getyCoord())
                        .get(hero.getxCoord())
                        .isNorthDoor()){
                    System.out.println("The northern exit of the room caved in, you can't go through...");
                }else{
                    hero.setyCoord(hero.getyCoord() - 1);
                    floor.getRoomsGrid()
                            .get(hero.getyCoord())
                            .get(hero.getxCoord())
                            .exploreRoom(hero);
                }
            }
            case "right" -> {
                if(!floor.getRoomsGrid()
                        .get(hero.getyCoord())
                        .get(hero.getxCoord())
                        .isEastDoor()){
                    System.out.println("The eastern exit of the room caved in, you can't go through...");
                }else{
                    hero.setxCoord(hero.getxCoord() + 1);
                    floor.getRoomsGrid()
                            .get(hero.getyCoord())
                            .get(hero.getxCoord())
                            .exploreRoom(hero);
                }
            }
            case "down" -> {
                if(!floor.getRoomsGrid()
                        .get(hero.getyCoord())
                        .get(hero.getxCoord())
                        .isSouthDoor()){
                    System.out.println("The southern exit of the room caved in, you can't go through...");
                }else{
                    hero.setyCoord(hero.getyCoord() + 1);
                    floor.getRoomsGrid()
                            .get(hero.getyCoord())
                            .get(hero.getxCoord())
                            .exploreRoom(hero);
                }
            }
            case "left" -> {
                if(!floor.getRoomsGrid()
                        .get(hero.getyCoord())
                        .get(hero.getxCoord())
                        .isWestDoor()){
                    System.out.println("The western exit of the room caved in, you can't go through...");
                }else{
                    hero.setxCoord(hero.getxCoord() - 1);
                    floor.getRoomsGrid()
                            .get(hero.getyCoord())
                            .get(hero.getxCoord())
                            .exploreRoom(hero);
                }
            }
            default -> System.out.println("Invalid direction input.");
        }
    }

    public void printMap(){
        String map = "";
        for(int i = 0; i < floor.getSize(); i++){
            for(int j = 0; j < floor.getSize(); j++){
                if(hero.getyCoord() == i && hero.getxCoord() == j){
                    map += 'H';
                }else {
                    if (floor.getRoomsGrid().get(i).get(j).isAlreadyExplored()){
                        map += getCrossing(floor.getRoomsGrid().get(i).get(j));
                    }else{
                        map += '█';
                    }
                }
            }
            map += "\n";
        }
        System.out.println(map);
    }

    public char getCrossing(Room room){
        if(!room.isNorthDoor()){
            if(!room.isWestDoor()){
                return '╔';
            }else if(!room.isEastDoor()){
                return '╗';
            }else{
                return '╦';
            }
        }

        if(!room.isSouthDoor()){
            if(!room.isWestDoor()){
                return '╚';
            }else if(!room.isEastDoor()){
                return '╝';
            }else{
                return '╩';
            }
        }

        if(!room.isWestDoor()){
            return '╠';
        }

        if(!room.isEastDoor()){
            return '╣';
        }

        return '╬';
    }

    public Dungeon getFloor() {
        return floor;
    }

    public void setFloor(Dungeon floor) {
        this.floor = floor;
    }

    public Adventurer getHero() {
        return hero;
    }

    public void setHero(Adventurer hero) {
        this.hero = hero;
    }
}
