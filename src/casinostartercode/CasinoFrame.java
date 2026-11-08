package casinostartercode;
import javax.swing.JFrame;


public class CasinoFrame extends JFrame {

    public CasinoFrame() {
        this.setTitle("Bit Casino");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }


    public void main(String[] args) {
        CasinoFrame casino = new CasinoFrame();

    }
}
