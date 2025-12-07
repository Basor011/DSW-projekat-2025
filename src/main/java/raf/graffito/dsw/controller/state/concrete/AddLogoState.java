package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AddLogoState implements ElementState {
    private GraffNodeComposite slideNode;
    private SlideView slidePanel;
    private BufferedImage logoImage;

    public AddLogoState(GraffNodeComposite slideNode, SlideView slidePanel, BufferedImage logoImage) {
        this.slideNode = slideNode;
        this.slidePanel = slidePanel;
        this.logoImage = logoImage;
    }
    @Override public void mousePressed(MouseEvent e, Element element) {
        LogoElement le = new LogoElement("Logo"+new Random().nextInt(100), slideNode, e.getPoint(),new Dimension(50,50),0,logoImage);
        slideNode.addChild(le);
        slidePanel.repaint();
    }
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
