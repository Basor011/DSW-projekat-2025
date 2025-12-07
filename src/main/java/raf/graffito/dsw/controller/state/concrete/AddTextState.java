package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class AddTextState implements ElementState {
    private SlideView slidePanel;
    private GraffNodeComposite slideNode;

    public AddTextState(SlideView slidePanel, GraffNodeComposite slideNode) {
        this.slidePanel = slidePanel;
        this.slideNode = slideNode;
    }
    @Override public void mousePressed(MouseEvent e, Element element) {
        String text = JOptionPane.showInputDialog(slidePanel, "Enter text");
        if(text != null) {
            TextFieldElement tfe = new TextFieldElement("text"+new Random().nextInt(100),slideNode, e.getPoint(), new Dimension(100, 10), 0, text,10);
            slideNode.addChild(tfe);
            slidePanel.repaint();
        }
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
