package CapitalistIsland.Locations.NormalLocations;

import CapitalistIsland.Game;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Game game) {
        super(game, "Safe House", 1);
    }

    @Override
    public void LocationCase() {
        this.setAlive(true);
        this.getGame().setHealth(this.getGame().getFirstHealth());
        this.getGame().setMoney(this.getGame().getMoney() - 3);
        System.out.println("\n======================");
        System.out.println("You are in safe house.\nYour health is full(" + this.getGame().getHealth()  + ").");
        System.out.println("Your damage is "  + this.getGame().getDamage() + ".");
        System.out.println("Your balance is " + this.getGame().getMoney() + " gold.");
        System.out.println("========================");

        System.out.println("\n========================");
        System.out.println("0) Out of the safe house" +
                "\n1) See inventory");
        System.out.println("========================");
        System.out.print("Please select what you want to do: ");
        int selectDo = input.nextInt();
        while(selectDo < 0 || selectDo > 1){
            System.out.print("You entered an invalid value, please enter a value between 0 and 1: ");
            selectDo = input.nextInt();
        }
        switch(selectDo){
            case 0:
                break;
            case 1:
                System.out.println("\n============================================");
                System.out.print("Your Weapons: ");
                for (int i = 0; i < ToolStore.weaponList.length; i++) {
                    if (ToolStore.weaponList[i].isHaveWeapon()){
                        System.out.print(ToolStore.weaponList[i].getName() + "\t\t");
                    }
                }
                System.out.print("\n\nYour Armors: ");
                for (int i = 0; i < ToolStore.armorList.length; i++) {
                    if (ToolStore.armorList[i].isHaveArmor()){
                        System.out.print(ToolStore.armorList[i].getName() + "\t\t");
                    }
                }
                System.out.println("\n============================================");
                break;
        }
    }
}
