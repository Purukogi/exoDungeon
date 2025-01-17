package characters;

public class Adventurer extends Character {

    private int goldPieces;
    private int xCoord, yCoord;

    public Adventurer(int healthPoints, int damageValue, int goldPieces) {
        super(healthPoints, damageValue);
        this.goldPieces = goldPieces;
    }

    public void startFight(Monster monster){
        while(this.getHealthPoints() > 0){

            System.out.println("You hit " + monster.getName() + " for " + this.getDamageValue() +" damage!");
            monster.setHealthPoints(monster.getHealthPoints() - this.getDamageValue());
            System.out.println("\t" + monster.getName() + "'s health: " + monster.getHealthPoints());

            if(monster.getHealthPoints() <= 0){

                System.out.println("You won! " + monster.getName() + " is no more!");
                if (monster.isBoss()){
                    System.out.println("You defeated the boss of this dungeon! Congratulations !");
                    System.exit(0);
                }
                break;

            }

            System.out.println(monster.getName() + " hits you for " + monster.getDamageValue() + " damage!");
            this.setHealthPoints(this.getHealthPoints() - monster.getDamageValue());
            System.out.println("\tYour health: " + this.getHealthPoints());

        }

        if(this.getHealthPoints() <= 0){
            System.out.println("You've been defeated... Better luck next time...");
            System.exit(0);
        }

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

