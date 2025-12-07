package raf.graffito.dsw.gui.swing.tree.view.painter;

import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;

public class LogoElementPainter implements Painter {
    private LogoElement model;
    public LogoElementPainter(LogoElement model) {
        this.model = model;
    }

    @Override
    public void paint(Graphics2D g) {

        Polygon p = new Polygon();

        g.translate(model.getX(), model.getY());
        g.rotate(model.getRotation());
        g.scale(model.getWidth(), model.getHeight());

        for(Point pt : model.getPoints()) {
            p.addPoint(pt.x, pt.y);
        }

        g.setColor(Color.PINK);
        g.fillPolygon(p);
        g.setColor(Color.BLACK);
        g.drawPolygon(p);
    }
}
