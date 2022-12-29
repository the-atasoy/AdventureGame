package AdventureGame.Locations.WarLocation;

import AdventureGame.Enemy.Enemy;
import AdventureGame.Enemy.Zombie;
import AdventureGame.Game;

public class Cave extends WarLocation{
    public Cave(Game game) {
        super(game, "Cave", 4);
    }

    Enemy enemy = new Zombie();

    @Override
    public void LocationCase() {

        this.setAlive(true);
        for (int i = 1; i <= this.enemy.randomEnemyAmount(); i++) {
            int whoStarts = (int)(Math.random() * 2) + 1;
            if (i == 1) {
                System.out.println("\n****  A " + this.enemy.getName() + " is coming  ****");
            }
            else{
                System.out.println("\n****  Another " + this.enemy.getName() + " is coming  ****");
            }
            if (whoStarts == 1){
                while(true){
                    System.out.println("\n==============================");
                    System.out.println("You attacked.");
                    this.enemy.setHealth(this.enemy.getHealth() - this.getGame().getDamage());
                    int healthEnemy = this.enemy.getHealth();
                    if (healthEnemy <= 0){
                        System.out.println("You killed the " + this.enemy.getName() + ".");
                        this.getGame().setMoney(this.getGame().getMoney() + this.enemy.getEarning());
                        System.out.println("Your balance is " + this.getGame().getMoney() + " gold " + this.getGame().getName() + ".");
                        System.out.println("==============================");
                        break;
                    }
                    System.out.println("Health of the " + this.enemy.getName() + " is " + healthEnemy + ".");
                    System.out.println("=============================");

                    System.out.println("\n==============================");
                    System.out.println("The " + this.enemy.getName() + " attacked.");
                    this.getGame().setHealth(this.getGame().getHealth() - this.enemy.getDamage());
                    int healthWarrior = this.getGame().getHealth();
                    if (healthWarrior <= 0){
                        this.setAlive(false);
                        break;
                    }
                    System.out.println("Your health is " + healthWarrior + ".");
                    System.out.println("==============================");
                }
            } else if (whoStarts == 2) {
                while(true){
                    System.out.println("\n==============================");
                    System.out.println("The " + this.enemy.getName() + " attacked.");
                    this.getGame().setHealth(this.getGame().getHealth() - this.enemy.getDamage());
                    int healthWarrior = this.getGame().getHealth();
                    if (healthWarrior <= 0){
                        this.setAlive(false);
                        break;
                    }
                    System.out.println("Your health is " + healthWarrior + ".");
                    System.out.println("==============================");

                    System.out.println("\n==============================");
                    System.out.println("You attacked.");
                    this.enemy.setHealth(this.enemy.getHealth() - this.getGame().getDamage());
                    int healthEnemy = this.enemy.getHealth();
                    if (healthEnemy <= 0){
                        System.out.println("You killed the " + this.enemy.getName() + ".");
                        this.getGame().setMoney(this.getGame().getMoney() + this.enemy.getEarning());
                        System.out.println("Your balance is " + this.getGame().getMoney() + " gold.");
                        System.out.println("==============================");
                        break;
                    }
                    System.out.println("Health of the " + this.enemy.getName() + " is " + healthEnemy + ".");
                    System.out.println("=============================");
                }
            }
            this.enemy.setHealth(this.enemy.getFirstHealth());
        }
        if (this.isAlive()){
            System.out.println("\n=============================");
            System.out.println("You killed all enemies in the " + this.getName() + " " + this.getGame().getName() + "." +
                    "\nYou got the food.");
            System.out.println("=============================");

            this.getGame().getInventory().setFood(true);
        }
    }

}
