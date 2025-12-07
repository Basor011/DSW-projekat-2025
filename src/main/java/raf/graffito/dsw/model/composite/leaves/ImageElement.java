package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class ImageElement extends Element{
    private String imagePath;

    public ImageElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, double rotation, String imagePath) {
        super(name, parent,lokacija, dimenzija, rotation);
        this.imagePath = imagePath;
    }
    @Override
    public Element copy() {
        ImageElement e = new ImageElement(getName() + "KOPIRANO", null, new Point(getLokacija().x + 10, getLokacija().y + 10), getDimenzija(), getRotation(), imagePath);
        return e;
    }

}
