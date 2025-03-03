import java.awt.*;

public class Villain extends Character {
    public Villain(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        // Simple AI - Later can add patrol, attack etc.
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Villain", x, y - 10);
        g.fillRect(x, y, 50, 50);
    }
}
