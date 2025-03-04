import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private Hero hero;
    private Villain villain;
    private int level = 1;
    private Image backgroundImage;
    private boolean gameOver;

    public GamePanel() {
        hero = new Hero(100, 300); // Hero starting position
        loadLevel(1); // Load level 1 (Samurai)

        timer = new Timer(16, this); // Roughly 60 FPS
        gameOver = false;

        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        loadBackground();
    }

    private void loadBackground() {
        try {
            backgroundImage = ImageIO.read(new File("assets/background/Battleground" + level + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLevel(int level) {
        this.level = level;
        if (level == 1) {
            villain = new Villain(500, 300, "Samurai");
        } else if (level == 2) {
            villain = new Villain(500, 300, "Shinobi");
        }
        loadBackground();  // Reload background when level changes
    }

    public void startGame() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }

        hero.draw(g);
        villain.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("Hero Health: " + hero.getHealth(), 10, 20);
        g.drawString("Villain Health: " + villain.getHealth(), 10, 40);

        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Press R to Restart", 300, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            hero.update();
            villain.updateAI(hero);
            checkCollision();
            repaint();

            if (villain.isDead()) {
                if (level == 1) {
                    loadLevel(2);  // Move to Level 2 if Samurai is defeated
                } else {
                    showWinMessage();
                }
            }

            if (hero.getHealth() <= 0) {
                gameOver = true;
            }
        }
    }

    private void checkCollision() {
        if (hero.getBounds().intersects(villain.getBounds())) {
            if (hero.isAttacking()) {
                villain.hurt(hero.getAttackDamage());
            }
            if (villain.isAttacking()) {
                hero.hurt(villain.getAttackDamage());
            }
        }
    }

    private void showWinMessage() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "You Win! Game Completed.");
        System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
            resetGame();
        } else {
            hero.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
    }

    private void resetGame() {
        hero.reset();
        loadLevel(1); // Start from level 1
        gameOver = false;
    }
}
