package raf.graffito.dsw.gui.swing.view.painter;

import raf.graffito.dsw.model.composite.leafs.LogoElement;

import java.awt.*;
import java.util.List;

public class LogoElementPainter implements Painter {
    private LogoElement model;
    public LogoElementPainter(LogoElement model) {
        this.model = model;
    }

    @Override
    public void paint(Graphics2D g) {
        List<Point> points = model.getPoints();
    }
}
