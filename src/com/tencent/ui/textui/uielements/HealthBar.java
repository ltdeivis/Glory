package com.tencent.ui.textui.uielements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthBar extends JPanel {
    private int maxHealth = 10;
    private int currentHealth = 5;

    public HealthBar() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);

        int hpSize = getWidth() / maxHealth;
        int cX = 0;
        int cY = 0;
        for(int i = 0; i < maxHealth; i++) {
            g2d.drawRect(cX, cY, hpSize, getHeight());
            cX += hpSize;
        }

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.GREEN);
        cX = 1;
        cY = 1;
        for(int i = 0; i < currentHealth; i++) {
            g2d.fillRect(cX, cY, hpSize - 1, getHeight() - 1);
            cX += hpSize;
        }
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400,400));
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        HealthBar hpBar = new HealthBar();
        hpBar.setPreferredSize(new Dimension(150, 20));
        frame.add(hpBar);
        JButton btn = new JButton("Do damage");
        btn.addActionListener(e -> {
            hpBar.setCurrentHealth(hpBar.currentHealth - 1);
            hpBar.repaint();
        });
        frame.add(btn);
        frame.pack();
    }
}
