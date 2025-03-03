import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Hero hero;
    private Villain villain;
    private BackgroundManager backgroundManager;

    public GamePanel() {
        setFocusable(true);
        requestFocus();
        hero = new Hero(100, 400);
        villain = new Villain(600, 400);
        backgroundManager = new BackgroundManager();
        addKeyListener(new InputHandler(hero));
        timer = new Timer(16, this);
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hero.update();
        villain.update();  // Add AI logic later
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        backgroundManager.draw(g, hero.getLevel());
        hero.draw(g);
        villain.draw(g);
    }
}
