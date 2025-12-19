package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;

import java.awt.*;

public class ImageElement extends Element{
    private String imagePath;

    public ImageElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, String imagePath) {
        super(name, parent,lokacija, dimenzija, "IMAGE");
        this.imagePath = imagePath;
    }

    public ImageElement(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public Element clone() {

        return new ImageElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension(), imagePath);
    }
    public String getImagePath() {return imagePath;}
}
