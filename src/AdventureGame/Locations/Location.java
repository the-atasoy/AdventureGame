package AdventureGame.Locations;

import AdventureGame.Game;
import AdventureGame.Inventory;

import java.util.Scanner;

public abstract class Location {
    private Game game;
    private String name;
    private int id;
    private boolean isAlive;
    protected static Scanner input = new Scanner(System.in);
    public Location(Game game, String name, int id) {
        this.game = game;
        this.name = name;
        this.id = id;
    }


    public abstract void LocationCase();

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
