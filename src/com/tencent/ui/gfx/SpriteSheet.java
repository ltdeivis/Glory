package com.tencent.ui.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpriteSheet {

    private String path;
    private int width;
    private int height;

    private int[] pixels;

    public SpriteSheet(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        if(image == null) {
            return;
        }

        this.path = path;
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = image.getRGB(0,0,width,height,null,0, width);

        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = (pixels[i] & 0xff) / 64; //Perform AND operation to remove Alpha channel
        }

        for(int i = 0; i < 8; i++) {
            System.out.println(pixels[i]);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }
}
