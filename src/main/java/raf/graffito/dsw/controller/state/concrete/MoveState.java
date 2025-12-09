package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ImageView;
import raf.graffito.dsw.gui.swing.view.slide_elements.LogoView;
import raf.graffito.dsw.gui.swing.view.slide_elements.TextFieldVIew;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MoveState implements ElementState {
    private boolean dragging = false;
    private Point start;

    private ElementView element;

    private SlideView panel;

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        if(element.contains(e.getPoint())) {
            dragging = true;
            start = e.getPoint();
        }
        panel.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging) return;

        int dx = e.getX() - start.x;
        int dy = e.getY() - start.y;

        element.getElement().move(dx, dy);

        start = e.getPoint();
        panel.repaint();
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {
        dragging = false;
        panel.repaint();
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
