package com.tencent.ui.textui.panels;

import com.tencent.ui.textui.uielements.TextOutput;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    public OutputPanel() {
        super();
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        TextOutput output = new TextOutput();

        add(output, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        OutputPanel outputPanel = new OutputPanel();
        outputPanel.setPreferredSize(new Dimension(200,140));
        frame.add(outputPanel);
        frame.pack();
    }
}
