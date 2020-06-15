package com.tencent.ui.textui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SimpleGameFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 160;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 5;
    private static final String NAME = "Glory";

    private GamePanel mainPanel;

    public SimpleGameFrame() {
        super(NAME);
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new GamePanel();
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.init();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGameFrame frame = new SimpleGameFrame();
    }

    public GamePanel getMainPanel() {
        return mainPanel;
    }
}
