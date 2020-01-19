package controller;

import model.Image;
import persistence.FileImageLoader;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String pathname = "INPUT";
        File file = new File(pathname);
        System.out.println("RUTA A CARPETA CON FICHEROS: " + pathname);
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
    
}
