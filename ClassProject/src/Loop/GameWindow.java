package Loop;

import Life.MainCharacter;
import Object.sObject;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable {
    //settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int frames = 60;

    KeyInput keyI = new KeyInput();
    Thread gameThread;
// arrayList to hold objects displayed on the world map once I figure out how to make it work
   public sObject[] obj = new sObject[10];

    MainCharacter player = new MainCharacter(this,keyI);

    public GameWindow() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyI);
        this.setFocusable(true);
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

        player.draw(g2);

        g2.dispose();
    }
}
