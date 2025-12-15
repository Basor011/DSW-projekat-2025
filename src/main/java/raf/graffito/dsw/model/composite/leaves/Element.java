package raf.graffito.dsw.model.composite.leaves;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;

import java.awt.*;

abstract public class Element extends GraffNodeLeaf {
    private Point location;
    private Dimension dimension;
    private double rotationAngle = 0;
    private boolean isSelected = false;
    private String type;

    public Element(String name, GraffNode parent, Point location, Dimension dimension, String type) {
        super(name, parent);
        this.location = location;
        this.dimension = dimension;
        this.type = type;
    }

    public Element(String name, GraffNode parent) {
        super(name, parent);
    }

    public abstract Element clone();
    public void setDimensions(int x, int y) {
        int min = 10;
        if(dimension.width+x >= min)dimension.width = dimension.width+x;
        if(dimension.height+y >= min)dimension.height = dimension.height+y;
    }
    public void move(int dx, int dy){
        this.location.x += dx;
        this.location.y += dy;
    }
    public void rotate90(boolean clockwise){
        rotationAngle += Math.toRadians(clockwise ? 90 : -90);
    }
    public void setSelected(boolean selected){
        this.isSelected = selected;
    }
    public Point getLocation() {return location;}
    public Dimension getDimension() {return dimension;}
    public double getRotationAngle() {return rotationAngle;}
    public boolean isSelected() {return isSelected;}
    public String getType() {return type;}
    public Point getCenter() {
        return new Point(
                location.x + dimension.width / 2,
                location.y + dimension.height / 2
        );
    }
}
