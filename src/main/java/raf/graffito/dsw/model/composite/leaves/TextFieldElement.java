package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class TextFieldElement extends Element {
    private String text;
    private int fontSize;

    public TextFieldElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, String text, int fontSize) {
        super(name, parent, lokacija, dimenzija, "TEXTFIELD");
        this.text = text;
        this.fontSize = fontSize;
    }

    @Override
    public Prototype clone() {
        TextFieldElement e = new TextFieldElement(getName()+"_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension(),text,fontSize);
        return e;
    }

    public String getText() {return text;}
    public int getFontSize() {return fontSize;}
}
