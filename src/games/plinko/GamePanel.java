import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    Ball ball = new Ball(400, 75, 7);
    private final ArrayList<Peg> pegs = new ArrayList<>();

    private void checkCollisions() {

        for (Peg peg : pegs) {

            double dx = ball.getX() - peg.getX();
            double dy = ball.getY() - peg.getY();   

            double distance = Math.sqrt(dx * dx + dy * dy);
            double buffer = 4; // small buffer

            double xMultiplier = 1.2;
            double yMultiplier = -2;

            if (distance < ball.getRadius() + peg.getRadius() + buffer) {
                double impact_dx = ball.getX() - peg.getX();

                double impactPosition = impact_dx / (ball.getRadius() + peg.getRadius());

                double randomVariation = (Math.random() - 0.5) * 0.8;

                ball.setVx(impactPosition * xMultiplier + randomVariation);
                ball.setVy(yMultiplier - Math.random());
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

        int rows = 10;
        int spacingX = 50;
        int spacingY = 45;

        for (int row = 0; row < rows; row++) {

            int pegsInRow = 9;

            for (int col = 0; col < pegsInRow; col++) {

                int x = 200 + col * spacingX;

                // Offset every other row
                if (row % 2 == 1) {
                    x += spacingX / 2;
                }

                int y = 100 + row * spacingY;

                pegs.add(new Peg(x, y, 3));
            }
        }



        // 16 ms ≈ 60 FPS
        Timer timer = new Timer(16, e -> {
            for (int i = 0; i < 4; i++) {
                ball.update(0.25);
                checkCollisions();
            }

            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        // Dark Green Background
        g.setColor(Color.decode("#006400"));
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Peg peg : pegs) {
            peg.draw(g);
        }

        ball.draw(g);
    }
}