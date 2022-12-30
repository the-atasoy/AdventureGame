package CapitalistIsland.Enemy;

public class Vampire extends Enemy{
    public Vampire() {
        super("Vampire", 4, 14, 14, 7);
    }
    @Override
    public int randomEnemyAmount() {
        return (int)(Math.random() * 3) + 1;
    }
}
