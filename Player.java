// Player.java
package project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
    private int x, y;
    private int speed = 5;
    private int width, height;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        BufferedImage img = ImageLoader.player;
        this.width = img.getWidth();
        this.height = img.getHeight();
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void update() {
        // Future logic for animation
    }

    public void draw(Graphics g) {
        g.drawImage(ImageLoader.player, x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
