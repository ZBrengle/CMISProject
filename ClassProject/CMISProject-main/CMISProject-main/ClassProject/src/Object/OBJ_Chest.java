package Object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Hashtable;

public class OBJ_Chest extends sObject{
    public OBJ_Chest() {
        name = "Chest";
        Hashtable<Object, Object> items = new Hashtable<>();

        // Add items to the chest
        items.put("Gold Coin", 10);
        items.put("Health Potion", 1);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Hashtable<String, Integer> getItems() {
        Hashtable<String, Integer> items = null;
        return items;
    }
}