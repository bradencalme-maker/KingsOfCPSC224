package games.roulette;

import javax.swing.JPanel;
import casinostartercode.CasinoFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.util.Arrays;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;


public class RoulettePanel extends JPanel{
    private final Image background = new ImageIcon(
        RoulettePanel.class.getResource("/games/roulette/images/retro-pixel-roulette.png")
    ).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
    public RoulettePanel(CasinoFrame frame){
        setLayout(new BorderLayout(0,0));

        JPanel gamePanel = new JPanel(new GridLayout(1,2,10,0));

        JPanel navigationPanel = new JPanel(new GridLayout(2,1,0,0));
        navigationPanel.setPreferredSize(new Dimension(50,50));

        JButton lobby = new JButton();
        lobby.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        navigationPanel.add(lobby);

        JButton quit = new JButton();
        quit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        navigationPanel.add(quit);

        JPanel playerStat = new JPanel(new GridLayout(1,4,0,0));
        JLabel gameName = new JLabel("GameName",JLabel.CENTER);
        JLabel names = new JLabel("Name",JLabel.CENTER);
        JLabel credits = new JLabel("Credits",JLabel.CENTER);
        JLabel tokens = new JLabel("tokens",JLabel.CENTER);
        gameName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        names.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        credits.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tokens.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        playerStat.add(gameName);
        playerStat.add(names);
        playerStat.add(credits);
        playerStat.add(tokens);


        JPanel spinnerPanel = new JPanel();
        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 150, 30));
        gamePanel.add(spinnerPanel);
        gamePanel.add(tablePanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;

        JPanel topOfTableLeft = new JPanel(new GridLayout(2,1,0,0));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 3;
        constraints.weighty = 1;
        tablePanel.add(topOfTableLeft, constraints);

        JPanel topOfTableRight = new JPanel(new GridLayout(3,13,0,0){
            @Override
            public void layoutContainer(java.awt.Container parent) {
                synchronized (parent.getTreeLock()) {
                    java.awt.Insets insets = parent.getInsets();

                    int width = parent.getWidth() - insets.left - insets.right;
                    int height = parent.getHeight() - insets.top - insets.bottom;

                    for (int i = 0; i < parent.getComponentCount(); i++) {
                        int column = i % 13;
                        int row = i / 13;

                        int left = column * width / 13;
                        int right = (column + 1) * width / 13;
                        int top = row * height / 3;
                        int bottom = (row + 1) * height / 3;

                        parent.getComponent(i).setBounds(
                            insets.left + left,
                            insets.top + top,
                            right - left,
                            bottom - top
                        );
                    }
                }
            }
        });

        constraints.gridx = 1;
        constraints.weightx = 7.5;
        tablePanel.add(topOfTableRight, constraints);



        JLabel doubleZero = new JLabel("00", JLabel.CENTER);
        doubleZero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topOfTableLeft.add(doubleZero);

        JLabel zero = new JLabel("0", JLabel.CENTER);
        zero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topOfTableLeft.add(zero);


        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.gridy = 0;

        JLabel[] squares = new JLabel[39];
        int count = 0;
        String name = "";
        String ist[] = {"rd","nd","st"};
        for (int i = 0; i < 3; i++){
            for (int column =0; column <= 11; column++){
                name = String.valueOf((column+1)*3 - i);
                JLabel label = new JLabel(name,JLabel.CENTER);
                squares[count] = label;
                count++;
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                topOfTableRight.add(label);
            }
            name = String.valueOf(3-i);
            JLabel label = new JLabel(name+ist[i],JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            topOfTableRight.add(label);
        }

        // int[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        // for(int i =0; i <39;i++){
        //     if(Arrays.asList(red).contains(i)){

        //     }
        // }
        
        JPanel bottomTopOfTable = new JPanel(new GridLayout(1,3,0,0));
        GridBagConstraints rangePosition = new GridBagConstraints();
        rangePosition.gridx = 1;
        rangePosition.gridy = 1;
        rangePosition.gridwidth = 1;
        rangePosition.weightx = 1;
        rangePosition.weighty = .15;
        rangePosition.fill = GridBagConstraints.BOTH;
        tablePanel.add(bottomTopOfTable, rangePosition);

        String[] bettingRanges = {"1-12","13-24","25-36"};
        for(int i = 0; i <3; i++){
            JLabel label = new JLabel(bettingRanges[i], JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bottomTopOfTable.add(label);
        }
        

        JPanel bottomBottomOfTable = new JPanel(new GridLayout(1,6,0,0));
        GridBagConstraints outsidePosition = new GridBagConstraints();
        outsidePosition.gridx = 1;
        outsidePosition.gridy = 2;
        outsidePosition.gridwidth = 1;
        outsidePosition.weightx = 7.5;
        outsidePosition.weighty = .15;
        outsidePosition.fill = GridBagConstraints.BOTH;
        tablePanel.add(bottomBottomOfTable, outsidePosition);


        String[] outsideBets = {"1-18","EVEN","","","ODD","19-36"};

        for(int i=0; i <2;i++){
            JLabel label = new JLabel(outsideBets[i], JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bottomBottomOfTable.add(label);
        }

        JLabel red = new JLabel("RED", JLabel.CENTER);
        red.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bottomBottomOfTable.add(red);

        JLabel black = new JLabel("BLACK", JLabel.CENTER);
        black.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bottomBottomOfTable.add(black);

        for(int i=4; i <6;i++){
            JLabel label = new JLabel(outsideBets[i], JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bottomBottomOfTable.add(label);
        }


        JPanel chipSelection = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chipSelection.setPreferredSize(new Dimension(100,100));


        add(gamePanel, BorderLayout.CENTER);
        add(chipSelection, BorderLayout.SOUTH);
        add(playerStat, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.WEST);

        // gamePanel.setOpaque(false);
        // spinnerPanel.setOpaque(false);
        // tablePanel.setOpaque(false);
        // topOfTableLeft.setOpaque(false);
        // topOfTableRight.setOpaque(false);
        // bottomTopOfTable.setOpaque(false);
        // bottomBottomOfTable.setOpaque(false);
        // chipSelection.setOpaque(false);
    }
    
}
