package characters;

public class Adventurer extends Character {

    private int goldPieces;
    private int xCoord, yCoord;

    public Adventurer(int healthPoints, int damageValue, int goldPieces) {
        super(healthPoints, damageValue);
        this.goldPieces = goldPieces;
    }

    public String startFight(Monster monster){
        String result = "";
        while(this.getHealthPoints() > 0){

            result += "You hit " + monster.getName() + " for " + this.getDamageValue() +" damage! \n";
            monster.setHealthPoints(monster.getHealthPoints() - this.getDamageValue());
            result += "\t" + monster.getName() + "'s health: " + monster.getHealthPoints() + "\n";

            if(monster.getHealthPoints() <= 0){

                result += "You won! " + monster.getName() + " is no more! \n";
                if (monster.isBoss()){
                    result += "You defeated the boss of this dungeon! Congratulations!♕";
                }
                break;

            }

            result += monster.getName() + " hits you for " + monster.getDamageValue() + " damage! \n";
            this.setHealthPoints(this.getHealthPoints() - monster.getDamageValue());
            result += "\tYour health: " + this.getHealthPoints() + "\n";

        }

        if(this.getHealthPoints() <= 0){
            result += "You've been defeated... Better luck next time...☠";
        }
        return result;
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
}

