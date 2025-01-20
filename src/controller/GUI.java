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

    private JTextPane eventPane = new JTextPane();
    private JTextPane mapPane = new JTextPane();
    private GameLoop instance;

    public GUI(GameLoop instance) {
        this.instance = instance;
        this.instance.setGui(this);
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
                updateEvents(instance.move("up"));
                updateMap();
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                updateEvents(instance.move("right"));
                updateMap();
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                updateEvents(instance.move("down"));
                updateMap();
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                updateEvents(instance.move("left"));
                updateMap();
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
        mapPane.setText(instance.getMap() + "\n Health: " + instance.getHero().getHealthPoints() + "\n Gold: " + instance.getHero().getGoldPieces());
    }

    public void updateEvents(String event){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = eventPane.getDocument().getLength();
        eventPane.setCaretPosition(len);
        eventPane.setCharacterAttributes(aset, false);
        eventPane.replaceSelection("\n" + event);

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
