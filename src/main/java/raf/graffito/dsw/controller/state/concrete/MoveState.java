package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MoveState implements ElementState {
    private int x, y;

    @Override
    public void mousePressed(MouseEvent e, Element element) {
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e, Element element) {
        int dx = e.getX() - x;
        int dy = e.getY() - y;
        element.setX(element.getX() + dx);
        element.setY(element.getY() + dy);
        x = e.getX();
        y = e.getY();
    }
    /// nepotrebni
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
