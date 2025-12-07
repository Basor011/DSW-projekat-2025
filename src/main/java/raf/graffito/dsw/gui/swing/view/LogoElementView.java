package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

public class LogoElementView {
    private LogoElement model;

    public LogoElementView(LogoElement model) {
        this.model = model;
    }
    public void paint(Graphics2D g) {
        AffineTransform og = g.getTransform(); //cuvamo stari
        g.translate(model.getX(), model.getY()); //translacija na poziciju modela
        g.rotate(model.getRotation(), model.getWidth()/2, model.getHeight()/2);//rotacija oko centra elementa
        g.setColor(Color.PINK);
        g.setStroke(new BasicStroke(3));
        List<Point> points = model.getPoints();
        for (Point p : points) {

        }
    }
}
