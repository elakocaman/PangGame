package project;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile {
    private double x, y;
    private final int width = 2;
    private final int height = 30;
    private final double speed = 8;

    public Projectile(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update() {
        y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, height);
    }

    public boolean isOffScreen() {
        return y + height < 0;
    }

    public double getX() {
        return x + width / 2.0;
    }

    public double getY() {
        return y;
    }
}
