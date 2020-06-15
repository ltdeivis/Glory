package com.tencent.ui.textui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private BufferedImage backgroundImage;

    private JButton playButton;
    private JButton attackButton;
    private JButton inventoryButton;
    private JTextArea outputArea;

    private JLabel playerIcon;
    private List<JLabel> enemyIcons = new ArrayList<>();

    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel northPanel;


    public GamePanel() {
        super();
        setupMainScreen();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0, getWidth(), getHeight(), this);
    }

    public void init() {
        centerPanel = new JPanel();
        centerPanel.setVisible(false);

        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(getWidth(), 200));
        southPanel.setVisible(false);

        northPanel = new JPanel();
        northPanel.setVisible(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(northPanel)
                                .addComponent(centerPanel)
                                .addComponent(southPanel)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(northPanel)
                        .addComponent(centerPanel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(southPanel)
                        )
        );

    }

    public void setupMainScreen() {
        try {
            backgroundImage = ImageIO.read(GamePanel.class.getResourceAsStream("/glory_bg.png"));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(240,60));
        playButton.setBackground(Color.RED);
        playButton.setForeground(Color.WHITE);
        playButton.setVisible(true);
        playButton.addActionListener(actionEvent -> {
            setupFightScene();
        });

        add(playButton);
    }

    public void setupFightScene() {
        try {
            backgroundImage = ImageIO.read(GamePanel.class.getResourceAsStream("/fight_scene_1.png"));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        remove(playButton);


        revalidate();
        repaint();
    }
    //TODO : Implement different panel for different scene, getScene() will return current scene panel
}
