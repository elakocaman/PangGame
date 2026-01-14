// GameLoop.java
package project;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLoop {
    private Player player;
    private ArrayList<Balloon> balloons;
    private ArrayList<Bullet> bullets;

    public GameLoop() {
        player = new Player(400, 500);
        bullets = new ArrayList<>();
        balloons = new ArrayList<>();

        // İlk büyük balon
        balloons.add(new Balloon(200, 100, Balloon.Size.XLARGE));
    }

    public void update() {
        player.update();

        for (Bullet bullet : bullets) {
            bullet.update();
        }

        for (Balloon balloon : balloons) {
            balloon.update();
        }

        checkCollisions();

        // Ekran dışındaki mermileri temizle
        bullets.removeIf(b -> b.getY() < 0);
    }

    private void checkCollisions() {
        Iterator<Bullet> bulletIt = bullets.iterator();
        while (bulletIt.hasNext()) {
            Bullet bullet = bulletIt.next();
            Iterator<Balloon> balloonIt = balloons.iterator();
            while (balloonIt.hasNext()) {
                Balloon balloon = balloonIt.next();
                if (bullet.getBounds().intersects(balloon.getBounds())) {
                    bulletIt.remove();
                    balloonIt.remove();
                    splitBalloon(balloon);
                    break;
                }
            }
        }
    }

    private void splitBalloon(Balloon balloon) {
        Balloon.Size size = balloon.getSize();
        int x = balloon.getX();
        int y = balloon.getY();
        if (size == Balloon.Size.XLARGE) {
            balloons.add(new Balloon(x, y, Balloon.Size.LARGE));
            balloons.add(new Balloon(x + 30, y, Balloon.Size.LARGE));
        } else if (size == Balloon.Size.LARGE) {
            balloons.add(new Balloon(x, y, Balloon.Size.MEDIUM));
            balloons.add(new Balloon(x + 20, y, Balloon.Size.MEDIUM));
        } else if (size == Balloon.Size.MEDIUM) {
            balloons.add(new Balloon(x, y, Balloon.Size.SMALL));
            balloons.add(new Balloon(x + 10, y, Balloon.Size.SMALL));
        }
        // SMALL balonlar bölünmez
    }

    public void drawAll(Graphics g) {
        player.draw(g);
        for (Balloon balloon : balloons) {
            balloon.draw(g);
        }
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
