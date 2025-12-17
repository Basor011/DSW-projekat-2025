package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class ElementView implements Painter {
    protected Element element;

    public ElementView(Element element) {
        this.element = element;
    }

    public void paintWithRotate(Graphics2D g) {
        AffineTransform oldTransform = g.getTransform();

        if (element.getRotationAngle() != 0) {
            Point center  =element.getCenter();
            g.rotate(element.getRotationAngle(), center.x, center.y);
        }
        paint(g);

        g.setTransform(oldTransform);
    }
    public abstract void paint(Graphics2D g);

    public boolean contains(Point p) {
        Element el = getElement();
        int x = el.getLocation().x;
        int y = el.getLocation().y;
        int w = el.getDimension().width;
        int h = el.getDimension().height;

        return (p.x >= x && p.x <= x + w &&
                p.y >= y && p.y <= y + h);
    }
    public void paintSelection(Graphics2D g) {
        if (!element.isSelected()) return;

        int x = element.getLocation().x;
        int y = element.getLocation().y;
        int w = element.getDimension().width;
        int h = element.getDimension().height;

        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(2));
        g.drawRect(x, y, w, h);

    }
    public Rectangle getBounds()
    {
        int x = element.getLocation().x;
        int y = element.getLocation().y;
        int w = element.getDimension().width;
        int h = element.getDimension().height;
        return new Rectangle(x,y,w,h);
    }

    public Element getElement() {
        return element;
    }
}
