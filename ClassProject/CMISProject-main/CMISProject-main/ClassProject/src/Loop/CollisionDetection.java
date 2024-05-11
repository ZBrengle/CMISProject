package Loop;

import Life.Being;

public class CollisionDetection {

   GameWindow gw;

    public CollisionDetection(GameWindow gw){
        this.gw = gw;
    }

    public void tileCheck(Being being) {
        int mcLWX = being.worldX + being.sArea.x;
        int mcRWX = being.worldX + being.sArea.x + being.sArea.width;
        int mcTWY = being.worldY + being.sArea.y;
        int mcBWY = being.worldY + being.sArea.y + being.sArea.height;

        int beingLeftCol = mcLWX/gw.tileSize;
        int beingRightCol = mcRWX/gw.tileSize;
        int beingTopRow = mcTWY/gw.tileSize;
        int beingBotRow = mcBWY/gw.tileSize;

        int tileNum1, tileNum2;

        switch(being.direction){
            case "up":
                beingTopRow = (mcTWY - being.speed)/gw.tileSize;
                tileNum1 = gw.tileM.mapTileNum[beingLeftCol][beingTopRow];
                tileNum2 = gw.tileM.mapTileNum[beingRightCol][beingTopRow];
                if (gw.tileM.tile[tileNum1].collision == true || gw.tileM.tile[tileNum2].collision ==true) {
                    being.collisionOn = true;
                }
                break;
            case "down":
                beingBotRow = (mcBWY + being.speed)/gw.tileSize;
                tileNum1 = gw.tileM.mapTileNum[beingLeftCol][beingBotRow];
                tileNum2 = gw.tileM.mapTileNum[beingRightCol][beingBotRow];
                if (gw.tileM.tile[tileNum1].collision == true|| gw.tileM.tile[tileNum2].collision ==true ) {
                    being.collisionOn = true;
                }
                break;
            case "right":
                beingRightCol = (mcRWX + being.speed)/gw.tileSize;
                tileNum1 = gw.tileM.mapTileNum[beingRightCol][beingTopRow];
                tileNum2 = gw.tileM.mapTileNum[beingRightCol][beingBotRow];
                if (gw.tileM.tile[tileNum1].collision == true || gw.tileM.tile[tileNum2].collision ==true) {
                    being.collisionOn = true;
                }
                break;
            case "left":
                beingLeftCol = (mcLWX - being.speed)/gw.tileSize;
                tileNum1 = gw.tileM.mapTileNum[beingLeftCol][beingTopRow];
                tileNum2 = gw.tileM.mapTileNum[beingLeftCol][beingBotRow];
                if (gw.tileM.tile[tileNum1].collision == true || gw.tileM.tile[tileNum2].collision == true) {
                    being.collisionOn = true;
                }
                break;


        }

    }
    public int checkObject(Being being, boolean player){
        int index = 999;
        for(int i = 0; i < gw.obj.length; i++) {
            if(gw.obj[i]!=null){
                being.sArea.x = being.worldX + being.sArea.x;
                being.sArea.y = being.worldY + being.sArea.y;

                gw.obj[i].sArea.x = gw.obj[i].worldX + gw.obj[i].sArea.x;
                gw.obj[i].sArea.y = gw.obj[i].worldY + gw.obj[i].sArea.y;

                switch(being.direction){
                    case "up":
                        being.sArea.y -= being.speed;
                        if(being.sArea.intersects(gw.obj[i].sArea)){
                            if (gw.obj[i].collision==true) {
                                being.collisionOn=true;
                            }
                            if(player == true){
                                index=i;
                            }
                        }
                        break;
                    case "down":
                        being.sArea.y += being.speed;
                        if(being.sArea.intersects(gw.obj[i].sArea)) {
                            if (gw.obj[i].collision==true) {
                                being.collisionOn=true;
                            }
                            if(player == true){
                                index=i;
                            }
                        }
                        break;
                    case "right":
                        being.sArea.x += being.speed;
                        if(being.sArea.intersects(gw.obj[i].sArea)) {
                            if (gw.obj[i].collision==true) {
                                being.collisionOn=true;
                            }
                            if(player == true){
                                index=i;
                            }
                        }
                        break;
                    case "left":
                        being.sArea.x -= being.speed;
                        if(being.sArea.intersects(gw.obj[i].sArea)) {
                            if (gw.obj[i].collision==true) {
                                being.collisionOn=true;
                            }
                            if(player == true){
                                index=i;
                            }
                        }
                        break;
                }

            being.sArea.x =  being.sAreaDefaultX;
            being.sArea.y = being.sAreaDefaultY;

            gw.obj[i].sArea.x = gw.obj[i].sAreaDefaultX;
            gw.obj[i].sArea.y = gw.obj[i].sAreaDefaultY;
        }}

        return index;
    }
}
