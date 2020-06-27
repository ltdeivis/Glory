package com.tencent.ui.textui.uielements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextOutput extends JPanel {

    private JTextField textField;
    private JTextArea textArea;

    public TextOutput() {
        super();
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GREEN);

        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setEditable(false);

        add(textArea, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addMesage(textField.getText() + "\n");
                    textField.setText("");
                }
            }
        });
    }

    public void addMesage(String msg) {
        textArea.append(msg);
    }
}
