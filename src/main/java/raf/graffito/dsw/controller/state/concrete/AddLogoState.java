package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class AddLogoState implements ElementState {
    @Override
    public void mouseClicked(MouseEvent e, Element element) {
        GraffNodeComposite parent = (GraffNodeComposite) element.getParent();
        //LogoElement logo = new LogoElement("logo"+new Random().nextInt(100), parent, e.getX(), e.getY(), 100, 100,0, logoPoints)
        //parent.addChild(logo);
    }
    @Override public void mousePressed(MouseEvent e, Element element) {}
    @Override public void mouseDragged(MouseEvent e, Element element) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
