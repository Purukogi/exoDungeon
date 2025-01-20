package items;

public class Weapon extends Item {

    private int attackBoost;
    private boolean isTwoHanded;

    public Weapon(String name, int price, int attackBoost, boolean isTwoHanded) {
        super(name, price);
        this.attackBoost = attackBoost;
        this.isTwoHanded = isTwoHanded;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public boolean isTwoHanded() {
        return isTwoHanded;
    }

    public void setTwoHanded(boolean twoHanded) {
        isTwoHanded = twoHanded;
    }

    @Override
    public String toString(){
        String result =  super.toString() + " (Atk +" + attackBoost + ")";
        if(isTwoHanded){
            result += " [2 handed]";
        }else{
            result += " [1 handed]";
        }
        return result;
    }
}
