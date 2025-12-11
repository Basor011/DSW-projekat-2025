package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.LogoElement;
import raf.graffito.dsw.model.composite.leaves.TipElementa;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AddLogoState implements ElementState {
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        Point p = e.getPoint();
        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr();

        Element logo = (Element) repo.createLogoElement(slideView.getSlideModel(), TipElementa.LOGO, p);
        slideView.getSlideModel().addChild(logo);
        slideView.addElement(logo);
        MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(logo));
        slideView.repaint();
        MainFrame.getInstance().getRightPanel().startSelectState();

        slideView.addElement(logo);
        slideView.repaint();
    }

    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, Element element) {}
}
