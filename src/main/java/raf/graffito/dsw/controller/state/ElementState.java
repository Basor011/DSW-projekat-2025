package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface ElementState {
    void mousePressed(MouseEvent e, Element element);
    void mouseDragged(MouseEvent e, Element element);
    void mouseReleased(MouseEvent e, Element element);
    void mouseClicked(MouseEvent e, Element element);
    void mouseWheelMoved(MouseWheelEvent e, Element element);
}
