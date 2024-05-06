package tile;

import Loop.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GameWindow gw;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GameWindow gw) {
        this.gw = gw;
        tile = new Tile [10];
        mapTileNum = new int[gw.maxWorldCol][gw.maxWorldRow];
        getTilePNG();
        loadMap("/maps/map01.txt");
    }

    public void getTilePNG(){

        try {
            tile [0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png"));

            tile [1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));
            tile[1].collision = true;

            tile [2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Dirt.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sand.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col < gw.maxWorldCol && row < gw.maxWorldRow){
                String line = br.readLine();
                while(col < gw.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gw.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception E) {
        }

    }
    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gw.maxWorldCol && worldRow < gw.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gw.tileSize;
            int worldY = worldRow * gw.tileSize;
            int screenX = worldX - gw.player.worldX + gw.player.screenX;
            int screenY = worldY - gw.player.worldY + gw.player.screenY;

            if (worldX + gw.tileSize > gw.player.worldX - gw.player.screenX &&
                    worldX - gw.tileSize < gw.player.worldX + gw.player.screenX &&
                    worldY + gw.tileSize > gw.player.worldY - gw.player.screenY &&
                    worldY - gw.tileSize < gw.player.worldY + gw.player.screenY) {
            g2.drawImage(tile[tileNum].image,screenX,screenY,gw.tileSize,gw.tileSize,null);}
            worldCol++;


            if(worldCol == gw.maxWorldCol) {
                worldCol = 0;

                worldRow++;

            }
        }
    }
}
