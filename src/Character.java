import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public abstract class Character {
    protected int x, y;
    protected int health = 100;
    protected String state = "Idle";  // Possible: Idle, Run, Attack, Hurt, Dead
    protected Image currentImage;
    protected Map<String, Image> animations = new HashMap<>();
    protected int width = 50, height = 50; // Size of the character

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void loadAnimations(String folder) {
        try {
            animations.put("Idle", loadImage(folder + "/Idle.png"));
            animations.put("Run", loadImage(folder + "/Run.png"));
            animations.put("Attack_1", loadImage(folder + "/Attack_1.png"));
            animations.put("Hurt", loadImage(folder + "/Hurt.png"));
            animations.put("Dead", loadImage(folder + "/Dead.png"));
            System.out.println("Animations loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Image loadImage(String path) throws IOException {
        System.out.println("Loading image: " + path);
        return ImageIO.read(new File(path));
    }

    public void setState(String state) {
        this.state = state;
        currentImage = animations.get(state);
        System.out.println("State set to: " + state);
    }

    public void draw(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, x, y, width, height, null);
        } else {
            System.out.println("Current image is null for state: " + state);
        }
        drawHealthBar(g);
    }

    private void drawHealthBar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y - 10, 100, 5);
        g.setColor(Color.GREEN);
        g.fillRect(x, y - 10, health, 5);
    }

    public void update() {
        // Update character state if needed
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}