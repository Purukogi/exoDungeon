package characters;

public class Monster extends Character {

    private String name;
    private boolean isBoss;

    public Monster(String name, int healthPoints, int damageValue, boolean isBoss) {
        super(healthPoints, damageValue);
        this.name = name;
        this.isBoss = isBoss;
    }

    public Monster(String name, int healthPoints, int damageValue) {
        super(healthPoints, damageValue);
        this.name = name;
        isBoss = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }
}
