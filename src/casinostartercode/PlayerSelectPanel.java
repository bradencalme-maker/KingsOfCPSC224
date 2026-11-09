package casinostartercode;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerSelectPanel extends JPanel {
    public PlayerSelectPanel(CasinoFrame frame) {
        super(new GridLayout(6, 1, 0, 12));
        setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        JLabel gameMessage = new JLabel("Enter Player Names!", JLabel.CENTER);
        JTextField playerOne = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if (getText().isEmpty()){
                    g.setColor(Color.gray);
                    g.setFont(getFont());

                    FontMetrics font = g.getFontMetrics();
                    int x = getInsets().left;
                    int y = (getHeight() - font.getHeight()) / 2 + font.getAscent();

                    g.drawString("Enter Player One Name:", x, y);
                }
            }
        };
        JTextField playerTwo = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if (getText().isEmpty()){
                    g.setColor(Color.gray);
                    g.setFont(getFont());

                    FontMetrics font = g.getFontMetrics();
                    int x = getInsets().left;
                    int y = (getHeight() - font.getHeight()) / 2 + font.getAscent();

                    g.drawString("Enter Player Two Name:", x, y);
                }
            }
        };
        playerTwo.setVisible(false);
        JTextField playerThree = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if (getText().isEmpty()){
                    g.setColor(Color.gray);
                    g.setFont(getFont());

                    FontMetrics font = g.getFontMetrics();
                    int x = getInsets().left;
                    int y = (getHeight() - font.getHeight()) / 2 + font.getAscent();

                    g.drawString("Enter Player Three Name:", x, y);
                }
            }
        };
        playerThree.setVisible(false);
        JTextField playerFour = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if (getText().isEmpty()){
                    g.setColor(Color.gray);
                    g.setFont(getFont());

                    FontMetrics font = g.getFontMetrics();
                    int x = getInsets().left;
                    int y = (getHeight() - font.getHeight()) / 2 + font.getAscent();

                    g.drawString("Enter Player Four Name:", x, y);
                }
            }
        };
        playerFour.setVisible(false);


        playerOne.addActionListener(event -> {
            if (playerOne.getText().isEmpty()){
                playerTwo.setText("");
                playerTwo.setVisible(false);
                playerThree.setText("");
                playerThree.setVisible(false);
                playerFour.setText("");
                playerFour.setVisible(false);
            }else{
                String playerOneName = playerOne.getText().trim();
                playerTwo.setVisible(true);
            }
        });

        playerTwo.addActionListener(event -> {
            if (playerTwo.getText().isEmpty()){
                playerThree.setText("");
                playerThree.setVisible(false);
                playerFour.setText("");
                playerFour.setVisible(false);
            }else{
                playerThree.setVisible(true);
                String playerTwoName = playerTwo.getText().trim();
            }
        });

        playerThree.addActionListener(event -> {
            if (playerThree.getText().isEmpty()){
                playerFour.setText("");
                playerFour.setVisible(false);
            }else{
                playerFour.setVisible(true);
                String playerThreeName = playerThree.getText().trim();
            }
        });

        playerFour.addActionListener(event -> {
            if (playerFour.getText().isEmpty()){
            }else{
                String playerFourName = playerFour.getText().trim();
            }
        });

        JButton startGame = new JButton("Confirm Players");

        startGame.addActionListener(event -> frame.showScreen("LOBBY"));

        add(gameMessage);
        add(playerOne);
        add(playerTwo); 
        add(playerThree);
        add(playerFour);
        add(startGame);
    }
}