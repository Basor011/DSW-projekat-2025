package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ResizeElementState implements ElementState {
    private boolean dragging = false;
    private Point start;
    private ElementView activeView;
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());

        if (view != null && view.getElement().isSelected()) {
            dragging = true;
            start = e.getPoint();
            activeView = view;
        }
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {
        if (!dragging) return;

        int dx = e.getX() - start.x;
        int dy = e.getY() - start.y;

        activeView.getElement().setDimensions(dx, dy);

        start = e.getPoint();
        slideView.repaint();
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {
        dragging = false;
        activeView = null;
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
