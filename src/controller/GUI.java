package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JTextArea eventArea = new JTextArea();
    private JTextArea mapArea = new JTextArea();
    private GameLoop instance;

    public GUI(GameLoop instance) {
        this.instance = instance;
    }

    public void openGameWindow(){

        JFrame gameWindow = new JFrame("Dungeon Explorer");
        GridLayout windowLayout = new GridLayout(1, 2);
        gameWindow.setLayout(windowLayout);
        gameWindow.setSize(600, 400);
        gameWindow.setLocation(300, 200);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel regrouping the map and control buttons
        final JPanel mapButtonsPanel = new JPanel(new GridLayout(2, 1));
        updateMap();
        //mapArea.setBackground(Color.BLACK);
        //JTextPane appendToPane(textPane, yourString, Color.COLOUR);


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

        mapButtonsPanel.add(mapArea);
        mapButtonsPanel.add(buttonsPanel);

        //panel for text descriptions
        eventArea.setBackground(Color.BLACK);

        gameWindow.add(eventArea);
        gameWindow.add(mapButtonsPanel);

        //events

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                instance.move("up");
                updateMap();
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                instance.move("right");
                updateMap();
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                instance.move("down");
                updateMap();
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                instance.move("left");
                updateMap();
            }
        });

        gameWindow.setVisible(true);

    }

    public void updateMap(){
        mapArea.setText(instance.getMap());
    }

    public JTextArea getEventArea() {
        return eventArea;
    }

    public void setEventArea(JTextArea eventArea) {
        this.eventArea = eventArea;
    }

    public JTextArea getMapArea() {
        return mapArea;
    }

    public void setMapArea(JTextArea mapArea) {
        this.mapArea = mapArea;
    }

    public GameLoop getInstance() {
        return instance;
    }

    public void setInstance(GameLoop instance) {
        this.instance = instance;
    }
}
