package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

public class SelectState implements ElementState {

    @Override public void mousePressed(MouseEvent e, SlideView slideView) {
        List<GraffNode> elements = slideView.getSlideModel().getChildren();

        for (GraffNode el : elements) {
            Element element = (Element) el;
            element.setSelected(false);
        }
        ElementView clickedView = slideView.getElementAt(e.getPoint());
        if (clickedView != null) {
            Element clickedModel = clickedView.getElement();
            clickedModel.setSelected(true);
        }
        slideView.repaint();
    }
    private boolean isPointInsideElement(Point p, Element element) {
        Rectangle bounds = new Rectangle(
                element.getLocation().x,
                element.getLocation().y,
                element.getDimension().width,
                element.getDimension().height
        );
        return bounds.contains(p);
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView){}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
