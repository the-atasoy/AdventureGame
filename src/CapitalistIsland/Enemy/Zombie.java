package CapitalistIsland.Enemy;

public class Zombie extends Enemy{
    public Zombie() {
        super("Zombie", 3, 10, 10, 4);
    }

    @Override
    public int randomEnemyAmount() {
        return (int)(Math.random() * 3) + 1;
    }
}
