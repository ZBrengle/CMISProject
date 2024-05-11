package Life;

import Loop.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Elder extends Being {

    GameWindow gw;
    private int screenX;
    private int screenY;

    public NPC_Elder(GameWindow gw) {
        super(gw);
        this.gw = gw;




        // Set default values
        speed = 2;
        direction = "down";

        // Load NPC sprite images
        getPlayerSprite();
        setDefaultValues();
    }
    public void setDefaultValues () {
        worldX = gw.tileSize * 10;
        worldY = gw.tileSize * 40;
        speed = 2;
        direction = "down";
    }
    // Load sprite images
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void constructDialogueTree() {
        // Create dialogue tree nodes
        DialogueNode node1 = new DialogueNode("Welcome to our village! How can I help you?");
        DialogueNode node2 = new DialogueNode("You need to find the magic crystal to save our village.");
        DialogueNode node3 = new DialogueNode("Be careful on your journey!");
        DialogueNode node4 = new DialogueNode("Thank you for your help.");

        // Connect nodes to form the dialogue tree
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);

        // Set the root node of the dialogue tree
        DialogueNode dialogueTreeRoot = node1;
    }

    // Inner class representing a node in the dialogue tree
    private class DialogueNode {
        private String dialogueText;
        private List children;

        public DialogueNode(String dialogueText) {
            this.dialogueText = dialogueText;
           // this.children = new ArrayList<>();
        }

        public void addChild(DialogueNode child) {
            children.add(String.valueOf(child));
        }

        //public List<DialogueNode> getChildren() {
         //   return children;
        }

       // public String getDialogueText() {
         //   return dialogueText;
        //}
   // }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        // Translate world coordinates to screen coordinates
        screenX = worldX - gw.maxWorldRow;
        screenY = worldY - gw.maxWorldCol;

        // Select the appropriate sprite based on direction
        switch (direction) {
            case "up":
                image = (sNum == 1) ? up1 : up2;
                break;
            case "down":
                image = (sNum == 1) ? down1 : down2;
                break;
            case "right":
                image = (sNum == 1) ? right1 : right2;
                break;
            case "left":
                image = (sNum == 1) ? left1 : left2;
                break;
        }

        // Draw the NPC at the calculated screen coordinates
        g2.drawImage(image, screenX, screenY, gw.tileSize, gw.tileSize, null);
    }
}