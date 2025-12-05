package raf.graffito.dsw.model.composite.leafs;

import raf.graffito.dsw.model.composite.GraffNode;

public class ImageElement extends Element{
    public ImageElement(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public Element copy() {
        return null;
    }

    @Override
    public void removeNode(GraffNode node) {

    }
}
