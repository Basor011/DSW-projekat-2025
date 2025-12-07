package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

public class TextFieldElement extends Element {
    private String text;
    private int fontSize;
    public TextFieldElement(String name, GraffNode parent, int x, int y, int width, int height, double rotation, String text, int fontSize) {
        super(name, parent, x, y, width, height, rotation);
        this.text = text;
        this.fontSize = fontSize;
    }

    @Override
    public Element copy() {
        TextFieldElement e = new TextFieldElement(getName()+"KOPIRANO", null, getX()+4, getY(),getWidth(),getHeight(),getRotation(),text,fontSize);
        return e;
    }

}
