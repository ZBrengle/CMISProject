package Loop;

import Object.OBJ_Key;
import Object.OBJ_Door;
import Object.OBJ_Chest;


public class AssetHandler {
    GameWindow gw;

    public AssetHandler(GameWindow gw){
        this.gw = gw;
    }
    public void setObject(){
        gw.obj[0] = new OBJ_Key();
        gw.obj[0].worldX = 22 * gw.tileSize;
        gw.obj[0].worldY = 22 * gw.tileSize;

        gw.obj[1] = new OBJ_Key();
        gw.obj[1].worldX = 10 * gw.tileSize;
        gw.obj[1].worldY = 10 * gw.tileSize;

        gw.obj[2] = new OBJ_Door();
        gw.obj[2].worldX = 20 * gw.tileSize;
        gw.obj[2].worldY = 20 * gw.tileSize;

        gw.obj[3] = new OBJ_Door();
        gw.obj[3].worldX = 10 * gw.tileSize;
        gw.obj[3].worldY = 45 * gw.tileSize;

        gw.obj[4] = new OBJ_Chest();
        gw.obj[4].worldX = 3 * gw.tileSize;
        gw.obj[4].worldY =  43 * gw.tileSize;

        gw.obj[5] = new OBJ_Chest();
        gw.obj[5].worldX = 43 * gw.tileSize;
        gw.obj[5].worldY = 2 * gw.tileSize;

       ;
    }
}
