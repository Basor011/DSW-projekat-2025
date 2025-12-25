package raf.graffito.dsw.model.composite.leaves;

import org.w3c.dom.Text;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;

import java.awt.*;

public class TextFieldElement extends Element {
    private String text;
    private int fontSize = 16;
    protected TextFieldElement(){}
    public TextFieldElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija, String text) {
        super(name, parent, lokacija, dimenzija, "TEXTFIELD");
        this.text = text;
    }

    @Override
    public Element clone() {
        TextFieldElement copy = new TextFieldElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension(), text);
        copy.fontSize = fontSize;
        return copy;
    }
    public void changeFontSize(int delta) {
        this.fontSize = Math.max(8, fontSize + delta);
        notifyParent();
    }
    public void setFontSize(int fontSize) {
        this.fontSize = Math.max(8, fontSize);
        notifyParent();
    }
    public String getText() {return text;}
    public int getFontSize() {return fontSize;}
}
