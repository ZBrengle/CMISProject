package Life;

import Loop.GameWindow;
import Loop.KeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MainCharacter extends Being {
    GameWindow gp;
    KeyInput keyI;

    public MainCharacter(GameWindow gp, KeyInput keyI) {
        this.gp = gp;
        this.keyI = keyI;
        setDefaultValues();
    }

        public void setDefaultValues () {
            x = 100;
            y = 100;
            speed = 4;
            direction = "down";
        }
        //IOhandling for sprites(Sprites not implemented yet)
        public void getPlayerSprite(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/character/maincharacter_left_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
            }



        public void update () {
            if (keyI.upPressed) {
                y -= speed;
                direction = "up";
            }
            if (keyI.downPressed) {
                y += speed;
                direction = "down";
            }
            if (keyI.rightPressed) {
                x += speed;
                direction = "right";
            }
            if (keyI.leftPressed) {
                x -= speed;
                direction = "left";
            }
        }
        public void draw (Graphics2D g2){
        g2.setColor(Color.white);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

//            BufferedImage image = null;

//            switch (direction) {
//                case "up":
//                    image = up1;
//                    break;
//                case "down":
//                    image = down1;
//                    break;
//                case "right":
//                    image = right1;
//                    break;
//                case "left":
//                    image = left1;
//                    break;
//            }
//            g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
        }

    }

