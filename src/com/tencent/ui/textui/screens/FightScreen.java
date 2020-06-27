package com.tencent.ui.textui.screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FightScreen extends JPanel {

    private BufferedImage backgroundImage;

    private JPanel outputPanel = new JPanel();
    private JPanel optionsPanel = new JPanel();
    private JPanel charInfoPanel = new JPanel();
    private JPanel enemyInfoPanel = new JPanel();

    public FightScreen() {
        super();
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0, getWidth(), getHeight(), this);
    }

    public void init() {
        try {
            backgroundImage = ImageIO.read(LandingScreen.class.getResourceAsStream("/fight_scene_1.png"));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        charInfoPanel.setPreferredSize(new Dimension(200,35));
        charInfoPanel.setBackground(Color.RED);
        charInfoPanel.setVisible(true);

        enemyInfoPanel.setPreferredSize(new Dimension(200,35));
        enemyInfoPanel.setBackground(Color.BLUE);
        enemyInfoPanel.setVisible(true);

        outputPanel.setPreferredSize(new Dimension(500,200));
        outputPanel.setBackground(Color.GREEN);
        outputPanel.setVisible(true);

        optionsPanel.setPreferredSize(new Dimension(200,200));
        optionsPanel.setBackground(Color.YELLOW);
        optionsPanel.setVisible(true);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
                    .addComponent(charInfoPanel)
                    .addComponent(outputPanel)
            )
            .addGroup(layout.createParallelGroup()
                    .addComponent(enemyInfoPanel)
                    .addComponent(optionsPanel)
            )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
                    .addComponent(charInfoPanel)
                    .addComponent(enemyInfoPanel)
            )
            .addGap(250)
            .addGroup(layout.createParallelGroup()
                    .addComponent(outputPanel)
                    .addComponent(optionsPanel)
            )
        );

        layout.linkSize(charInfoPanel, enemyInfoPanel);
    }
}

//TODO : Rework hardcoded visual values (gaps...) to percentages and dynamic numbers
