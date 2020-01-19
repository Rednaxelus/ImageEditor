package ui;

import model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingImageDisplay  extends JPanel implements ImageDisplay {
    private Image currentImage;
    private int width;
    private int height;

    public SwingImageDisplay(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        java.awt.Image scaledImage = imageOf(currentImage).getScaledInstance(-1, height, BufferedImage.SCALE_DEFAULT);

        int x = (this.getWidth() - scaledImage.getWidth(null)) / 2;

        g.drawImage(scaledImage, x, 0, null);
    }

    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
