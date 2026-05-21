//Player Demonstrates composition: A Player has an inventory


public class Player {

    // Private fields
    private String name;
    private Inventory inventory;

    //Constructor: sets players name and creates their inventory
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    //Inventory is used to store items on pickup
    public void pickUp(String item) {
        inventory.addItem(item);
    }

    public void showInventory() {
        inventory.showItems();
    }

}