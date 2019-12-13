package controller;

import java.io.File;
import model.Image;
import persistence.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\ALLES\\Desktopbilder");
        System.out.println("RUTA A CARPETA CON FICHEROS JPG");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
    
}
