package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;

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
            g.drawImage(imageOf(currentImage).getScaledInstance(-1, height, BufferedImage.SCALE_DEFAULT), 0, 0, null);
    }

    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    };
}
