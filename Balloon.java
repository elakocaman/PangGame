// Balloon.java
package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Balloon {
    public enum Size {
        XLARGE, LARGE, MEDIUM, SMALL
    }

    private int x, y;
    private int dx = 2;
    private int dy = -4;
    private Size size;

    public Balloon(int x, int y, Size size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void update() {
        x += dx;
        y += dy;
        dy += 1; // gravity etkisi

        if (x <= 0 || x + getWidth() >= 800) {
            dx = -dx;
        }

        if (y + getHeight() >= 600) {
            y = 600 - getHeight();
            dy = -10;
        }
    }

    public void draw(Graphics g) {
        switch (size) {
            case XLARGE:
                g.drawImage(ImageLoader.balloons[0], x, y, null);
                break;
            case LARGE:
                g.drawImage(ImageLoader.balloons[1], x, y, null);
                break;
            case MEDIUM:
                g.drawImage(ImageLoader.balloons[2], x, y, null);
                break;
            case SMALL:
                g.drawImage(ImageLoader.balloons[3], x, y, null);
                break;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getWidth(), getHeight());
    }

    public int getWidth() {
        switch (size) {
            case XLARGE:
                return 64;
            case LARGE:
                return 48;
            case MEDIUM:
                return 32;
            case SMALL:
                return 24;
        }
        return 0;
    }

    public int getHeight() {
        return getWidth();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Size getSize() {
        return size;
    }
} 
