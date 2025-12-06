package raf.graffito.dsw.model.composite.leafs;

import raf.graffito.dsw.model.composite.GraffNode;

public class ImageElement extends Element{
    private String imagePath;

    public ImageElement(String name, GraffNode parent, int x, int y, int width, int height, double rotation, String imagePath) {
        super(name, parent, x, y, width, height, rotation);
        this.imagePath = imagePath;
    }
    @Override
    public Element copy() {
        ImageElement e = new ImageElement(getName() + "KOPIRANO", getParent(), getX() + 4, getY() + 4, getWidth(), getHeight(), getRotation(), imagePath);
        return e;
    }

}
