import java.awt.*;

public abstract class Character {
    protected int x, y;
    protected int health;
    protected String action = "Idle";
    protected int level = 1;  // Default level 1

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 100;
    }

    public abstract void draw(Graphics g);
    public abstract void update();

    public void setAction(String action) {
        this.action = action;
    }

    public int getLevel() {
        return level;
    }
}
