package CapitalistIsland.Tools.Armors;

public abstract class Armor {
    private String name;
    private int id;
    private int block;
    private int cost;
    private boolean haveArmor;

    public Armor(String name, int id, int block, int cost) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.cost = cost;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isHaveArmor() {
        return haveArmor;
    }

    public void setHaveArmor(boolean haveArmor) {
        this.haveArmor = haveArmor;
    }
}
