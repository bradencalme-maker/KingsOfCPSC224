import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private double x, y;
    private double vx = 0, vy = 0;
    private final int radius = 10;
    private final double gravity = 0.4;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        vy += gravity;
        x += vx;
        y += vy;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)(x - radius), (int)(y - radius), radius * 2, radius * 2);
    }
}