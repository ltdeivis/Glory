package com.tencent.ui.textui.panels;

import com.tencent.ui.textui.uielements.HealthBar;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends JPanel {

    private HealthBar healthBar;

    public HealthPanel(String name, int hp, int maxHp) {
        super();
        setOpaque(false);
        setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel(name);
        nameLabel.setPreferredSize(new Dimension(0, 15));
        add(nameLabel, BorderLayout.NORTH);

        healthBar = new HealthBar(hp, maxHp);
        add(healthBar, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        HealthPanel hpPanel = new HealthPanel("Dio Doranto", 100, 100);
        hpPanel.setPreferredSize(new Dimension(200,35));
        frame.add(hpPanel);
        frame.pack();
    }


    //TODO : Override paintC and actually draw the hp bar
}
