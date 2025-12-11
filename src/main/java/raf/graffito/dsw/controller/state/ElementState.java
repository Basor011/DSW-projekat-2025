package raf.graffito.dsw.controller.state;

import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface ElementState {
    void mousePressed(MouseEvent e, SlideView slideView);
    void mouseDragged(MouseEvent e, SlideView slideView);
    void mouseReleased(MouseEvent e, Element element);
    void mouseClicked(MouseEvent e, Element element);
    void mouseWheelMoved(MouseWheelEvent e, SlideView slideView);
}
