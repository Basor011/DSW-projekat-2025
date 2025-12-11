package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class DeleteState implements ElementState {

    @Override
    public void mouseClicked(MouseEvent e, Element element) {
        System.out.println("testing 123");

        GraffNodeComposite parent = (GraffNodeComposite) element.getParent();
        parent.removeChild(element);
    }
    /// nebitni


    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView clicked = slideView.getElementAt(e.getPoint());
        System.out.println(clicked + " element");
        if(clicked != null) {
            System.out.println("Deleting element: " + clicked.getElement());
            Element element = clicked.getElement();
            GraffNodeComposite parent = (GraffNodeComposite) element.getParent();
            parent.removeChild(element);
            slideView.getElementViewMap().remove(element);
            slideView.repaint();
        }
    }




    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
