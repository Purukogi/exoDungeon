package controller;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame gameWindow = new JFrame("Dungeon Explorer");
    private JTextPane eventPane = new JTextPane();
    private JTextPane mapPane = new JTextPane();
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
        final JPanel mapButtonsPanel = new JPanel(new GridLayout(2, 1));
        instance.startExploration();
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

        mapButtonsPanel.add(mapPane);
        mapButtonsPanel.add(buttonsPanel);

        //panel for text descriptions
        eventPane.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(eventPane);

        gameWindow.add(scrollPane);
        gameWindow.add(mapButtonsPanel);

        //events

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("up");
                updateEvents(buffer);
                updateMap();
                checkGameEnd(buffer);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("right");
                updateEvents(buffer);
                updateMap();
                checkGameEnd(buffer);
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("down");
                updateEvents(buffer);
                updateMap();
                checkGameEnd(buffer);
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String buffer = instance.move("left");
                updateEvents(buffer);
                updateMap();
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

    public void checkGameEnd(String event){
        if(!event.isEmpty() && event.charAt(event.length() - 1) == '♕'){

            JFrame victoryWindow = new JFrame("VICTORY");
            victoryWindow.setSize(250, 80);
            victoryWindow.setLocation(475, 360);
            victoryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea victoryMessageArea = new JTextArea();
            victoryMessageArea.setText("You beat the boss of the dungeon! \n You can now close the application.");
            victoryWindow.add(victoryMessageArea);
            victoryWindow.setVisible(true);
            victoryWindow.setAlwaysOnTop(true);
            victoryWindow.setAutoRequestFocus(true);

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
