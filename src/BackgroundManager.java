import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundManager {
    private Image level1, level2;

    public BackgroundManager() {
        try {
            level1 = ImageIO.read(new File("assets/background/Battleground1.png"));
            level2 = ImageIO.read(new File("assets/background/Battleground2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, int level) {
        g.drawImage(level == 1 ? level1 : level2, 0, 0, 800, 600, null);
    }
}
