package AdventureGame.Locations.NormalLocations;

import AdventureGame.Game;
import AdventureGame.Tools.Armors.Armor;
import AdventureGame.Tools.Armors.BodyArmor;
import AdventureGame.Tools.Armors.FullArmor;
import AdventureGame.Tools.Armors.Helmet;
import AdventureGame.Tools.Weapons.Gun;
import AdventureGame.Tools.Weapons.Rifle;
import AdventureGame.Tools.Weapons.Sword;
import AdventureGame.Tools.Weapons.Weapon;

public class ToolStore extends NormalLocation{

    public ToolStore(Game game) {
        super(game,"Tool Store", 2);
    }

    @Override
    public void LocationCase() {
        System.out.println("\nYou are in tool store.");
        System.out.println("====================");
        System.out.println("0) Out of tool store" +
                "\n1) Purchase weapon" +
                "\n2) Purchase armor");
        System.out.println("====================");
        System.out.print("Please select what you want to do: ");
        int selectTool = input.nextInt();
        while(selectTool < 0 || selectTool > 4){
            System.out.print("You entered an invalid value, please enter a value between 1 and 3: ");
            selectTool = input.nextInt();
        }

        switch (selectTool){
            case 0:
                break;
            case 1:
                System.out.println("\n*****  Balance: " + getGame().getMoney() + " gold *****");
                selectWeapon();
                break;
            case 2:
                System.out.println("\n*****  Balance: " + getGame().getMoney() + " gold *****");
                selectArmor();
                break;
        }
        this.setAlive(true);
    }

    private static Weapon gun = new Gun();
    private static Weapon sword = new Sword();
    private static Weapon rifle = new Rifle();

    static Weapon[] weaponList = {gun, sword, rifle};
    private void haveWeapon(){
        for (int i = 0; i < weaponList.length; i++) {
            weaponList[i].setHaveWeapon(false);
        }
    }

    public void selectWeapon(){
        Weapon weapon = null;
        System.out.println("=====================WEAPONS====================");
        System.out.println("0)\tOut of weapon store");
        for (Weapon i : weaponList){
            System.out.println(i.getId() + ")" +
                    "\tWeapon: " + i.getName() +
                    "\t\tDamage: " + i.getDamage() +
                    "\t\tCost: " + i.getCost());
        }
        System.out.println("================================================");
        System.out.print("Select a weapon: ");
        int selectWeapon = input.nextInt();
        while(selectWeapon < 0 || selectWeapon > weaponList.length){
            System.out.print("You entered an invalid value, please enter a value between 0 and " + weaponList.length + ": ");
            selectWeapon = input.nextInt();
        }
        // Weapon selection by id
        for (int i = 0; i < weaponList.length ; i++) {
            if (selectWeapon == weaponList[i].getId()){
                weapon = weaponList[i];
            }
        }
        if (selectWeapon == 0){
            LocationCase();
        }
        else if (weapon.getCost() > this.getGame().getMoney()){
            System.out.println("Get out of here, don't come here again without money.");
        }
        else if(!weapon.isHaveWeapon()){
            System.out.println(weapon.getName() + " was purchased.");
            int balance = this.getGame().getMoney() - weapon.getCost();
            this.getGame().setMoney(balance);
            int newDamage = this.getGame().getDamage() + weapon.getDamage();
            this.getGame().setDamage(newDamage);
            System.out.println("Your balance is " + this.getGame().getMoney() + " gold and your damage is " +
                     newDamage + " now " + this.getGame().getName() + ".");
            weapon.setHaveWeapon(true);
        } else if (weapon.isHaveWeapon()) {
            System.out.println("You've already have a " + weapon.getName() + ", you cannot buy same weapon.");
        }

    }

    private static Armor helmet = new Helmet();
    private static Armor bodyArmor = new BodyArmor();
    private static Armor fullArmor = new FullArmor();
    public static Armor[] armorList = {helmet, bodyArmor, fullArmor};

    private void haveArmor(){
        for (int i = 0; i < armorList.length; i++) {
            armorList[i].setHaveArmor(false);
        }
    }

    public void selectArmor(){
        Armor armor = null;
        System.out.println("========================ARMORS=======================");
        System.out.println("0)\tOut of armor store");
        for (Armor i : armorList){
            System.out.println(i.getId() + ")" +
                    "\tArmor: " + i.getName() +
                    "\t\tBlock: " + i.getBlock() +
                    "\t\tCost: " + i.getCost());
        }
        System.out.println("====================================================");
        System.out.print("Select an armor: ");
        int selectArmor = input.nextInt();
        while(selectArmor < 0 || selectArmor > armorList.length){
            System.out.print("You entered an invalid value, please enter a value between 0 and " + armorList.length + ": ");
            selectArmor = input.nextInt();
        }
        // Armor selection by id
        for (int i = 0; i < armorList.length ; i++) {
            if (selectArmor == armorList[i].getId()){
                armor = armorList[i];
            }
        }
        if (selectArmor == 0){
            LocationCase();
        }
        else if(armor.getCost() > this.getGame().getMoney()){
            System.out.println("Get out of here, don't come here again without money.");
        }
        else if(!armor.isHaveArmor()){
            System.out.println(armor.getName() + " was purchased.");
            int balance = this.getGame().getMoney() - armor.getCost();
            this.getGame().setMoney(balance);
            int currentHealth = this.getGame().getHealth() + armor.getBlock();
            this.getGame().setHealth(currentHealth);
            int newHealth = this.getGame().getFirstHealth() + armor.getBlock();
            this.getGame().setFirstHealth(newHealth);
            System.out.println("Your balance is " + this.getGame().getMoney() + " gold and your health is " +
                    currentHealth + " now " + this.getGame().getName() + ".");
            armor.setHaveArmor(true);
        } else if (armor.isHaveArmor()) {
            System.out.println("You've already have a " + armor.getName() + ", you cannot buy same armor.");
        }

    }
}
