package raf.graffito.dsw.gui.swing.tree.decorator;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class ColourDecorator extends NodeDecorator{
    private Color colour;
    public ColourDecorator(GraffTreeItem decoratedItem, Color colour) {
        super(decoratedItem);
        this.colour=colour;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public GraffNode getGraffNode() {
        return decoratedItem.getGraffNode();
    }
    public GraffTreeItem getGraffTreeItem()
    {
        return decoratedItem;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }
}
