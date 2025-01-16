package characters;

public class Monster extends Character {

    private boolean isBoss;

    public Monster(String name, int healthPoints, int damageValue, boolean isBoss) {
        super(name, healthPoints, damageValue);
        this.isBoss = isBoss;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }
}
