package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;

import java.awt.*;
import java.util.Random;

public class ImageElementNodeFactory implements ElementNodeFactory {
    private String imagePath;

    public ImageElementNodeFactory(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public Element createElement(Slide parent, Point location) {
        return new ImageElement("Image"+ new Random().nextInt(100), parent, location, new Dimension(120, 90),imagePath);
    }
}
