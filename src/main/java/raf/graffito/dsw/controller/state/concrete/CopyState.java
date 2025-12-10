package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CopyState implements ElementState {
    @Override
    public void mouseClicked(MouseEvent e, Element element) {
        Element copy = element.clone();
        GraffNodeComposite parent = (GraffNodeComposite) copy.getParent();
        parent.addChild(copy);
    }
    /// nepotrebni

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {

    }

    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
