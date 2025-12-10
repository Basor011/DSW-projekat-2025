package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;

public class LogoView extends ElementView {
    public LogoView(Element element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        LogoElement le = (LogoElement) element;
        g.setColor(Color.pink);
        Polygon polygon = new Polygon();
        polygon.addPoint(le.getLocation().x, le.getLocation().y);
        polygon.addPoint(le.getLocation().x+le.getDimension().width, le.getLocation().y);
        polygon.addPoint(le.getLocation().x+le.getDimension().width/2,le.getLocation().y+le.getDimension().height);
        g.fillPolygon(polygon);
        paintSelection(g);
    }
}
