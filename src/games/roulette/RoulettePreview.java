package games.roulette;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RoulettePreview {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Roulette Preview");

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setContentPane(new RoulettePanel(null));
            window.setSize(1000, 700);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}