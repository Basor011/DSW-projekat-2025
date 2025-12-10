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
    public abstract Element clone();
    public void setDimensions(int x, int y) {
        this.getDimension().width = Math.max(10, this.getDimension().width + x);
        this.getDimension().height = Math.max(10, this.getDimension().height + y);
    }
    public void move(int dx, int dy){
        this.location.x += dx;
        this.location.y += dy;
    }
    public void resize(int width, int height){
        this.dimension.width += width;
        this.dimension.height += height;
    }
    public void rotate90(boolean clockwise){
        rotationAngle += Math.toRadians(clockwise ? -90 : 90);
    }
    public void setSelected(boolean selected){
        this.isSelected = selected;
    }
    public Point getLocation() {return location;}
    public Dimension getDimension() {return dimension;}
    public double getRotationAngle() {return rotationAngle;}
    public boolean isSelected() {return isSelected;}
    public String getType() {return type;}
}
