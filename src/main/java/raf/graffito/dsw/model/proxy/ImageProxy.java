package raf.graffito.dsw.model.proxy;

import java.awt.image.BufferedImage;

public class ImageProxy implements ImageSubject {
    private RealImage image;
    private final String path;

    public ImageProxy(String path) {
        this.path = path;
    }

    @Override
    public BufferedImage getImage() {
        if(image == null) {
            image = new RealImage(path);
        }
        return image.getImage();
    }
    @Override public String getPath() {return path;}
}
