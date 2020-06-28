package com.tencent.ui.textui.uielements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

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
        textField.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.WHITE));

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

    private boolean outputCanceled = false;
    private boolean getOutputCanceled() {
        return outputCanceled;
    }
    private void setOutputCanceled(boolean outputCanceled) {
        this.outputCanceled = outputCanceled;
    }
    public void addMesage(String msg) {
        try {
            char[] c = msg.toCharArray();

            new Timer().scheduleAtFixedRate(new TimerTask() {
                int counter = 0;

                @Override
                public void run() {
                    if(c.length <= 1) {
                        setOutputCanceled(true);
                        textArea.setText("");
                        this.cancel();
                        return;
                    }
                    if(getOutputCanceled()) {
                        if(counter < 1) {
                            setOutputCanceled(false);
                        }
                        else{
                            setOutputCanceled(false);
                            textArea.setText("");
                            textArea.append(new String(c));
                            textArea.append("\nPress Enter to continue...\n");
                            this.cancel();
                            return;
                        }
                    }
                    else {
                        textArea.append(String.valueOf(c[counter]));
                        counter++;
                        if(counter == c.length-1) {
                            textArea.append("\nPress Enter to continue...\n");
                            this.cancel();
                        }
                    }
                }
            }, 0, 50);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
