package raf.graffito.dsw.model.composite.leafs;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;
import java.util.List;

public class TextFieldElement extends Element {
    private List<Point> points;
    public TextFieldElement(String name, GraffNode parent) {
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
