package raf.graffito.dsw.model.composite.leafs;

import raf.graffito.dsw.model.composite.GraffNode;

import java.awt.*; ///point bi mogao biti ne preko biblioteke vec preko posebne klase
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogoElement extends Element{
    private List<Point> points;

    public LogoElement(String name, GraffNode parent, int x, int y, int width, int height, double rotation, List<Point> points) {
        super(name, parent, x, y, width, height, rotation);
        this.points = Collections.unmodifiableList(points); //da budemo sigurni da se nece menjati logo
    }

    @Override
    public Element copy() {
        LogoElement e = new LogoElement(getName() + "KOPIRANO", null, getX()+4, getY()+4, getWidth(), getHeight(), getRotation(), new ArrayList<>(points));
        return e;
    }


    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
