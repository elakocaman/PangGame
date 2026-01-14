// GamePanel.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private GameLoop gameLoop;
    private boolean leftPressed, rightPressed, spacePressed;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        gameLoop = new GameLoop(new Player(300, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageLoader.background, 0, 0, getWidth(), getHeight(), this);

        if (gameLoop != null) {
            gameLoop.drawAll(g);
        }
    }

    public void update() {
        if (gameLoop != null) {
            if (leftPressed) {
                gameLoop.getPlayer().moveLeft();
            } else if (rightPressed) {
                gameLoop.getPlayer().moveRight();
            } else {
                gameLoop.getPlayer().stop();
            }

            if (spacePressed) {
                gameLoop.shoot();
                spacePressed = false; // sürekli atmasın diye
            }

            gameLoop.update();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // kullanılmıyor
    }
}
