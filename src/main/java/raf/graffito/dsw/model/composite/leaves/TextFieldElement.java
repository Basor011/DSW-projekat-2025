package raf.graffito.dsw.model.composite.leaves;

import org.w3c.dom.Text;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;

import java.awt.*;

public class TextFieldElement extends Element {
    private String text;

    public TextFieldElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, String text) {
        super(name, parent, lokacija, dimenzija, "TEXTFIELD");
        this.text = text;
    }

    public TextFieldElement(String name, GraffNode parent) {
        super(name, parent);
        this.text = "";
    }

    @Override
    public Element clone() {
        return new TextFieldElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension(), text);
    }
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
}
