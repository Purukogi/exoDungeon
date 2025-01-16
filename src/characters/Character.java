package characters;

public abstract class Character {

    protected String name;
    protected int healthPoints;
    protected int damageValue;

    public Character(String name, int healthPoints, int damageValue) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damageValue = damageValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }
}
