import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private Hero hero;

    public InputHandler(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        hero.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.keyReleased(e);
    }
}
