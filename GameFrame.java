package project;// GameFrame.java
import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Pang Arcade Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        GamePanel gamePanel = new GamePanel();
        setJMenuBar(new PangMenuBar(gamePanel));
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
