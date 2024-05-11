package Loop;

import Life.MainCharacter;
import Life.NPC_Elder;
import Object.sObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable {
    //settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 45;
    public final int maxWorldRow = 45;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    public int worldOffsetX;
    public int worldOffsetY;

    int frames = 60;

    TileManager tileM = new TileManager(this);

    KeyInput keyI = new KeyInput();
    Thread gameThread;

   public CollisionDetection detector = new CollisionDetection(this);
   public AssetHandler aSet = new AssetHandler(this);

    public MainCharacter player = new MainCharacter(this,keyI);
    public NPC_Elder Toto = new NPC_Elder(this);
    public sObject[] obj = new sObject[10];

    public GameWindow() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyI);
        this.setFocusable(true);
    }

    public void setGame(){
        aSet.setObject();
    }
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /frames;
        double drawTime = System.nanoTime() + drawInterval;


        while(gameThread != null){

            update();
            repaint();

            try{
                double remainingTime = drawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                drawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){

        player.update();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        int i;
        for(i = 0; i< obj.length; i++){
            if(obj[i] != null) {
                obj[i].draw(g2,this);
            }
        }
        Toto.draw(g2);
        player.draw(g2);


        g2.dispose();
    }
}
