package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class DeleteState implements ElementState {

    @Override
    public void mouseClicked(MouseEvent e, Element element) {
        GraffNodeComposite parent = (GraffNodeComposite) element.getParent();
        parent.removeChild(element);
    }
    /// nebitni
    @Override public void mousePressed(MouseEvent e, Element element) {}
    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
