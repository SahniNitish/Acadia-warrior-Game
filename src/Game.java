import javax.swing.*;

/**
 * The Game class is the entry point for the Acadia Warrior Game application.
 * It sets up the main game window and starts the game.
 */
public class Game {
    /**
     * The main method creates the game window and starts the game.
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Acadia Warrior Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        gamePanel.startGame();
    }
}

