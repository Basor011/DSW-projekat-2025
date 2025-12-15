package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class TextFieldElement extends Element {
    private String text;
    private int fontSize;

    public TextFieldElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija) {
        super(name, parent, lokacija, dimenzija, "TEXTFIELD");
    }

    public TextFieldElement(String name, GraffNode parent, Point location, Dimension dimension, String text) {
        super(name, parent, location, dimension, "TEXTFIELD");
        this.text = text;
    }

    public TextFieldElement(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public Element clone() {
        return new TextFieldElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension());
    }

    public String getText() {return text;}
    public int getFontSize() {return fontSize;}
}
