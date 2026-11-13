import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    Ball ball = new Ball(400, 75, 8);
    private ArrayList<Peg> pegs = new ArrayList<>();

    private void checkCollisions() {

        for (Peg peg : pegs) {

            double dx = ball.getX() - peg.getX();
            double dy = ball.getY() - peg.getY();

            double distance = Math.sqrt(dx * dx + dy * dy);
            double buffer = 4; // small buffer

            if (distance + buffer < ball.getRadius() + peg.getRadius()) {

                if (Math.random() < 0.5) {
                    ball.setVx(-2);
                    ball.setVy(-1);
                } else {
                    ball.setVx(2);
                    ball.setVy(-1);
                }

                ball.setVy(ball.getVy() * 0.8);
            }
        }

        if (ball.getY() > getHeight() - ball.getRadius()) {
            ball.setVy(0);
            ball.setVx(0);
            ball.setXY(400, 75);
        }
    }

    public GamePanel() {
        
        setBounds(0, 0, 820, 700);
        setBackground(Color.WHITE);

        for (int row = 0; row < 8; row++) {

            int pegsInRow = row + 1;

            for (int col = 0; col < pegsInRow; col++) {

                int x = 400 - row * 25 + col * 50;
                int y = 100 + row * 60;

                pegs.add(new Peg(x, y, 5));
            }
        }

        // 16 ms ≈ 60 FPS
        Timer timer = new Timer(16, e -> {
            ball.update();
            checkCollisions();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Peg peg : pegs) {
            peg.draw(g);
        }

        ball.draw(g);
    }
}