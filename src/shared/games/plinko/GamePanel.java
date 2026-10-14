import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    Ball ball = new Ball(400, 150);

    public GamePanel() {
        setBounds(0, 0, 820, 700);
        setBackground(Color.WHITE);

        // 16 ms ≈ 60 FPS
        Timer timer = new Timer(16, e -> {
            ball.update();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }
}