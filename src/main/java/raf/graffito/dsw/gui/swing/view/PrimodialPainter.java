package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.composite.leaves.LogoElement;

import javax.swing.*;
import java.awt.*;

public abstract class PrimodialPainter implements Painter {
    public LogoElement logoElement;
    public Shape shape;

    public PrimodialPainter(LogoElement logoElement) {
        this.logoElement = logoElement;
    }
    public boolean elementAt(Point p) {
        return shape != null && shape.contains(p);
    }

    public Shape getShape() {
        return shape;
    }

    public LogoElement getLogoElement() {
        return logoElement;
    }
}
