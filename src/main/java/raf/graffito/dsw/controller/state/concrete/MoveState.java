package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MoveState implements ElementState {
    private boolean dragging = false;
    private Point start;

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());

        if (view != null && view.getElement().isSelected()) {
            dragging = true;
            start = e.getPoint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, SlideView slideView) {
        if (!dragging) return;

        int dx = e.getX() - start.x;
        int dy = e.getY() - start.y;

        for(GraffNode gf: slideView.getSlideModel().getChildren()){
            Element el = (Element) gf;
            if(el.isSelected()){
                el.move(dx, dy);
            }
        }
        start = e.getPoint();
        slideView.repaint();
    }
    @Override public void mouseReleased(MouseEvent e, Element element) {dragging = false;}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
