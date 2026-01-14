package project;

import java.awt.*;

public class Bonus {
    private int x, y;
    private BonusType type;
    private int speed = 3;

    public Bonus(int x, int y, BonusType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void update() {
        y += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawString(type.name(), x, y); // geçici yazı, sprite sonra
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }

    public BonusType getType() {
        return type;
    }

    public int getY() {
        return y;
    }
}
