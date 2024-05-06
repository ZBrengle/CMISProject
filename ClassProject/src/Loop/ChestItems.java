package Loop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChestItems {
    public static void main(String[] args) {
        // HashMap
        Map<String, String> chestItems = new HashMap<>();

        // Add items
        chestItems.put("sword", "Steel Sword");
        chestItems.put("shield", "Iron Shield");
        chestItems.put("potion", "Health Potion");
        chestItems.put("gold", "100 Gold Coins");

        // Prompt
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item you want to search: ");
        String searchItem = scanner.nextLine().toLowerCase(); // Convert to lowercase

        //  search
        if (chestItems.containsKey(searchItem)) {
            System.out.println("Item found: " + chestItems.get(searchItem));
        } else {
            System.out.println("Item not found.");
        }

        // Close scanner
        scanner.close();
    }
}