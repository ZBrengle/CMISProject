package Life;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Being {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int sCounter = 0;
    public int sNum = 1;
    public Rectangle sArea;
    public int sAreaDefaultX, sAreaDefaultY;
    public boolean collisionOn = false;
}
