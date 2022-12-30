package CapitalistIsland.Warriors;

public abstract class Warriors {
    private int id;
    private int health;
    private int firstHealth;
    private int damage;
    private int money;
    private String name;

    public Warriors(int id, int health, int firstHealth, int damage, int money, String name) {
        this.id = id;
        this.health = health;
        this.firstHealth = firstHealth;
        this.damage = damage;
        this.money = money;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
