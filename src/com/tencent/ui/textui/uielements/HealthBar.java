package com.tencent.ui.textui.uielements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthBar extends JPanel {
    private String style = "Seperated";
    private int maxHealth = 100;
    private int currentHealth = 100;

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

        if(style.equals("Seperated")) {
            int hpSize = getWidth() / 10;
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
            int hpToDraw = (int) (((float)currentHealth / (float)maxHealth) * 10);
            for(int i = 0; i < hpToDraw; i++) {
                g2d.fillRect(cX, cY, hpSize - 1, getHeight() - 2);
                cX += hpSize;
            }
        } else if(style.equals("Full")) {
            g2d.drawRect(0,0,getWidth(),getHeight());

            g2d.setStroke(new BasicStroke(1));
            float hpSize = (float)getWidth() / 100;
            float percentHp = ((float)currentHealth / (float)maxHealth) * 100;
            if(percentHp >= 65) {
                g2d.setColor(Color.GREEN);
            } else if(percentHp >= 30) {
                g2d.setColor(Color.ORANGE);
            }
            else {
                g2d.setColor(Color.RED);
            }
            int hpWidth = Math.round(hpSize * percentHp);
            g2d.fillRect(1,1,hpWidth, getHeight() - 2);

        }
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setCurrentStyle(String style) {
        this.style = style;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JButton changeStyle = new JButton("Change Style");
        changeStyle.addActionListener(e -> {
            if(hpBar.style.equals("Seperated")) {
                hpBar.setCurrentStyle("Full");
            } else {
                hpBar.setCurrentStyle("Seperated");
            }
            hpBar.repaint();
        });
        frame.add(changeStyle);
        frame.pack();
    }
}
