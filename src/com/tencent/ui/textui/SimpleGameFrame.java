package com.tencent.ui.textui;

import com.tencent.ui.textui.screens.FightScreen;
import com.tencent.ui.textui.screens.LandingScreen;

import javax.swing.*;
import java.awt.*;

public class SimpleGameFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 160;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 5;
    private static final String NAME = "Glory";

    private LandingScreen landingScreen;
    private FightScreen fightScreen;

    public SimpleGameFrame() {
        super(NAME);
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        fightScreen = new FightScreen();

        landingScreen = new LandingScreen();
        add(landingScreen, BorderLayout.CENTER);

        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(240,60));
        playButton.setBackground(Color.RED);
        playButton.setForeground(Color.WHITE);
        playButton.setVisible(true);
        playButton.addActionListener(actionEvent -> {
            thisPanel().remove(landingScreen);
            thisPanel().add(fightScreen);
            thisPanel().revalidate();
            thisPanel().repaint();
        });

        landingScreen.add(playButton);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGameFrame frame = new SimpleGameFrame();
    }

    public LandingScreen getLandingScreen() {
        return landingScreen;
    }

    private JFrame thisPanel() {
        return this;
    }
}
