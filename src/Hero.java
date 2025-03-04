import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Hero extends Character {
    private int speed = 5;
    private boolean movingLeft, movingRight;
    private boolean attacking = false;
    private int attackDamage = 20;

    public Hero(int x, int y) {
        super(x, y);
        loadAnimations("assets/hero");
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height); // Draw hero as a blue square
    }
    
    @Override
    public void update() {
        if (movingLeft) {
            x -= speed;
        }
        if (movingRight) {
            x += speed;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> movingLeft = true;
            case KeyEvent.VK_RIGHT -> movingRight = true;
            case KeyEvent.VK_SPACE -> attack();
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> movingLeft = false;
            case KeyEvent.VK_RIGHT -> movingRight = false;
        }
    }

    public void attack() {
        attacking = true;
        setState("Attack_1");
    }

    public boolean isAttacking() {
        return attacking;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void reset() {
        x = 100;
        y = 300;
        health = 100;
        movingLeft = false;
        movingRight = false;
        attacking = false;
    }
}