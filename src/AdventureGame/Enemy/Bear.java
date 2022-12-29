package AdventureGame.Enemy;

public class Bear extends Enemy{
    public Bear() {
        super("Bear", 7, 20, 20, 12);
    }

    @Override
    public int randomEnemyAmount() {
        return (int)(Math.random() * 3) + 1;
    }
}
