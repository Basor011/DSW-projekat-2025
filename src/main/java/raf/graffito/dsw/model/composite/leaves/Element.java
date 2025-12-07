package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;

import java.awt.*;

abstract public class Element extends GraffNodeLeaf {
    private Point lokacija;
    private Dimension dimenzija;
    //za ugao rotacije
    private double rotation;

    public Element(String name, GraffNode parent, Point lokacija, Dimension dimenzija, double rotation) {
        super(name, parent);
        this.lokacija = lokacija;
        this.dimenzija = dimenzija;
        this.rotation = rotation;
    }

    public abstract Element copy();
    public Point getLokacija() {return lokacija;}
    public void setLokacija(Point lokacija) {this.lokacija = lokacija;}
    public Dimension getDimenzija() {return dimenzija;}
    public void setDimenzija(Dimension dimenzija) {this.dimenzija = dimenzija;}
    public double getRotation() {return rotation;}
    public void setRotation(double rotation) {this.rotation = rotation;}
}
