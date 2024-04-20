package Loop;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Class Game");

        GameWindow gameWindow = new GameWindow();
        window.add(gameWindow);

        window.pack();

        window.setLocation(50,50);
        window.setVisible(true);

        gameWindow.startGameThread();
    }

}