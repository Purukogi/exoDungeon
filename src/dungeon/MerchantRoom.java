package dungeon;

import characters.Adventurer;
import items.Item;
import items.ItemsList;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantRoom extends Room{

    private Item[] merchantInventory = new Item[5];

    public MerchantRoom(Item[] merchantInventory) {
        this.merchantInventory = merchantInventory;
        generateInventory(new ItemsList[]{ItemsList.ARMOURS, ItemsList.ARMOURS, ItemsList.BOOTS, ItemsList.WEAPONS, ItemsList.WEAPONS});
    }

    public MerchantRoom() {
        generateInventory(new ItemsList[]{ItemsList.ARMOURS, ItemsList.ARMOURS, ItemsList.BOOTS, ItemsList.WEAPONS, ItemsList.WEAPONS});
    }

    public void barter(Adventurer adventurer){

        JFrame barterWindow = new JFrame("Merchant Shack");
        GridLayout windowLayout = new GridLayout(1, 2);
        barterWindow.setLayout(windowLayout);
        barterWindow.setSize(400, 400);
        barterWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        final JTextPane merchantDialog = new JTextPane();
        merchantDialog.setBackground(Color.BLACK);
        barterWindow.add(merchantDialog);
        final JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        final JButton item1Button = new JButton(merchantInventory[0].getName());
        final JButton item2Button = new JButton(merchantInventory[1].getName());
        final JButton item3Button = new JButton(merchantInventory[2].getName());
        final JButton item4Button = new JButton(merchantInventory[3].getName());
        final JButton item5Button = new JButton(merchantInventory[4].getName());
        buttonPanel.add(item1Button);
        buttonPanel.add(item2Button);
        buttonPanel.add(item3Button);
        buttonPanel.add(item4Button);
        buttonPanel.add(item5Button);
        barterWindow.add(buttonPanel);

        item1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(adventurer.getGoldPieces() >= merchantInventory[0].getPrice()){
                    adventurer.getInventory().addItem(merchantInventory[0]);
                    adventurer.setGoldPieces(adventurer.getGoldPieces() - merchantInventory[0].getPrice());
                    updateEvents(merchantDialog, "Thank you for your business! You have " + adventurer.getGoldPieces() + "gp left.");
                }else{
                    updateEvents(merchantDialog, "You don't have enough money to buy this.");
                }
            }
        });
        item2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(adventurer.getGoldPieces() >= merchantInventory[1].getPrice()){
                    adventurer.getInventory().addItem(merchantInventory[1]);
                    adventurer.setGoldPieces(adventurer.getGoldPieces() - merchantInventory[1].getPrice());
                    updateEvents(merchantDialog, "Thank you for your business! You have " + adventurer.getGoldPieces() + "gp left.");
                }else{
                    updateEvents(merchantDialog, "You don't have enough money to buy this.");
                }
            }
        });
        item3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(adventurer.getGoldPieces() >= merchantInventory[2].getPrice()){
                    adventurer.getInventory().addItem(merchantInventory[2]);
                    adventurer.setGoldPieces(adventurer.getGoldPieces() - merchantInventory[2].getPrice());
                    updateEvents(merchantDialog, "Thank you for your business! You have " + adventurer.getGoldPieces() + "gp left.");
                }else{
                    updateEvents(merchantDialog, "You don't have enough money to buy this.");
                }
            }
        });
        item4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(adventurer.getGoldPieces() >= merchantInventory[3].getPrice()){
                    adventurer.getInventory().addItem(merchantInventory[3]);
                    adventurer.setGoldPieces(adventurer.getGoldPieces() - merchantInventory[3].getPrice());
                    updateEvents(merchantDialog, "Thank you for your business! You have " + adventurer.getGoldPieces() + "gp left.");
                }else{
                    updateEvents(merchantDialog, "You don't have enough money to buy this.");
                }
            }
        });
        item5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(adventurer.getGoldPieces() >= merchantInventory[4].getPrice()){
                    adventurer.getInventory().addItem(merchantInventory[4]);
                    adventurer.setGoldPieces(adventurer.getGoldPieces() - merchantInventory[4].getPrice());
                    updateEvents(merchantDialog, "Thank you for your business! You have " + adventurer.getGoldPieces() + "gp left.");
                }else{
                    updateEvents(merchantDialog, "You don't have enough money to buy this.");
                }
            }
        });

        updateEvents(merchantDialog, "Here are my wares: ");
        updateEvents(merchantDialog, toString());
        updateEvents(merchantDialog, "What are you buying?");

        barterWindow.setVisible(true);
    }

    public void updateEvents(JTextPane eventPane, String event){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = eventPane.getDocument().getLength();
        eventPane.setCaretPosition(len);
        eventPane.setCharacterAttributes(aset, false);
        eventPane.replaceSelection("\n" + event);

    }

    public void generateInventory(ItemsList... items){
        for(int i = 0; i < 5; i ++){
            merchantInventory[i] = items[i].getRandomItem();
        }
    }

    @Override
    public String exploreRoom(Adventurer adventurer){
        String result = "You stumble into a wandering trader";
        barter(adventurer);
        alreadyExplored = true;
        return result;
    }

    @Override
    public String toString(){
        String result = "";
        for(Item item : merchantInventory){
            result += "> " + item.toString() + "("  + item.getPrice() + "gp)" + "\n";
        }
        return result;
    }

}
