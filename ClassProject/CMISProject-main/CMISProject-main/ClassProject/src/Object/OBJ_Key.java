package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends sObject{
    public OBJ_Key() {
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
