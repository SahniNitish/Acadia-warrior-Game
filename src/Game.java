import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Acadia Warrior");
        GamePanel gamePanel = new GamePanel();
        
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        
        gamePanel.startGame();
    }
}