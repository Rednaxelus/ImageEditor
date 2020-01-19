package controller;

import ui.ImageDisplay;
import ui.SwingImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel toolbar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private Component prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return actionPerformed -> imageDisplay.show(imageDisplay.current().prev());
    }

    private Component nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return actionPerformed -> imageDisplay.show(imageDisplay.current().next());
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay(1366, 700);
        this.imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

}
