package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class SelectState implements ElementState {

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        // Selektuj element na osnovu pozicije klika
        Point clickPoint = e.getPoint();
        boolean anySelected = false;

        // Iteriramo kroz sve elemente na slajdu
        for (GraffNode element : slideView.getSlideModel().getChildren()) {
            Element elementToSelect = (Element) element;
            if (isPointInsideElement(clickPoint, (Element) element)) {
                elementToSelect.setSelected(true);
                anySelected = true;
            } else {
                elementToSelect.setSelected(false);
            }
        }

        // Ako nijedan element nije kliknut, poništi selekciju
        if (!anySelected) {
            for (GraffNode element : slideView.getSlideModel().getChildren()) {
                Element elementToSelect = (Element) element;
                elementToSelect.setSelected(false);
            }
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
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
