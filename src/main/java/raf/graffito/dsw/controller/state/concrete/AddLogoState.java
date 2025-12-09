package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AddLogoState implements ElementState {
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        Point p = e.getPoint();
        Element logo = new LogoElement(
                "Logo",
                slideView.getSlideModel(),
                new Point(p.x, p.y),
                new Dimension(80, 80)
        );

        slideView.addElement(logo);
        slideView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e, Element element) {

    }

    @Override
    public void mouseClicked(MouseEvent e, Element element) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, Element element) {

    }
}
