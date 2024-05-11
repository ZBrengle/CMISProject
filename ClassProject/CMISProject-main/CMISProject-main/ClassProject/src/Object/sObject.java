package Object;

import Loop.GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class sObject {

    public BufferedImage image;
    public String name;

    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle sArea = new Rectangle(0,0,48,48);
    public int sAreaDefaultX = 0;
    public int sAreaDefaultY = 0;

    public void draw(Graphics2D g2, GameWindow gw){

        int screenX = worldX - gw.player.worldX + gw.player.screenX;
        int screenY = worldY - gw.player.worldY + gw.player.screenY;

        if (worldX + gw.tileSize > gw.player.worldX - gw.player.screenX &&
                worldX - gw.tileSize < gw.player.worldX + gw.player.screenX &&
                worldY + gw.tileSize > gw.player.worldY - gw.player.screenY &&
                worldY - gw.tileSize < gw.player.worldY + gw.player.screenY) {
            g2.drawImage(image,screenX,screenY,gw.tileSize,gw.tileSize,null);}
    }}
