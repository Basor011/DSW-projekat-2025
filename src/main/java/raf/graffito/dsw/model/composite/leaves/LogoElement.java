package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*;

public class LogoElement extends Element{
    public LogoElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija) {
        super(name, parent, lokacija, dimenzija, "LOGO");
    }
    @Override
    public Element clone() {
        return new LogoElement(getName() + "_COPIED", getParent(), new Point(getLocation().x + 10, getLocation().y + 10), getDimension());
    }
}
