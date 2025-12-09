package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;

public abstract class ElementView implements Painter {
    protected Element element;

    public ElementView(Element element) {
        this.element = element;
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

        // Opcioni resize handle-ovi
        int size = 6;
        g.fillRect(x - size / 2, y - size / 2, size, size);
        g.fillRect(x + w - size / 2, y - size / 2, size, size);
        g.fillRect(x - size / 2, y + h - size / 2, size, size);
        g.fillRect(x + w - size / 2, y + h - size / 2, size, size);
    }


    public Element getElement() {
        return element;
    }
}
