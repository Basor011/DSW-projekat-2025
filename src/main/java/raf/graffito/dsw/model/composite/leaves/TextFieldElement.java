package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class TextFieldElement extends Element {
    private String text;
    private int fontSize;
    public TextFieldElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, double rotation, String text, int fontSize) {
        super(name, parent, lokacija, dimenzija, rotation);
        this.text = text;
        this.fontSize = fontSize;
    }

    @Override
    public Element copy() {
        TextFieldElement e = new TextFieldElement(getName()+"KOPIRANO", null, new Point(getLokacija().x + 10, getLokacija().y + 10), getDimenzija(),getRotation(),text,fontSize);
        return e;
    }

}
