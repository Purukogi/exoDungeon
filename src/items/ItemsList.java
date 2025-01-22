package items;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum ItemsList {

    ARMOURS(Arrays.asList(
            new Armour("Leather Armour", 100, 3),
            new Armour("Chainmail", 150, 5),
            new Armour("Iron Armour", 200, 7),
            new Armour("Plate Armour", 300, 10)
    )),
    BOOTS(Arrays.asList(
            new Boots("Leather Boots", 100, 3),
            new Boots("Padded Boots", 150, 5),
            new Boots("Iron Boots", 200, 7),
            new Boots("Plate Boots", 300, 10)
    )),
    WEAPONS(Arrays.asList(
            new Weapon("Knife", 80, 3, false),
            new Weapon("Rapier", 120, 5, false),
            new Weapon("Straight Sword", 180, 7, false),
            new Weapon("Mall", 250, 15, true)
    )),
    RINGS(Arrays.asList(
            new Ring("Ring of Healing", 200),
            new Ring("Gold Ring", 500),
            new Ring("Ring of Clarity", 150)
            //new Ring("Ring of Evasion", 300)
            /*TODO ^^ implement a way to allow the player to see what monster he'll face and give a chance to flee
            */
    ));

    private final List<Item> itemList;

    public Item getRandomItem(){
        Random rand = new Random();
        int randInt = rand.nextInt(itemList.size());
        return getItemList().get(randInt);
    }

    ItemsList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
