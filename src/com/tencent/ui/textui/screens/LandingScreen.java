package com.tencent.ui.textui.screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LandingScreen extends JPanel {

    private BufferedImage backgroundImage;

    public LandingScreen() {
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
            backgroundImage = ImageIO.read(LandingScreen.class.getResourceAsStream("/glory_bg.png"));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
