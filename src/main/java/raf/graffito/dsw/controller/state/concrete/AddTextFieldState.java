package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class AddTextFieldState implements ElementState {
    private SlideView slideView;
    private GraffNodeComposite slideNode;

    public AddTextFieldState(SlideView slideView, GraffNodeComposite slideNode) {
        this.slideView = slideView;
        this.slideNode = slideNode;
    }

    @Override
    public void mousePressed(MouseEvent e, Element element) {
        TextFieldElement tfe = new TextFieldElement("TextField"+ new Random().nextInt(200),slideNode, e.getPoint(), new Dimension(200,40));
        slideNode.addChild(tfe);
        slideView.repaint();
    }

    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
