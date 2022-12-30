package CapitalistIsland;

import CapitalistIsland.Enemy.Bear;
import CapitalistIsland.Enemy.Enemy;
import CapitalistIsland.Enemy.Vampire;
import CapitalistIsland.Enemy.Zombie;
import CapitalistIsland.Locations.Location;
import CapitalistIsland.Locations.NormalLocations.SafeHouse;
import CapitalistIsland.Locations.NormalLocations.ToolStore;
import CapitalistIsland.Locations.WarLocation.Cave;
import CapitalistIsland.Locations.WarLocation.Forest;
import CapitalistIsland.Locations.WarLocation.River;
import CapitalistIsland.Warriors.Archer;
import CapitalistIsland.Warriors.Knight;
import CapitalistIsland.Warriors.Samurai;
import CapitalistIsland.Warriors.Warriors;

import java.util.Scanner;
public class Game {
    private String name;
    private int id;
    private int health;
    private int firstHealth;
    private int damage;
    private int money;
    private Inventory inventory = new Inventory();
    static Scanner input = new Scanner(System.in);
    public void start(){
        Enemy vampire = new Vampire();
        Enemy zombie = new Zombie();
        Enemy bear = new Bear();

        System.out.println("\nHi warrior... You are in an island. You need first some food to live here.\n" +
                "But do not forget, everything has a cost in this island.\n" +
                "You have to battle to some enemies to collect the items you can cook and make some money.\n" +
                "You can find lots of wood in forest and you must kill lords of the forest, vampires to collect wood.\n" +
                        "===================================\n" +
                        "Health of the " + vampire.getName() + " is " + vampire.getFirstHealth() + "." +
                        "\nDamage of the " + vampire.getName() + " is " + vampire.getDamage() + "." +
                        "\nEarning from the " + vampire.getName() + " is " + vampire.getEarning() + " gold." + "\n" +
                        "===================================\n\n" +
                "In order to find some meats like insects, you can go to cave. Be careful about zombies, do not let them eat you.\n" +
                        "===================================\n" +
                        "Health of the " + zombie.getName() + " is " + zombie.getFirstHealth() + "." +
                        "\nDamage of the " + zombie.getName() + " is " + zombie.getDamage() + "." +
                        "\nEarning from the " + zombie.getName() + " is " + zombie.getEarning() + " gold." + "\n" +
                        "===================================\n\n" +
                "You need some water to live, right? You can find water in the river but the bears in here are not circus bears.\n" +
                        "===================================\n" +
                        "Health of the " + bear.getName() + " is " + bear.getFirstHealth() + "." +
                        "\nDamage of the " + bear.getName() + " is " + bear.getDamage() + "." +
                        "\nEarning from the " + bear.getName() + " is " + bear.getEarning() + " gold." + "\n" +
                        "===================================\n\n" +
                "There might be between 1 and 3 enemies in each location.\n" +
                "You will need to some weapons and armors to kill your enemies, you can purchase them in tool store. Natives will be helped you.\n" +
                "If you need some rest, you can go safe house to make your health full. Cost of the every rest is 3 gold.");
        selectWarrior();
        selectLocation();
    }

    Warriors samurai = new Samurai();
    Warriors archer = new Archer();
    Warriors knight = new Knight();
    Warriors[] warriorList = {samurai, archer, knight};
    public void selectWarrior(){
        System.out.println("\n====================================================");
        for (Warriors i: warriorList){
            System.out.println(i.getId() + ") " +
                    "Warrior: " + i.getName() +
                    "\tHealth: " + i.getHealth() +
                    "\tDamage: " + i.getDamage() +
                    "\tGold: " + i.getMoney());
        }
        System.out.println("====================================================");
        System.out.print("\nIf you are ready, select a warrior to start the adventure: ");
        int selectWarrior = input.nextInt();

        while(selectWarrior < 1 || selectWarrior > warriorList.length){
            System.out.print("Please enter a valid value between 1 and " + warriorList.length + ": ");
            selectWarrior = input.nextInt();
        }
        switch (selectWarrior){
            case 1:
                initWarrior(new Samurai());
                break;
            case 2:
                initWarrior(new Archer());
                break;
            case 3:
                initWarrior(new Knight());
                break;
        }
        System.out.println("\nWelcome to this dangerous island " + this.name + ". Adventure starts...");

    }

    public void initWarrior(Warriors warriors){
        this.name = warriors.getName();
        this.id = warriors.getId();
        this.health = warriors.getHealth();
        this.firstHealth = warriors.getFirstHealth();
        this.damage = warriors.getDamage();
        this.money = warriors.getMoney();
    }


    Location safeHouse = new SafeHouse(this);
    Location toolStore = new ToolStore(this);
    Location forest = new Forest(this);
    Location cave = new Cave(this);
    Location river = new River(this);
    Location[] locationList = {safeHouse, toolStore, forest, cave, river};

    public void selectLocation(){

        Location location = null;
        while(true) {
            System.out.println("\n=======================");
            for (Location i : locationList) {
                System.out.println(i.getId() + ") " +
                        "Location: " + i.getName());
            }
            System.out.println("=======================");
            System.out.print("Please select the location you want to go: ");
            int selectLocation = input.nextInt();

            while (selectLocation < 1 || selectLocation > locationList.length) {
                System.out.print("\nPlease enter a valid value between 1 and " + locationList.length + ": ");
                selectLocation = input.nextInt();
            }
            switch (selectLocation) {
                case 1:
                    location = safeHouse;
                    break;
                case 2:
                    location = toolStore;
                    break;
                case 3:
                    location = forest;
                    break;
                case 4:
                    location = cave;
                    break;
                case 5:
                    location = river;
                    break;
            }

            location.LocationCase();

            if (this.getInventory().isFood() && this.getInventory().isWater() && this.getInventory().isWood()){
                System.out.println("YOU COLLECTED ALL ITEMS " + this.getName() + "\n!!YOU CAN COOK!!");
                break;
            }

            if (!location.isAlive()){
                System.out.println("!!GAME OVER!!");
                break;
            }
        }
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFirstHealth() {
        return firstHealth;
    }

    public void setFirstHealth(int firstHealth) {
        this.firstHealth = firstHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
