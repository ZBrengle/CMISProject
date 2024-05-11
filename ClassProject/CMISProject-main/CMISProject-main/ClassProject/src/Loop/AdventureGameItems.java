package Loop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGameItems {
    public static void main(String[] args) {

        Map<String, List<String>> adventureItems = new HashMap<>();


        List<String> weapons = new ArrayList<>();
        weapons.add("Sword");
        weapons.add("Bow");
        weapons.add("Axe");
        adventureItems.put("Weapons", weapons);

        List<String> armor = new ArrayList<>();
        armor.add("Helmet");
        armor.add("Chestplate");
        armor.add("Shield");
        adventureItems.put("Armor", armor);

        List<String> medicine = new ArrayList<>();
        medicine.add("Health Potion");
        medicine.add("Antidote");
        medicine.add("Elixir");
        adventureItems.put("Medicine", medicine);

        // Display
        System.out.println("Weapons:");
        displayItems(adventureItems.get("Weapons"));

        System.out.println("\nArmor:");
        displayItems(adventureItems.get("Armor"));

        System.out.println("\nMedicine:");
        displayItems(adventureItems.get("Medicine"));
    }

    //  method to display items in a list
    private static void displayItems(List<String> items) {
        if (items != null) {
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
    }
}