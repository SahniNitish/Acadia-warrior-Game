import java.awt.*;

public class Hero extends Character {
    private int speed = 5;

    public Hero(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        if (action.equals("Run")) x += speed;
        if (action.equals("Walk")) x += speed / 2;
        if (action.equals("Jump")) y -= 15;
        if (x > 700) level = 2;  // Advance to next level
        if (y < 400) y += 5;  // Gravity
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawString("Hero (" + action + ")", x, y - 10);
        g.fillRect(x, y, 50, 50);
    }
}
