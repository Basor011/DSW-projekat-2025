package raf.graffito.dsw.model.composite.leaves;

import org.w3c.dom.Text;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;

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
        TextFieldElement txf = new TextFieldElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension());
        if (getParent() instanceof Slide slide){
            slide.notifySubscribers();
        }
        return txf;
    }

    public String getText() {return text;}
    public int getFontSize() {return fontSize;}
}
