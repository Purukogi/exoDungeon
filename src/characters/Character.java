package characters;

public abstract class Character {

    protected int healthPoints;
    protected int damageValue;

    public Character(int healthPoints, int damageValue) {
        this.healthPoints = healthPoints;
        this.damageValue = damageValue;
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
