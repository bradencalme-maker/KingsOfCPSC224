package casinostartercode;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;


public class CasinoFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CasinoFrame() {
        this.setTitle("Bit Casino");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
    }



    public void main(String[] args) {
        CasinoFrame casino = new CasinoFrame();

    }
}
