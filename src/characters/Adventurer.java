package characters;

import items.*;

import java.util.Random;

public class Adventurer extends Character {

    private int goldPieces;
    private int xCoord, yCoord;
    private Inventory inventory = new Inventory();

    public Adventurer(int healthPoints, int damageValue, int goldPieces) {
        super(healthPoints, damageValue);
        this.goldPieces = goldPieces;
    }

    public String startFight(Monster monster){
        String result = "";
        int adventurerDamage = damageValue;
        if(inventory.getEquipment().get("Weapon 1") != null){
            adventurerDamage += ((Weapon) inventory.getEquipment().get("Weapon 1")).getAttackBoost();
        }
        if(inventory.getEquipment().get("Weapon 2") != null){
            adventurerDamage += ((Weapon) inventory.getEquipment().get("Weapon 2")).getAttackBoost();
        }
        int monsterDamage = monster.getDamageValue();
        if(inventory.getEquipment().get("Armour") != null){
            monsterDamage -= ((Armour) inventory.getEquipment().get("Armour")).getDefenseBoost();
        }
        if(inventory.getEquipment().get("Boots") != null){
            monsterDamage -= ((Boots) inventory.getEquipment().get("Boots")).getDefenseBoost();
        }
        monsterDamage = Math.max(monsterDamage, 0);


        while(this.getHealthPoints() > 0){

            result += "You hit " + monster.getName() + " for " + adventurerDamage +" damage! \n";
            monster.setHealthPoints(monster.getHealthPoints() - adventurerDamage);
            result += "\t" + monster.getName() + "'s health: " + monster.getHealthPoints() + "\n";

            if(monster.getHealthPoints() <= 0){

                result += "You won! " + monster.getName() + " is no more! \n";
                Random rand = new Random();
                int ringRoll = rand.nextInt(10);
                if (ringRoll == 1){
                    Item foundRing = ItemsList.RINGS.getRandomItem();
                    inventory.addItem(foundRing);
                    result += "The " + monster.getName() + " had a " + foundRing.getName() +"!\n";
                    result += "You quickly pocket it.";
                }

                if (monster.isBoss()){
                    result += "You defeated the boss of this dungeon! Congratulations!♕";
                }
                break;

            }

            result += monster.getName() + " hits you for " + monsterDamage + " damage! \n";
            this.setHealthPoints(this.getHealthPoints() - monsterDamage);
            result += "\tYour health: " + this.getHealthPoints() + "\n";

        }

        if(this.getHealthPoints() <= 0){
            result += "You've been defeated... Better luck next time...☠";
        }
        return result;
    }

    public boolean hasGoldRing(){
        boolean check = (!(getInventory().getEquipment().get("Ring 1") == null)
                && getInventory().getEquipment().get("Ring 1").getName().equals("Gold Ring"))
                || (!(getInventory().getEquipment().get("Ring 2") == null)
                && getInventory().getEquipment().get("Ring 2").getName().equals("Gold Ring"));
        return check;
    }

    public boolean hasHealingRing(){
        boolean check = (!(getInventory().getEquipment().get("Ring 1") == null)
                && getInventory().getEquipment().get("Ring 1").getName().equals("Ring of Healing"))
                || (!(getInventory().getEquipment().get("Ring 2") == null)
                && getInventory().getEquipment().get("Ring 2").getName().equals("Ring of Healing"));
        return check;
    }

    public boolean hasClarityRing(){
        boolean check = (! (getInventory().getEquipment().get("Ring 1") == null)
                && (getInventory().getEquipment().get("Ring 1").getName().equals("Ring of Clarity")))
                || (! (getInventory().getEquipment().get("Ring 2") == null)
                && (getInventory().getEquipment().get("Ring 2").getName().equals("Ring of Clarity")));

        return check;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

