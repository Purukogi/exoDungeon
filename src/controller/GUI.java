package controller;

import biomes.Biomes;
import dungeon.Dungeon;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GUI {

    private JFrame gameWindow = new JFrame("Dungeon Explorer");
    private JTextPane eventPane = new JTextPane();
    private JTextPane mapPane = new JTextPane();
    private JTextPane inventoryPane = new JTextPane();
    private GameLoop instance;

    public GUI(GameLoop instance) {
        this.instance = instance;
        this.instance.setGui(this);
    }

    public void openGameWindow(){

        GridLayout windowLayout = new GridLayout(1, 2);
        gameWindow.setLayout(windowLayout);
        gameWindow.setSize(600, 400);
        gameWindow.setLocation(300, 200);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //panel regrouping the map and control buttons
        final JPanel mapInventoryButtonsPanel = new JPanel(new GridLayout(2, 1));
        instance.startExploration();
        final JPanel mapInventoryPanel = new JPanel(new GridLayout(1, 2));
        mapInventoryPanel.add(mapPane);
        mapInventoryPanel.add(inventoryPane);
        inventoryPane.setBackground(Color.BLACK);
        mapPane.setBackground(Color.BLACK);

        final JPanel buttonsPanel = new JPanel(new GridLayout(3, 3));
        final JButton upButton = new JButton("North");
        final JButton rightButton = new JButton("East");
        final JButton downButton = new JButton("South");
        final JButton leftButton = new JButton("West");
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(upButton);
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(leftButton);
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(rightButton);
        buttonsPanel.add(new JPanel());
        buttonsPanel.add(downButton);
        buttonsPanel.add(new JPanel());

        mapInventoryButtonsPanel.add(mapInventoryPanel);
        mapInventoryButtonsPanel.add(buttonsPanel);

        //panel for text descriptions
        eventPane.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(eventPane);

        gameWindow.add(scrollPane);
        gameWindow.add(mapInventoryButtonsPanel);

        //events

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("up");
                updateEvents(buffer);
                updateMap();
                updateInventory();
                checkGameEnd(buffer);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("right");
                updateEvents(buffer);
                updateMap();
                updateInventory();
                checkGameEnd(buffer);
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("down");
                updateEvents(buffer);
                updateMap();
                updateInventory();
                checkGameEnd(buffer);
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("left");
                updateEvents(buffer);
                updateMap();
                updateInventory();
                checkGameEnd(buffer);
            }
        });

        gameWindow.setVisible(true);

    }

    public void updateMap(){

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        mapPane.setCharacterAttributes(aset, false);
        mapPane.setText(instance.getMap() + "\nHealth: " + instance.getHero().getHealthPoints() + "\nGold: " + instance.getHero().getGoldPieces());
    }

    public void updateEvents(String event){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        eventPane.setCharacterAttributes(aset, false);
        eventPane.setText(event);

    }

    public void updateInventory(){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        inventoryPane.setCharacterAttributes(aset, false);
        inventoryPane.setText(instance.getHero().getInventory().toString());
    }

    public void checkGameEnd(String event){
        if(!event.isEmpty() && event.charAt(event.length() - 1) == '♕'){

            JFrame victoryWindow = new JFrame("VICTORY");
            victoryWindow.setSize(400, 200);
            victoryWindow.setLocation(475, 360);
            GridLayout windowLayout = new GridLayout(2, 1);
            victoryWindow.setLayout(windowLayout);
            victoryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea victoryMessageArea = new JTextArea();
            String bossMessage = "You beat the boss of the dungeon! " +
                    "\nIn his belongings, you find a map to another dungeon." +
                    "\nDo you want to go explore it?";
            victoryMessageArea.setText(bossMessage);
            victoryWindow.add(victoryMessageArea);

            JPanel buttonPanel = new JPanel();
            JButton yesButton = new JButton("Of course!");
            JButton noButton = new JButton("No, I need some rest.");
            buttonPanel.add(yesButton);
            buttonPanel.add(noButton);
            victoryWindow.add(buttonPanel);

            victoryWindow.setVisible(true);
            victoryWindow.setAlwaysOnTop(true);
            victoryWindow.setAutoRequestFocus(true);

            //events

            yesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Random rand = new Random();
                    Dungeon newFloor = new Dungeon(rand.nextInt(5, 15), Biomes.values()[rand.nextInt(Biomes.values().length - 1)], instance.getFloor().getLocalDifficulty() + 1);
                    newFloor.generateDungeon();
                    GameLoop newInstance = new GameLoop(newFloor, instance.getHero());
                    GUI newWindow = new GUI(newInstance);

                    victoryWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    victoryWindow.dispatchEvent(new WindowEvent(victoryWindow, WindowEvent.WINDOW_CLOSING));
                    gameWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    gameWindow.dispatchEvent(new WindowEvent(gameWindow, WindowEvent.WINDOW_CLOSING));

                    newWindow.openGameWindow();


                }
            });

            noButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    victoryWindow.dispatchEvent(new WindowEvent(victoryWindow, WindowEvent.WINDOW_CLOSING));
                }
            });

        }
        if(!event.isEmpty() && event.charAt(event.length() - 1) == '☠'){

            JFrame defeatWindow = new JFrame("DEFEAT");
            defeatWindow.setSize(250, 80);
            defeatWindow.setLocation(475, 360);
            defeatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea defeatMessageArea = new JTextArea();
            defeatMessageArea.setText("You died! \n You can now close the application.");
            defeatWindow.add(defeatMessageArea);
            defeatWindow.setVisible(true);
            defeatWindow.setAlwaysOnTop(true);
            defeatWindow.setAutoRequestFocus(true);

        }
    }

    public JTextPane getEventPane() {
        return eventPane;
    }

    public void setEventPane(JTextPane eventPane) {
        this.eventPane = eventPane;
    }

    public JTextPane getMapPane() {
        return mapPane;
    }

    public void setMapPane(JTextPane mapPane) {
        this.mapPane = mapPane;
    }

    public GameLoop getInstance() {
        return instance;
    }

    public void setInstance(GameLoop instance) {
        this.instance = instance;
    }
}
