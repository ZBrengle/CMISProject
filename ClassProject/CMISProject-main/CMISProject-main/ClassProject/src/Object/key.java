package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class key extends sObject{
    public key() {
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
