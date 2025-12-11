package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AddTextFieldState implements ElementState {
    private String defaultText = "New Text";

    public void setDefaultText(String text) {
        this.defaultText = text;
    }
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        Point p = e.getPoint();

        Element txt = new TextFieldElement(
                "Text",
                slideView.getSlideModel(),
                new Point(p.x, p.y),
                new Dimension(150, 30),defaultText
        );

        slideView.addElement(txt);
        slideView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e, SlideView slideView) {

    }

    @Override
    public void mouseReleased(MouseEvent e, Element element) {

    }

    @Override
    public void mouseClicked(MouseEvent e, Element element) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {

    }
}
