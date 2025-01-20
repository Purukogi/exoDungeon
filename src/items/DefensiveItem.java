package items;

public abstract class DefensiveItem extends Item{

    private int defenseBoost;

    public DefensiveItem(String name, int price, int defenseBoost) {
        super(name, price);
        this.defenseBoost = defenseBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    @Override
    public String toString(){
        return super.toString() + " (def: " +defenseBoost + ")";
    }

}
