package Loop;
import java.util.ArrayList;

public class UserInventory {
    private ArrayList<String> items;

    public UserInventory() {
        items = new ArrayList<>();
    }


    public void addItem(String item) {
        items.add(item);
    }


    public void removeItem(String item) {
        items.remove(item);
    }


    public void sortInventory() {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items.get(j).compareTo(items.get(j + 1)) > 0) {
                    // Swap items
                    String temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }

    // Print items in the inventory
    public void displayInventory() {
        System.out.println("Inventory:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        // Create user inventory
        UserInventory inventory = new UserInventory();

        // Add items to the inventory
        inventory.addItem("Health Potion");
        inventory.addItem("Steel Sword");
        inventory.addItem("Iron Shield");
        inventory.addItem("100 Gold Coins");


        System.out.println("Unsorted inventory:");
        inventory.displayInventory();


        inventory.sortInventory();


        System.out.println("Sorted inventory:");
        inventory.displayInventory();
    }
}