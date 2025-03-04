import java.awt.Graphics;
import java.awt.Color;

public class Villain extends Character {
    private String type;
    private boolean attacking = false;
    private int attackDamage = 10;

    public Villain(int x, int y, String type) {
        super(x, y);
        this.type = type;
        loadAnimations("assets/villain/" + type.toLowerCase());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height); // Draw villain as a red square
    }

    @Override
    public void update() {
        // Simple AI to follow and attack the hero
        if (x > hero.x) {
            x -= 5;
            setState("Run");
        } else if (x < hero.x) {
            x += 5;
            setState("Run");
        }

        if (Math.abs(x - hero.x) < 50) {
            attack(hero);
        }
    }

    public void attack(Hero hero) {
        attacking = true;
        setState("Attack_1");
        hero.hurt(attackDamage);
    }

    public boolean isAttacking() {
        return attacking;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void reset() {
        x = 500;
        y = 300;
        health = 100;
        attacking = false;
    }
}
