package raf.graffito.dsw.model.composite.leaves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.compositions.Slide;

import java.awt.*;
@JsonIgnoreProperties({"center"})
abstract public class Element extends GraffNodeLeaf {
    private Point location;
    private Dimension dimension;
    private double rotationAngle = 0;
    private boolean isSelected = false;
    private String type;
    protected Element(){}
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
    private void notifyParent() {
        if (getParent() instanceof Slide slide) {
            slide.notifySubscribers();
        }
    }
    public void setDimensions(int x, int y) {
        int min = 10;
        dimension.width = Math.max(min, x);
        dimension.height = Math.max(min, y);
        notifyParent();
    }
    public void resize(int width, int height) {
        setDimensions(dimension.width + width, dimension.height + height);
    }
    public void move(int dx, int dy){
        this.location.x += dx;
        this.location.y += dy;
        notifyParent();
    }
    public void rotate90(boolean clockwise){
        rotationAngle += Math.toRadians(clockwise ? 90 : -90);
        notifyParent();
    }
    public void setSelected(boolean selected){
        this.isSelected = selected;
        notifyParent();
    }
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
        notifyParent();
    }
    public void setLocationa(Point p) {
        this.location.setLocation(p);
        notifyParent();
    }
    public Point getLocation() {return location;}
    public Dimension getDimension() {return dimension;}
    public double getRotationAngle() {return rotationAngle;}
    public boolean isSelected() {return isSelected;}
    public String getType() {return type;}
    public Point getCenter() {return new Point(location.x + dimension.width / 2, location.y + dimension.height / 2);}
}
