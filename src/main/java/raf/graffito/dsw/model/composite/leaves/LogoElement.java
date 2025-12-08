package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*; ///point bi mogao biti ne preko biblioteke vec preko posebne klase
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogoElement extends Element{
    private BufferedImage logo;
    public LogoElement(String name, GraffNode parent, Point lokacija, Dimension dimenzija,double rotation, BufferedImage logo) {
        super(name, parent, lokacija, dimenzija, rotation);
        this.logo = logo;
    }

    @Override
    public Element copy() {
        LogoElement e = new LogoElement(getName() + "KOPIRANO", null, new Point(getLokacija().x + 10, getLokacija().y + 10), getDimenzija(), getRotation(), logo);
        return e;
    }

    public BufferedImage getLogo() {
        return logo;
    }
}
