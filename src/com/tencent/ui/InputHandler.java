package com.tencent.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener {

    public class Key {
        private boolean pressed = false;

        public void toggle(boolean isPressed) {
            pressed = isPressed;
        }

        public boolean isPressed() {
            return pressed;
        }
    }

    private List<Key> keys = new ArrayList<>();

    public InputHandler(GameFrame gameFrame) {
        gameFrame.addKeyListener(this);
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();


    public void toggleKey(int keyCode, boolean isPressed) {
        if(keyCode == KeyEvent.VK_W) { up.toggle(isPressed);}
        if(keyCode == KeyEvent.VK_S) { down.toggle(isPressed);}
        if(keyCode == KeyEvent.VK_A) { left.toggle(isPressed);}
        if(keyCode == KeyEvent.VK_D) { right.toggle(isPressed);}
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        toggleKey(keyEvent.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        toggleKey(keyEvent.getKeyCode(), false);
    }
}
