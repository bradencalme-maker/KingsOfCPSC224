import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window implements ActionListener {

    JFrame frame = new JFrame();
    JLabel title = new JLabel("Plinko");
    GamePanel gamePanel = new GamePanel();

    Window() {
        title.setBounds(350, 10, 200, 40);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(title);

        frame.add(gamePanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 700);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}