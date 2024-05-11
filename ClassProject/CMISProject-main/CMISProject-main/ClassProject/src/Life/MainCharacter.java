package Life;

import Loop.GameWindow;
import Loop.KeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainCharacter extends Being {
    GameWindow gw;
    KeyInput keyI;

    public final int screenX;
    public final int screenY;
    int keyCount = 0;

    public MainCharacter(GameWindow gw, KeyInput keyI) {
        super(gw);
        this.gw = gw;
        this.keyI = keyI;

        screenX = gw.screenWidth/2 - (gw.tileSize/2);
        screenY = gw.screenHeight/2 - (gw.tileSize/2);


        sArea = new Rectangle();
        sArea.x = 8;
        sArea.y = 16;
        sAreaDefaultX = sArea.x;
        sAreaDefaultY = sArea.y;
        sArea.height = 32;
        sArea.width = 32;

        setDefaultValues();
        getPlayerSprite();


    }

        public void setDefaultValues () {
            worldX = gw.tileSize * 23;
            worldY = gw.tileSize * 23;
            speed = 2;
            direction = "down";
        }

            //IOhandling for sprite
            public void getPlayerSprite() {
                try {
                    up1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_up_1.png"));
                    up2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_up_2.png"));
                    down1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_down_1.png"));
                    down2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_down_2.png"));
                    right1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_right_1.png"));
                    right2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_right_2.png"));
                    left1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_left_1.png"));
                    left2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/maincharacter_left_2.png"));

                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

        public void update () {
            if(keyI.upPressed || keyI.downPressed || keyI.leftPressed || keyI.rightPressed){
            if (keyI.upPressed) {
                worldY -= speed;
                direction = "up";
            }
            if (keyI.downPressed) {
                worldY += speed;
                direction = "down";
            }
            if (keyI.rightPressed) {
                worldX += speed;
                direction = "right";
            }
            if (keyI.leftPressed) {
                worldX -= speed;
                direction = "left";
            }

                collisionOn = false;
                gw.detector.tileCheck(this);


                int objIndex = gw.detector.checkObject(this,true);

                if (collisionOn == false){
                    switch (direction) {
                        case "up" -> worldY -= speed;
                        case "down" -> worldY += speed;
                        case "left" -> worldX -= speed;
                        case "right" -> worldX += speed;
                    }
                }

            sCounter++;
            if(sCounter > 12){
                if(sNum==1){
                    sNum = 2;
                }
                else if (sNum ==2){
                    sNum = 1;
                }
                sCounter = 0;
            }}
            //check for collision

        }
        public void getObj(int i){
            if(i != 999){
                String objectName = gw.obj[i].name;
                switch(objectName){
                    case "Key":
                        keyCount++;
                        gw.obj[i] = null;
                        break;
                    case "Door":
                        if(keyCount > 0){
                            gw.obj[i] = null;
                            keyCount--;
                        }
                        System.out.println(keyCount + " are left.");
                        break;
                }
            }
        }
        public void draw (Graphics2D g2){


            BufferedImage image = null;

            switch (direction) {
                case "up":
                    if(sNum == 1) {
                        image = up1; }
                    if(sNum == 2) {
                        image = up2;}
                    break;
                case "down":
                    if(sNum == 1) {
                        image = down1; }
                    if(sNum == 2) {
                        image = down2;}
                    break;
                case "right":
                    if(sNum == 1) {
                        image = right1; }
                    if(sNum == 2) {
                        image = right2;}
                    break;
                case "left":
                    if(sNum == 1) {
                        image = left1; }
                    if(sNum == 2) {
                        image = left2;}
                    break;
            }
            g2.drawImage(image,screenX,screenY,gw.tileSize,gw.tileSize,null);
        }

    }

