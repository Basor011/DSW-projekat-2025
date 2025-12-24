package raf.graffito.dsw.model.proxy;

import raf.graffito.dsw.core.ApplicationFramework;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RealImage implements ImageSubject {
    private BufferedImage image;
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImage();
    }
    private void loadImage() {
        try{
            image = ImageIO.read(new File(filename));
        }catch(Exception e){
            image = null;
            ApplicationFramework.getInstance().getMg().generateInfo("slika ne postoji");
        }
    }

    @Override public BufferedImage getImage() {return image;}
    @Override public String getPath() {return filename;}
}
