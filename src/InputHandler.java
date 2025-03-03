import java.awt.event.*;

public class InputHandler extends KeyAdapter {
    private Hero hero;

    public InputHandler(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> hero.setAction("Run");
            case KeyEvent.VK_LEFT -> hero.setAction("Walk");
            case KeyEvent.VK_SPACE -> hero.setAction("Jump");
            case KeyEvent.VK_A -> hero.setAction("Attack_1");
            case KeyEvent.VK_S -> hero.setAction("Attack_2");
            case KeyEvent.VK_D -> hero.setAction("Attack_3");
            case KeyEvent.VK_SHIFT -> hero.setAction("Shield");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.setAction("Idle");
    }
}
