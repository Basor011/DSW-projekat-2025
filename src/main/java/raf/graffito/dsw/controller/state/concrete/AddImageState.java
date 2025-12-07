package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class AddImageState implements ElementState {
    private SlideView slidePanel;
    private GraffNodeComposite slideNode;
    private String imagePath;

    public AddImageState(SlideView slidePanel, GraffNodeComposite slideNode, String imagePath) {
        this.slidePanel = slidePanel;
        this.slideNode = (GraffNodeComposite) slideNode;
        this.imagePath = imagePath;
    }
    @Override
    public void mousePressed(MouseEvent e, Element element) {
        ImageElement img = new ImageElement("Image"+new Random().nextInt(100),slideNode,e.getPoint(),new Dimension(100,100), 0, imagePath);
        slideNode.addChild(img);
        slidePanel.repaint();
    }
    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
