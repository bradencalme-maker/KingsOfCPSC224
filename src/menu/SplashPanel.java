package menu;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashPanel extends JPanel {
    
    public SplashPanel(CasinoFrame frame) {
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("src/menu/assets/StartingBackgroundImage.png");
        
        // Scale the image to 1000 x 700
        Image scaledImage = icon.getImage().getScaledInstance(
        1000, 700, Image.SCALE_SMOOTH
        );

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Start constructing the background label
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(scaledIcon);
        backgroundLabel.setBounds(0, 0, 1000, 700);


        // Start constructing the start button
        JButton startButton = new JButton();
        startButton.setBounds(320, 450, 360, 110);

        // Makes the start button invisible
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);

        // Call CasinoFrame to switch to player entry panel
        startButton.addActionListener(e -> {
            frame.showScreen("PLAYER_SELECT");
        });

        this.add(startButton);
        this.add(backgroundLabel);
    }
}
