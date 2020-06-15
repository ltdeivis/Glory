package com.tencent.ui;

import com.tencent.ui.gfx.Screen;
import com.tencent.ui.gfx.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GameFrame extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 160;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 5;
    private static final String NAME = "Glory";

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private boolean running = false;
    private int tickCount = 0;
    private JFrame frame;

    private Screen screen;
    private InputHandler input;

    public GameFrame() {
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void init() {
        screen = new Screen(WIDTH, HEIGHT,  new SpriteSheet("/sprite_sheet.png"));
        input = new InputHandler(this);
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        running = false;
    }

    public void run() {
        init();

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;

            while(delta >= 1) {
                ticks++;
                tick();
                delta--;
                shouldRender = true;
            }

            if(shouldRender) {
                frames++;
                render();
            }

            if(System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                System.out.println(frames + ", " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    private void tick() {
        tickCount++;

        if(input.up.isPressed()) { screen.setyOffset(screen.getyOffset() - 1);}
        if(input.down.isPressed()) { screen.setyOffset(screen.getyOffset() + 1);}
        if(input.left.isPressed()) { screen.setxOffset(screen.getxOffset() - 1);}
        if(input.right.isPressed()) { screen.setxOffset(screen.getxOffset() + 1);}


        //screen.setxOffset(screen.getxOffset() + 1);
        //screen.setyOffset(screen.getyOffset() + 1);
//        for(int i = 0; i < pixels.length; i++) {
//            pixels[i] = i + tickCount;
//        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.render(pixels, 0, WIDTH);

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }
}
