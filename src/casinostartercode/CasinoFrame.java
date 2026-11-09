package casinostartercode;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CasinoFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel splashPanel;
    private JPanel playerSelectPanel;

    public CasinoFrame() {
        this.setTitle("Bit Casino");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        splashPanel = new SplashPanel(this);

        this.add(mainPanel);
        playerSelectPanel = new PlayerSelectPanel(this);

        mainPanel.add(splashPanel, "SPLASH");
        mainPanel.add(playerSelectPanel, "PLAYER_SELECT");

        this.setVisible(true);
    }

    // Handles the mainPanel needing to switch between all other panels (cards)
    // Each panel needs to be refered to using screenName passed in during 
    // mainPanel.add(panelVar, screenName)
    public void showScreen(String screenName) {
        cardLayout.show(mainPanel, screenName);
    }

    public static void main(String[] args) {
        CasinoFrame casino = new CasinoFrame();

    }
}
