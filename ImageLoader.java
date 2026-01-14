package project;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage background;
    public static BufferedImage foreground;
    public static BufferedImage player;
    public static BufferedImage[] balloons = new BufferedImage[4]; // XL, L, M, S

    static {
        try {
            // 🌆 Arka Plan: Londra (yaklaşık 7. satır, 1. sütun)
        	BufferedImage bgSheet = ImageIO.read(ImageLoader.class.getResource("/Backgrounds.png"));
        	background = bgSheet.getSubimage(0, 0, 320, 200);  // İlk sahne: Japonya



            // 🧍 Oyuncu
            BufferedImage playerSheet = ImageIO.read(ImageLoader.class.getResource("/Player.png"));
            player = playerSheet.getSubimage(0, 0, 32, 48);  // sol üstte ayakta duran poz


            // 🪵 Foreground (opsiyonel)
            foreground = ImageIO.read(ImageLoader.class.getResource("/Foreground.png"));

            // 🎈 Balonlar: kırmızı 4 boyut (tek satır üstte)
            BufferedImage balloonSprite = ImageIO.read(ImageLoader.class.getResource("/baloons.png"));
            balloons[0] = balloonSprite.getSubimage(0, 0, 40, 40);     // XL
            balloons[1] = balloonSprite.getSubimage(48, 0, 28, 28);    // L
            balloons[2] = balloonSprite.getSubimage(84, 0, 18, 18);    // M
            balloons[3] = balloonSprite.getSubimage(112, 0, 12, 12);   // S





            System.out.println("✅ ImageLoader loaded successfully!");

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("❌ Error loading images:");
            e.printStackTrace();
        }
    }
}
